package cn.meowwow520.mcmod;

import cn.meowwow520.mcmod.Items.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreDangerousCreeper implements ModInitializer {
	public static final String MOD_ID = "more_dangerous_creeper";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Hello More Dangerous Creeper!");
		ModItems.registerModItems();
	}
}