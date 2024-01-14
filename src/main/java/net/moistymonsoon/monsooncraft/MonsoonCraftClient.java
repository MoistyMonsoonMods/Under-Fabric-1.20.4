package net.moistymonsoon.monsooncraft;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.moistymonsoon.monsooncraft.block.ModBlocks;

import java.lang.reflect.Field;
import java.rmi.registry.RegistryHandler;

public class MonsoonCraftClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TIRE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.INDUSTRIAL_LAMP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TIN_CAN_BLOCK, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FIDDLEWORT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_FIDDLEWORT, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HORSETAIL, RenderLayer.getCutout());
        for (Field field : RegistryHandler.class.getDeclaredFields()) {
            try {
                Object object = field.get(null);
                if (object instanceof Block block) {
                    BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}