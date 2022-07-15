package nl.naimv.atatech.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import nl.naimv.atatech.ATATech;
import nl.naimv.atatech.item.custom.MericanCheeseItem;

public class ModItems {
    public static final Item MERICAN_CHEESE = registerItem("merican_cheese",
            new MericanCheeseItem(new FabricItemSettings().food(ModFoodComponents.MERICAN_CHEESE).group(ModItemGroup.ATATECH)));


    public static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(ATATech.MOD_ID, name), item);
    }

    public static void registerModItems() {
        ATATech.LOGGER.info("Registering items for " + ATATech.MOD_ID);
    }
}
