package nl.naimv.atatech.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PropaguleBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class GrateBlock extends Block {

    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public GrateBlock(Settings settings) {
        super(settings);
    }

    private  static final VoxelShape SHAPE_N = Stream.of(
            Block.createCuboidShape(4, 0, 2, 5, 2, 7),
            Block.createCuboidShape(4, 0, 9, 5, 2, 14),
            Block.createCuboidShape(7, 0, 9, 9, 2, 14),
            Block.createCuboidShape(7, 0, 2, 9, 2, 7),
            Block.createCuboidShape(11, 0, 2, 12, 2, 7),
            Block.createCuboidShape(11, 0, 9, 12, 2, 14),
            Block.createCuboidShape(2, 0, 7, 14, 2, 9),
            Block.createCuboidShape(14, 0, 2, 16, 2, 14),
            Block.createCuboidShape(0, 0, 2, 2, 2, 14),
            Block.createCuboidShape(0, 0, 14, 16, 2, 16),
            Block.createCuboidShape(0, 0, 0, 16, 2, 2)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private  static final VoxelShape SHAPE_S = Stream.of(
            Block.createCuboidShape(11, 0, 9, 12, 2, 14),
            Block.createCuboidShape(11, 0, 2, 12, 2, 7),
            Block.createCuboidShape(7, 0, 2, 9, 2, 7),
            Block.createCuboidShape(7, 0, 9, 9, 2, 14),
            Block.createCuboidShape(4, 0, 9, 5, 2, 14),
            Block.createCuboidShape(4, 0, 2, 5, 2, 7),
            Block.createCuboidShape(2, 0, 7, 14, 2, 9),
            Block.createCuboidShape(0, 0, 2, 2, 2, 14),
            Block.createCuboidShape(14, 0, 2, 16, 2, 14),
            Block.createCuboidShape(0, 0, 0, 16, 2, 2),
            Block.createCuboidShape(0, 0, 14, 16, 2, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private  static final VoxelShape SHAPE_E = Stream.of(
            Block.createCuboidShape(9, 0, 4, 14, 2, 5),
            Block.createCuboidShape(2, 0, 4, 7, 2, 5),
            Block.createCuboidShape(2, 0, 7, 7, 2, 9),
            Block.createCuboidShape(9, 0, 7, 14, 2, 9),
            Block.createCuboidShape(9, 0, 11, 14, 2, 12),
            Block.createCuboidShape(2, 0, 11, 7, 2, 12),
            Block.createCuboidShape(7, 0, 2, 9, 2, 14),
            Block.createCuboidShape(2, 0, 14, 14, 2, 16),
            Block.createCuboidShape(2, 0, 0, 14, 2, 2),
            Block.createCuboidShape(0, 0, 0, 2, 2, 16),
            Block.createCuboidShape(14, 0, 0, 16, 2, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();

    private  static final VoxelShape SHAPE_W = Stream.of(
            Block.createCuboidShape(2, 0, 11, 7, 2, 12),
            Block.createCuboidShape(9, 0, 11, 14, 2, 12),
            Block.createCuboidShape(9, 0, 7, 14, 2, 9),
            Block.createCuboidShape(2, 0, 7, 7, 2, 9),
            Block.createCuboidShape(2, 0, 4, 7, 2, 5),
            Block.createCuboidShape(9, 0, 4, 14, 2, 5),
            Block.createCuboidShape(7, 0, 2, 9, 2, 14),
            Block.createCuboidShape(2, 0, 0, 14, 2, 2),
            Block.createCuboidShape(2, 0, 14, 14, 2, 16),
            Block.createCuboidShape(14, 0, 0, 16, 2, 16),
            Block.createCuboidShape(0, 0, 0, 2, 2, 16)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR)).get();
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context){
        switch (state.get(FACING)){
            case NORTH:
                return SHAPE_N;
            case SOUTH:
                return SHAPE_S;
            case EAST:
                return SHAPE_E;
            case WEST:
                return SHAPE_W;
            default:
                return SHAPE_N;
        }
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx){
        return this.getDefaultState().with(FACING,ctx.getPlayerFacing().getOpposite());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return super.rotate(state, rotation);
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block,BlockState> builder){
        builder.add(FACING);
    }

}


