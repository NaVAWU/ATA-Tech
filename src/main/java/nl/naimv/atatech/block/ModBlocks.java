package nl.naimv.atatech.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import nl.naimv.atatech.ATATech;
import nl.naimv.atatech.block.custom.TooltipBlock;
import nl.naimv.atatech.item.ModItemGroup;


public class ModBlocks {

    public static final Block WORMHOLE_FRAME = registerBlock("wormhole_frame",
            new Block(FabricBlockSettings.of(Material.METAL).strength(8f).requiresTool()), ModItemGroup.ATATECH);

    public static final Block BAUXITE_ORE = registerBlock("bauxite_ore",
            new TooltipBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(), "block.atatech.bauxite_ore.tooltip"), ModItemGroup.ATATECH);

    public static final Block BAUXITE = registerBlock("bauxite",
            new TooltipBlock(FabricBlockSettings.of(Material.STONE).strength(2f).requiresTool(), "block.atatech.bauxite.tooltip"), ModItemGroup.ATATECH);

    public static final Block BAUXITE_BRICKS = registerBlock("bauxite_bricks",
            new TooltipBlock(FabricBlockSettings.of(Material.STONE).strength(2f).requiresTool(), "block.atatech.bauxite_bricks.tooltip"), ModItemGroup.ATATECH);

    public static final Block ALUMINUM_BLOCK = registerBlock("aluminum_block",
            new TooltipBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool(), "block.atatech.aluminum_block.tooltip"), ModItemGroup.ATATECH);

    public static final Block TITANIUM_BLOCK = registerBlock("titanium_block",
            new Block(FabricBlockSettings.of(Material.METAL).strength(4f)),ModItemGroup.ATATECH);

    public static final Block ILMENITE_ORE = registerBlock("ilmenite_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f)),ModItemGroup.ATATECH);

    public static final Block DEEPSLATE_ILMENITE_ORE = registerBlock("deepslate_ilmenite_ore",
            new Block(FabricBlockSettings.of(Material.STONE).strength(4f)),ModItemGroup.ATATECH);
    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(ATATech.MOD_ID,name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group){

        return Registry.register(Registry.ITEM, new Identifier(ATATech.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        ATATech.LOGGER.info("Registering ModBlocks for " + ATATech.MOD_ID);
    }
}