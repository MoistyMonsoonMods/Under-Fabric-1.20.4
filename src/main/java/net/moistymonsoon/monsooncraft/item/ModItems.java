package net.moistymonsoon.monsooncraft.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.moistymonsoon.monsooncraft.MonsoonCraft;

public class ModItems {
    public static final Item ANASTITE_GEM = registerItem("anastite_gem", new Item(new FabricItemSettings()));
    public static final Item SCRAP_RUBBER = registerItem("scrap_rubber", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(SCRAP_RUBBER);
        entries.add(ANASTITE_GEM);
    }



    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(MonsoonCraft.MOD_ID, name), item);
    }


    public static void registerModItems() {
        MonsoonCraft.LOGGER.info("Registering Mod Items for " + MonsoonCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemGroup);

    }
}
