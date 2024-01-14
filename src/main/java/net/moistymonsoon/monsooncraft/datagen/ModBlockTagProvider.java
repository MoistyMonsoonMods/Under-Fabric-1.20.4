package net.moistymonsoon.monsooncraft.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.moistymonsoon.monsooncraft.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.LENTARITE)
                .add(ModBlocks.MOSSY_LENTARITE)
                .add(ModBlocks.PIPE_RUSTED);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.TIRE);


        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.FIDDLEWORT);

        getOrCreateTagBuilder(BlockTags.TALL_FLOWERS)
                .add(ModBlocks.HORSETAIL);
    }

}
