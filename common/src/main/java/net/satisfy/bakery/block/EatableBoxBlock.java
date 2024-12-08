package net.satisfy.bakery.block;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Plane;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.satisfy.bakery.util.GeneralUtil;
import org.jetbrains.annotations.NotNull;

public class EatableBoxBlock extends FacingBlock {
    public static final IntegerProperty CUTS = IntegerProperty.create("cuts", 0, 5);
    private static final Supplier<VoxelShape> voxelShapeSupplier = () -> {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.joinUnoptimized(shape, Shapes.box(0.1875, 0.0, 0.25, 0.8125, 0.125, 0.74375), BooleanOp.OR);
        shape = Shapes.joinUnoptimized(shape, Shapes.box(0.75, 0.125, 0.25, 0.8125, 0.1875, 0.74375), BooleanOp.OR);
        shape = Shapes.joinUnoptimized(shape, Shapes.box(0.1875, 0.125, 0.25, 0.25, 0.1875, 0.74375), BooleanOp.OR);
        shape = Shapes.joinUnoptimized(shape, Shapes.box(0.25, 0.125, 0.25, 0.75, 0.1875, 0.30625), BooleanOp.OR);
        shape = Shapes.joinUnoptimized(shape, Shapes.box(0.25, 0.125, 0.68125, 0.75, 0.1875, 0.74375), BooleanOp.OR);
        return shape;
    };
    public static final Map<Direction, VoxelShape> SHAPE = (Map)Util.make(new HashMap(), (map) -> {
        Iterator var1 = Plane.HORIZONTAL.stream().toList().iterator();

        while(var1.hasNext()) {
            Direction direction = (Direction)var1.next();
            map.put(direction, GeneralUtil.rotateShape(Direction.NORTH, direction, (VoxelShape)voxelShapeSupplier.get()));
        }

    });

    public EatableBoxBlock(BlockBehaviour.Properties settings) {
        super(settings);
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(CUTS, 0));
    }

    public @NotNull InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getItemInHand(hand);
        if (world.isClientSide) {
            if (this.tryEat(world, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (itemStack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        }

        return this.tryEat(world, pos, state, player);
    }

    private InteractionResult tryEat(Level world, BlockPos pos, BlockState state, Player player) {
        world.playSound((Player)null, pos, SoundEvents.FOX_EAT, SoundSource.PLAYERS, 0.5F, world.getRandom().nextFloat() * 0.1F + 0.9F);
        player.getFoodData().eat(1, 0.4F);
        int cuts = (Integer)state.getValue(CUTS);
        world.gameEvent(player, GameEvent.EAT, pos);
        if (cuts < 5) {
            world.setBlock(pos, (BlockState)state.setValue(CUTS, cuts + 1), 3);
        } else {
            world.destroyBlock(pos, false);
            ItemStack bowlStack = new ItemStack(Items.CHEST);
            ItemEntity itemEntity = new ItemEntity(world, (double)pos.getX() + 0.5, (double)pos.getY() + 0.5, (double)pos.getZ() + 0.5, bowlStack);
            world.addFreshEntity(itemEntity);
        }

        return InteractionResult.SUCCESS;
    }

    public @NotNull BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos) {
        return direction == Direction.DOWN && !state.canSurvive(world, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).isSolid();
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(new Property[]{CUTS});
    }

    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return (VoxelShape)SHAPE.get(state.getValue(FACING));
    }
}

