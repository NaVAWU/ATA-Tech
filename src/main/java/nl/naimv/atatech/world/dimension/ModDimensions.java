package nl.naimv.atatech.world.dimension;

import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import nl.naimv.atatech.ATATech;
import nl.naimv.atatech.block.ModBlocks;
import nl.naimv.atatech.item.ModItems;

public class ModDimensions {


    public static void register(){
        ATATech.LOGGER.debug("Registering ModDimensions for " + ATATech.MOD_ID);

        //new CustomPortalBlock(AbstractBlock.Settings.of(Material.METAL)) = Blocks.IRON_BARS;

        CustomPortalBuilder.beginPortal()
                .frameBlock(ModBlocks.WORMHOLE_FRAME)
                .destDimID(new Identifier("the_end"))
                .tintColor(0,0,0)
                .lightWithItem(ModItems.MERICAN_CHEESE)
                .forcedSize(5,5)
        //        .customPortalBlock(new CustomPortalBlock(AbstractBlock.Settings.of(Blocks.IRON_BARS.getDefaultState().getMaterial())))
                .registerPortal();
    }
}
