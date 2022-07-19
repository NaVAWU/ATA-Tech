package nl.naimv.atatech.world.feature;

import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import nl.naimv.atatech.ATATech;
import nl.naimv.atatech.block.ModBlocks;

import java.io.ObjectInputFilter;
import java.util.List;

public class ModConfiguredFeatures {

    public static final List<OreFeatureConfig.Target> OVERWORLD_ILMENITE_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ILMENITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,ModBlocks.DEEPSLATE_ILMENITE_ORE.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ILMENITE_ORE =
            ConfiguredFeatures.register("ilmenite_ore", Feature.ORE,new OreFeatureConfig(OVERWORLD_ILMENITE_ORE,9));


    public static void registerConfiguredFeatures(){
        ATATech.LOGGER.debug("Registering the ModConfiguredFeatures for " + ATATech.MOD_ID);
    }

}
