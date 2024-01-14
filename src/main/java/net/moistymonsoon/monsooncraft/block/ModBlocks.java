package net.moistymonsoon.monsooncraft.block;

import com.mojang.serialization.MapCodec;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.moistymonsoon.monsooncraft.MonsoonCraft;
import net.moistymonsoon.monsooncraft.block.custom.LampBlock;
import net.moistymonsoon.monsooncraft.block.custom.PotBlock;
import net.moistymonsoon.monsooncraft.block.custom.TemplatePotBlock;
import net.moistymonsoon.monsooncraft.block.custom.TireBlock;

public class ModBlocks {
    public static final Block LENTARITE = registerBlock("lentarite",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.STONE)));
    public static final Block MOSSY_LENTARITE = registerBlock("mossy_lentarite",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.MOSS_CARPET)));
    public static final Block SCRAP_RUBBER_BLOCK = registerBlock("scrap_rubber_block",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).sounds(BlockSoundGroup.WART_BLOCK)));
    public static final Block PIPE_RUSTED = registerBlock("pipe_rusted",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block TIRE = registerBlock("tire",
            new TireBlock(FabricBlockSettings.copyOf(Blocks.WARPED_SLAB).nonOpaque()));
    public static final Block INDUSTRIAL_LAMP = registerBlock("industrial_lamp",
            new LampBlock(FabricBlockSettings.copyOf(Blocks.END_ROD).nonOpaque()));
    public static final Block TIN_CAN_BLOCK = registerBlock("tin_can_block",
            new TemplatePotBlock(AbstractBlock.Settings.copy(Blocks.FLOWER_POT).nonOpaque()));

    public static final Block FIDDLEWORT = registerBlock("fiddlewort",
            new FlowerBlock(StatusEffects.ABSORPTION, 10,
                    FabricBlockSettings.copyOf(Blocks.CORNFLOWER).nonOpaque().noCollision()));
    public static final Block POTTED_FIDDLEWORT = registerBlock("potted_fiddlewort",
            new FlowerPotBlock(FIDDLEWORT, FabricBlockSettings.copyOf(Blocks.POTTED_CORNFLOWER).nonOpaque()));
    public static final Block TINNED_FIDDLEWORT = registerBlock("tinned_fiddlewort",
            new FlowerPotBlock(FIDDLEWORT, FabricBlockSettings.copyOf(ModBlocks.POTTED_FIDDLEWORT).nonOpaque()));

    public static final Block HORSETAIL = registerBlock("horsetail",
            new TallFlowerBlock(FabricBlockSettings.copyOf(Blocks.ROSE_BUSH).nonOpaque().noCollision()));


    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(MonsoonCraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(MonsoonCraft.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }


    public static void registerModBlocks() {
        MonsoonCraft.LOGGER.info("Registering Mod Blocks for " + MonsoonCraft.MOD_ID);
    }


}
