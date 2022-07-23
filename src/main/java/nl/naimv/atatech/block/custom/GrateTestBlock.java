package nl.naimv.atatech.block.custom;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import javax.annotation.Nullable;

    public class GrateTestBlock extends SlabBlock    {
        public static final EnumProperty<SlabType> TYPE = Properties.SLAB_TYPE;
        protected static final VoxelShape SHAPE_BOT = Block.createCuboidShape(0, 0, 0, 16, 2, 16); //This is a bottom shape.
        protected static final VoxelShape SHAPE_TOP = Block.createCuboidShape(0, 14, 0, 16, 16, 16); //This is a top shape.
        protected static final VoxelShape SHAPE_COM = VoxelShapes.union(SHAPE_BOT, SHAPE_TOP); //This is a combined shape



        public GrateTestBlock(Settings settings) {
            super(settings);
            this.setDefaultState(this.getDefaultState().with(TYPE, SlabType.BOTTOM));
        }

//        @Override
//        public boolean hasSidedTransparency(BlockState state) {
//            return true;
//        }

        @Override
        public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
        {
            SlabType slabType = state.get(TYPE);
            return switch (slabType) {
                case DOUBLE -> SHAPE_COM;
                case TOP -> SHAPE_TOP;
                default -> SHAPE_BOT;
            };
        }

//        @Override
//        @Environment(EnvType.CLIENT)
//        @SuppressWarnings("deprecation")
//        public boolean isSideInvisible(BlockState state, BlockState neighbourState, Direction dir)
//        {
//            if (neighbourState.getBlock() == atatech.block.grate) return true;
//            if (neighbourState.getBlock() == this) if (slabSideInvisible(state, neighbourState, dir)) return true;
//
//            return super.isSideInvisible(state, neighbourState, dir);
//        }

//        private boolean slabSideInvisible(BlockState slabState, BlockState neighbourState, Direction dir)
//        {
//            SlabType slabType = slabState.get(TYPE);
//            SlabType neighbourType = neighbourState.get(TYPE);
//
//            if (neighbourType == SlabType.DOUBLE) return true;
//
//            switch (dir)
//            {
//                case NORTH: case SOUTH: case EAST: case WEST:
//                if(slabType == neighbourType) return true;
//                default:
//                    break;
//            }
//
//            return false;
//        }

        @Nullable
        @Override
        public BlockState getPlacementState(ItemPlacementContext ctx)
        {
            BlockPos blockPos = ctx.getBlockPos();
            BlockState blockState = ctx.getWorld().getBlockState(blockPos);
            if (blockState.isOf(this)) {
                return blockState.with(TYPE, SlabType.DOUBLE);
            } else {
                BlockState blockState2 = this.getDefaultState().with(TYPE, SlabType.BOTTOM);
                Direction direction = ctx.getSide();
                return direction != Direction.DOWN && (direction == Direction.UP || !(ctx.getHitPos().y - (double)blockPos.getY() > 0.5D)) ? blockState2 : blockState2.with(TYPE, SlabType.TOP);
            }
        }

        @Override
        @SuppressWarnings("deprecation")
        public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context)
        {
            SlabType type = state.get(TYPE);
            return switch (type) {
                case DOUBLE -> SHAPE_COM;
                case TOP -> SHAPE_TOP;
                default -> SHAPE_BOT;
            };
        }

        @Environment(EnvType.CLIENT)
        @Override
        @SuppressWarnings("deprecation")
        public float getAmbientOcclusionLightLevel(BlockState state, BlockView world, BlockPos pos)
        {
            return 1.0F;
        }

        @Override
        public boolean isTranslucent(BlockState state, BlockView world, BlockPos pos)
        {
            return true;
        }
    }
