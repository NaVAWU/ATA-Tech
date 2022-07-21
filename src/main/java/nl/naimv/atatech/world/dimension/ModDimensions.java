package nl.naimv.atatech.world.dimension;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import nl.naimv.atatech.ATATech;
import nl.naimv.atatech.block.ModBlocks;
import nl.naimv.atatech.item.ModItems;

public class ModDimensions {
    public static final RegistryKey<World> SPST_DIMENSION_KEY = RegistryKey.of(Registry.WORLD_KEY,
            new Identifier(ATATech.MOD_ID, "spst"));

    public static final RegistryKey<DimensionType> SPST_TYPE_KEY = RegistryKey.of(Registry.DIMENSION_TYPE_KEY, SPST_DIMENSION_KEY.getValue());


    public static void register(){
        ATATech.LOGGER.debug("Registering ModDimensions for " + ATATech.MOD_ID);

        //new CustomPortalBlock(AbstractBlock.Settings.of(Material.METAL)) = Blocks.IRON_BARS;

        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.WORMHOLE_FRAME)
                .destDimID(new Identifier("atatech:dimension/spst"))
                .tintColor(0,0,0)
                .lightWithItem(ModItems.MERICAN_CHEESE)
                .forcedSize(5,5)
        //        .customPortalBlock(new CustomPortalBlock(AbstractBlock.Settings.of(Blocks.IRON_BARS.getDefaultState().getMaterial())))
                .registerPortal();
    }
}
