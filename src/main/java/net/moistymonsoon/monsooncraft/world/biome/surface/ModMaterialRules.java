package net.moistymonsoon.monsooncraft.world.biome.surface;

import net.minecraft.block.Block;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.moistymonsoon.monsooncraft.world.biome.ModBiomes;
import net.moistymonsoon.monsooncraft.block.ModBlocks;

public class ModMaterialRules {
    private static final MaterialRules.MaterialRule LENTARITE = makeStateRule(ModBlocks.LENTARITE);
    private static final MaterialRules.MaterialRule MOSSY_LENTARITE = makeStateRule(ModBlocks.MOSSY_LENTARITE);

    public static MaterialRules.MaterialRule makeRules() {
        MaterialRules.MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);

        MaterialRules.MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, MOSSY_LENTARITE), LENTARITE);

        return MaterialRules.sequence(
                MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(ModBiomes.FLUSH_CAVERN),
                                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, MOSSY_LENTARITE)),
                        MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, LENTARITE)),

                // Default to a grass and dirt surface
                MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, grassSurface)
        );
    }

    private static MaterialRules.MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }
}