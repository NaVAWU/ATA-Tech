package nl.naimv.atatech;

import net.fabricmc.api.ModInitializer;
import nl.naimv.atatech.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ATATech implements ModInitializer {
	public static final String MOD_ID = "atatech";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}
