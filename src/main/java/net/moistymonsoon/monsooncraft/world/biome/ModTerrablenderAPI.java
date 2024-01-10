package net.moistymonsoon.monsooncraft.world.biome;

import net.minecraft.util.Identifier;
import net.moistymonsoon.monsooncraft.MonsoonCraft;
import net.moistymonsoon.monsooncraft.world.biome.surface.ModMaterialRules;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerrablenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {
        Regions.register(new ModOverworldRegion(new Identifier(MonsoonCraft.MOD_ID, "overworld"), 2));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MonsoonCraft.MOD_ID, ModMaterialRules.makeRules());
    }
}
