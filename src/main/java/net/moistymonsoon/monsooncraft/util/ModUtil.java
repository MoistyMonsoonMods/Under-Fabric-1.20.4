package net.moistymonsoon.monsooncraft.util;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.moistymonsoon.monsooncraft.MonsoonCraft;
import net.moistymonsoon.monsooncraft.block.ModBlocks;


public class ModUtil {
    public static final Block[] PLANTS = new Block[]{Blocks.OAK_SAPLING,
            Blocks.SPRUCE_SAPLING,
            Blocks.BIRCH_SAPLING,
            Blocks.JUNGLE_SAPLING,
            Blocks.ACACIA_SAPLING,
            Blocks.DARK_OAK_SAPLING,
            Blocks.FERN,
            Blocks.DANDELION,
            Blocks.POPPY,
            Blocks.BLUE_ORCHID,
            Blocks.ALLIUM,
            Blocks.AZURE_BLUET,
            Blocks.BAMBOO,
            Blocks.RED_TULIP,
            Blocks.ORANGE_TULIP,
            Blocks.WHITE_TULIP,
            Blocks.PINK_TULIP,
            Blocks.OXEYE_DAISY,
            Blocks.CORNFLOWER,
            Blocks.LILY_OF_THE_VALLEY,
            Blocks.WITHER_ROSE,
            Blocks.RED_MUSHROOM,
            Blocks.BROWN_MUSHROOM,
            Blocks.DEAD_BUSH,
            Blocks.CACTUS,
            Blocks.CRIMSON_FUNGUS,
            Blocks.WARPED_FUNGUS,
            Blocks.CRIMSON_ROOTS,
            Blocks.WARPED_ROOTS,
            Blocks.CHERRY_SAPLING,
            Blocks.MANGROVE_PROPAGULE,
            Blocks.TORCHFLOWER,
            Blocks.AZALEA,
            Blocks.FLOWERING_AZALEA,
            Blocks.BAMBOO,
            ModBlocks.FIDDLEWORT,
            ModBlocks.HORSETAIL};

    public static void registerModUtil() {
        MonsoonCraft.LOGGER.info("Registering Mod Util for " + MonsoonCraft.MOD_ID);
    }
}

