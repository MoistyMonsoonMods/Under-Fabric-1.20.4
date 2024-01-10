package net.moistymonsoon.monsooncraft.world.dimension;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionOptions;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.dimension.DimensionTypes;
import net.moistymonsoon.monsooncraft.MonsoonCraft;

import java.util.OptionalLong;

public class ModDimensions {
    public static final RegistryKey<DimensionOptions> UNDERDIM_KEY = RegistryKey.of(RegistryKeys.DIMENSION,
            new Identifier(MonsoonCraft.MOD_ID, "underdim"));
    public static final RegistryKey<World> UNDERDIM_LEVEL_KEY = RegistryKey.of(RegistryKeys.WORLD,
            new Identifier(MonsoonCraft.MOD_ID, "underdim"));
    public static final RegistryKey<DimensionType> UNDER_DIM_TYPE = RegistryKey.of(RegistryKeys.DIMENSION_TYPE,
            new Identifier(MonsoonCraft.MOD_ID, "underdim_type"));

    public static void bootstrapType(Registerable<DimensionType> context) {
        context.register(UNDER_DIM_TYPE, new DimensionType(
                OptionalLong.of(18000), // fixedTime
                false, // hasSkylight
                true, // hasCeiling
                false, // ultraWarm
                false, // natural
                1.5, // coordinateScale
                true, // bedWorks
                false, // respawnAnchorWorks
                0, // minY
                256, // height
                256, // logicalHeight
                BlockTags.INFINIBURN_OVERWORLD, // infiniburn
                DimensionTypes.OVERWORLD_ID, // effectsLocation
                0.1f, // ambientLight
                new DimensionType.MonsterSettings(false, false, UniformIntProvider.create(0, 0), 0)));
    }
}
