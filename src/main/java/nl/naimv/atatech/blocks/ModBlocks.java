package nl.naimv.atatech.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import nl.naimv.atatech.ATATech;
import nl.naimv.atatech.item.ModItemGroup;


public class ModBlocks {

    public static final Block WORMHOLE_FRAME = registerBlock("wormhole_frame",
            new Block(FabricBlockSettings.of(Material.METAL).strength(8f).requiresTool()), ModItemGroup.ATATECH);
    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registry.BLOCK, new Identifier(ATATech.MOD_ID,name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group){

        return Registry.register(Registry.ITEM, new Identifier(ATATech.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings().group(group)));
    }

    public static void registerModBlocks() {
        ATATech.LOGGER.info("RegisteringMobBlocks for " + ATATech.MOD_ID);
    }
}
