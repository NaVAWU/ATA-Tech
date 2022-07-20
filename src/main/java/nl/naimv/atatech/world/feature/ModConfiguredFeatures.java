package nl.naimv.atatech.world.feature;

import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import nl.naimv.atatech.ATATech;
import nl.naimv.atatech.block.ModBlocks;
import nl.naimv.atatech.util.ModTags;

import java.io.ObjectInputFilter;
import java.util.List;

public class ModConfiguredFeatures {
    public static final RuleTest BAUXITE_ORE_REPLACEABLES = new TagMatchRuleTest(ModTags.Blocks.BAUXITE);

    public static final List<OreFeatureConfig.Target> OVERWORLD_ILMENITE_ORE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.ILMENITE_ORE.getDefaultState()),
            OreFeatureConfig.createTarget(OreConfiguredFeatures.DEEPSLATE_ORE_REPLACEABLES,ModBlocks.DEEPSLATE_ILMENITE_ORE.getDefaultState())
    );

    public static final List<OreFeatureConfig.Target> OVERWORLD_BAUXITE = List.of(
            OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ModBlocks.BAUXITE.getDefaultState())
    );

    public static final List<OreFeatureConfig.Target> OVERWORLD_BAUXITE_ORE = List.of(
            OreFeatureConfig.createTarget(BAUXITE_ORE_REPLACEABLES, ModBlocks.BAUXITE_ORE.getDefaultState())
    );

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> BAUXITE =
            ConfiguredFeatures.register("bauxite", Feature.ORE,new OreFeatureConfig(OVERWORLD_BAUXITE, 40));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> BAUXITE_ORE =
            ConfiguredFeatures.register("bauxite_ore", Feature.ORE,new OreFeatureConfig(OVERWORLD_BAUXITE_ORE, 9));

    public static final RegistryEntry<ConfiguredFeature<OreFeatureConfig, ?>> ILMENITE_ORE =
            ConfiguredFeatures.register("ilmenite_ore", Feature.ORE,new OreFeatureConfig(OVERWORLD_ILMENITE_ORE,9));


    public static void registerConfiguredFeatures(){
        ATATech.LOGGER.debug("Registering the ModConfiguredFeatures for " + ATATech.MOD_ID);
    }


}