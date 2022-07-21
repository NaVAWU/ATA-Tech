package nl.naimv.atatech.painting;

import net.minecraft.entity.decoration.painting.PaintingVariant;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import nl.naimv.atatech.ATATech;

public class ModPaintings {
    public static final PaintingVariant SHIP = registerPainting("ship", new PaintingVariant(32, 32));

    private static PaintingVariant registerPainting(String name, PaintingVariant paintingVariant) {
        return Registry.register(Registry.PAINTING_VARIANT, new Identifier(ATATech.MOD_ID, name), paintingVariant);
    }

    public static void registerPaintings() {
        ATATech.LOGGER.debug("Registering Paintings for " + ATATech.MOD_ID);
    }
}
