package net.moistymonsoon.monsooncraft.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.moistymonsoon.monsooncraft.MonsoonCraft;
import net.moistymonsoon.monsooncraft.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup ODDITY_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(MonsoonCraft.MOD_ID, "oddity"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.oddity"))
                    .icon(() -> new ItemStack(ModItems.ANASTITE_GEM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ANASTITE_GEM);
                        entries.add(ModItems.SCRAP_RUBBER);

                        entries.add(ModBlocks.LENTARITE);
                        entries.add(ModBlocks.MOSSY_LENTARITE);
                        entries.add(ModBlocks.PIPE_RUSTED);
                        entries.add(ModBlocks.TIRE);
                        entries.add(ModBlocks.SCRAP_RUBBER_BLOCK);
                        entries.add(ModBlocks.INDUSTRIAL_LAMP);
                        entries.add(ModBlocks.TIN_CAN_BLOCK);

                        entries.add(ModBlocks.FIDDLEWORT);

                    }).build());

    public static void registerItemGroups() {
        MonsoonCraft.LOGGER.info("Registering Item Groups for " + MonsoonCraft.MOD_ID);
    }
}
