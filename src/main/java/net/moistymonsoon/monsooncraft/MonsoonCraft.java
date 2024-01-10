package net.moistymonsoon.monsooncraft;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.moistymonsoon.monsooncraft.block.ModBlocks;
import net.moistymonsoon.monsooncraft.datagen.ModWorldGenerator;
import net.moistymonsoon.monsooncraft.item.ModItemGroups;
import net.moistymonsoon.monsooncraft.item.ModItems;
import net.moistymonsoon.monsooncraft.world.biome.ModBiomes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MonsoonCraft implements ModInitializer {
	public static final String MOD_ID = "monsooncraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

	}
}