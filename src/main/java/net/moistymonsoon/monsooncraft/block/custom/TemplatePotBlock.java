package net.moistymonsoon.monsooncraft.block.custom;

import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.stat.Stats;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.util.*;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationPropertyHelper;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.moistymonsoon.monsooncraft.MonsoonCraft;
import net.moistymonsoon.monsooncraft.properties.FlowerProperty;
import net.moistymonsoon.monsooncraft.util.Flower;

@SuppressWarnings("deprecation")
public class TemplatePotBlock extends Block {
    public static final FlowerProperty FLOWER = FlowerProperty.create("flower", Flower.FLOWERS.values());
    public static final int MAX_ROTATION_INDEX = RotationPropertyHelper.getMax();
    private static final int MAX_ROTATIONS;
    public static final IntProperty ROTATION;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0, 0.0, 5.0, 11.0, 6.0, 11.0);

    public TemplatePotBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FLOWER, Flower.NONE));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FLOWER);
        builder.add(new Property[]{ROTATION});

    }

    static {
        MAX_ROTATIONS = MAX_ROTATION_INDEX + 1;
        ROTATION = Properties.ROTATION;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView worldIn, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)super.getPlacementState(ctx).with(ROTATION, RotationPropertyHelper.fromYaw(ctx.getPlayerYaw()));
    }

    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return (BlockState)state.with(ROTATION, rotation.rotate((Integer)state.get(ROTATION), MAX_ROTATIONS));
    }

    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return (BlockState)state.with(ROTATION, mirror.mirror((Integer)state.get(ROTATION), MAX_ROTATIONS));
    }


    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (state.getBlock() instanceof TemplatePotBlock) {
            Block flower = state.get(TemplatePotBlock.FLOWER).block();
            if (!player.isCreative() && !flower.equals(Blocks.AIR)) {
                BlockPos playerPos = BlockPos.ofFloored(player.getX(), player.getY(), player.getZ());
                Block.dropStack(world, playerPos, new ItemStack(flower));
            }
        }
        return state;
    }

    @Override
    public ActionResult onUse(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockHitResult hit) {
        boolean potIsEmpty;
        ItemStack itemstack = player.getStackInHand(handIn);
        Item item = itemstack.getItem();
        Block flowerIn = Blocks.AIR;
        if (item instanceof BlockItem blockItem && Flower.getAllFlowerBlocks().contains(blockItem.getBlock())) {
            flowerIn = blockItem.getBlock();
        }
        boolean doesNotHoldFlower = flowerIn == Blocks.AIR;
        potIsEmpty = (worldIn.getBlockState(pos).get(FLOWER)).block() == Blocks.AIR;
        if (doesNotHoldFlower != potIsEmpty) {
            if (potIsEmpty) { MonsoonCraft.LOGGER.info("TEST");
                Identifier rl = Registries.BLOCK.getId(flowerIn);
                worldIn.setBlockState(pos, this.getDefaultState().with(FLOWER, (rl.getNamespace().equals("monsooncraft") ? Flower.FLOWERS
                        .get("monsooncraft_" + rl.getPath()) : Flower.FLOWERS.get(rl.getPath()))), 3);
                player.incrementStat(Stats.POT_FLOWER);
                if (!player.getAbilities().creativeMode) {
                    itemstack.decrement(1);
                }
            } else {
                ItemStack itemStack1 = new ItemStack((worldIn.getBlockState(pos).get(FLOWER)).block());
                if (itemstack.isEmpty()) {
                    player.setStackInHand(handIn, itemStack1);
                } else if (!player.giveItemStack(itemStack1)) {
                    player.dropItem(itemStack1, false);
                }
                worldIn.setBlockState(pos, this.getDefaultState(), 3);
            }
        }
        return ActionResult.SUCCESS;
    }
}