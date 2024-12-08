package net.satisfy.bakery.block;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Plane;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.satisfy.bakery.util.GeneralUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class SinkBlock extends Block {
    public static final BooleanProperty FILLED = BooleanProperty.create("filled");
    public static final EnumProperty<DoubleBlockHalf> HALF = EnumProperty.create("half", DoubleBlockHalf.class);
    public static final DirectionProperty FACING;
    public static final Map<Direction, VoxelShape> TOP_SHAPES;
    public static final Map<Direction, VoxelShape> BOTTOM_SHAPES;

    public SinkBlock(BlockBehaviour.Properties settings) {
        super(settings);
        this.registerDefaultState((BlockState)((BlockState)((BlockState)((BlockState)this.stateDefinition.any()).setValue(HALF, DoubleBlockHalf.LOWER)).setValue(FILLED, false)).setValue(FACING, Direction.NORTH));
    }

    private static VoxelShape makeTopShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.375, 0.0, 0.75, 0.625, 0.0625, 1.0), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.3125, 0.125, 0.75, 0.375, 0.3125, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.3125, 0.5, 0.5625, 0.5, 0.625), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.25, 0.4375, 0.625, 0.3125, 0.6875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.0625, 0.8125, 0.5625, 0.375, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.4375, 0.375, 0.625, 0.5625, 0.5, 0.9375), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.375, 0.1875, 0.8125, 0.4375, 0.25, 0.875), BooleanOp.OR);
        return shape;
    }

    private static VoxelShape makeBottomShape() {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.join(shape, Shapes.box(0.0, 0.0, 0.125, 1.0, 0.75, 1.0), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0, 0.75, 0.1875, 0.1875, 1.0, 0.75), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0, 0.75, 0.75, 1.0, 1.0, 1.0), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.0, 0.75, 0.0, 1.0, 1.0, 0.1875), BooleanOp.OR);
        shape = Shapes.join(shape, Shapes.box(0.8125, 0.75, 0.1875, 1.0, 1.0, 0.75), BooleanOp.OR);
        return shape;
    }

    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        Direction facing = (Direction)state.getValue(FACING);
        return state.getValue(HALF) == DoubleBlockHalf.UPPER ? (VoxelShape)TOP_SHAPES.get(facing) : (VoxelShape)BOTTOM_SHAPES.get(facing);
    }

    public @NotNull InteractionResult use(BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!world.isClientSide && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
            ItemStack itemStack = player.getItemInHand(hand);
            Item item = itemStack.getItem();
            if (itemStack.isEmpty() && !(Boolean)state.getValue(FILLED)) {
                world.setBlock(pos, (BlockState)state.setValue(FILLED, true), 3);
                world.playSound((Player)null, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                return InteractionResult.SUCCESS;
            } else if ((item == Items.WATER_BUCKET || item == Items.GLASS_BOTTLE) && !(Boolean)state.getValue(FILLED)) {
                world.setBlock(pos, (BlockState)state.setValue(FILLED, true), 3);
                world.playSound((Player)null, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), SoundEvents.BUCKET_EMPTY, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!player.isCreative()) {
                    if (item == Items.WATER_BUCKET) {
                        itemStack.shrink(1);
                        player.addItem(new ItemStack(Items.BUCKET));
                    } else {
                        itemStack.shrink(1);
                        player.addItem(new ItemStack(Items.GLASS_BOTTLE));
                    }
                }

                return InteractionResult.SUCCESS;
            } else if ((item == Items.BUCKET || item == Items.GLASS_BOTTLE) && (Boolean)state.getValue(FILLED)) {
                world.setBlock(pos, (BlockState)state.setValue(FILLED, false), 3);
                world.playSound((Player)null, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), SoundEvents.BUCKET_FILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!player.isCreative()) {
                    if (item == Items.BUCKET) {
                        itemStack.shrink(1);
                        player.addItem(new ItemStack(Items.WATER_BUCKET));
                    } else {
                        itemStack.shrink(1);
                        player.addItem(PotionUtils.setPotion(new ItemStack(Items.POTION), Potions.WATER));
                    }
                }

                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.PASS;
            }
        } else {
            return InteractionResult.SUCCESS;
        }
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{HALF, FILLED, FACING});
    }

    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        return context.getLevel().getBlockState(blockPos.above()).canBeReplaced(context) ? (BlockState)((BlockState)this.defaultBlockState().setValue(HALF, DoubleBlockHalf.LOWER)).setValue(FACING, context.getHorizontalDirection().getOpposite()) : null;
    }

    public void setPlacedBy(Level world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        world.setBlock(pos.above(), (BlockState)state.setValue(HALF, DoubleBlockHalf.UPPER), 3);
    }

    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        if (state.getValue(HALF) != DoubleBlockHalf.UPPER) {
            return super.canSurvive(state, world, pos);
        } else {
            BlockPos blockPos = pos.below();
            BlockState blockState = world.getBlockState(blockPos);
            return blockState.is(this) && blockState.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
    }

    public static void placeAt(LevelAccessor levelAccessor, BlockState blockState, BlockPos blockPos, int i) {
        BlockPos blockPos2 = blockPos.above();
        levelAccessor.setBlock(blockPos, copyWaterloggedFrom(levelAccessor, blockPos, (BlockState)blockState.setValue(HALF, DoubleBlockHalf.LOWER)), i);
        levelAccessor.setBlock(blockPos2, copyWaterloggedFrom(levelAccessor, blockPos2, (BlockState)blockState.setValue(HALF, DoubleBlockHalf.UPPER)), i);
    }

    private static BlockState copyWaterloggedFrom(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return blockState.hasProperty(BlockStateProperties.WATERLOGGED) ? (BlockState)blockState.setValue(BlockStateProperties.WATERLOGGED, levelReader.isWaterAt(blockPos)) : blockState;
    }

    protected static void preventCreativeDropFromBottomPart(Level level, BlockPos blockPos, BlockState blockState, Player player) {
        DoubleBlockHalf doubleBlockHalf = (DoubleBlockHalf)blockState.getValue(HALF);
        if (doubleBlockHalf == DoubleBlockHalf.UPPER) {
            BlockPos blockPos2 = blockPos.below();
            BlockState blockState2 = level.getBlockState(blockPos2);
            if (blockState2.is(blockState.getBlock()) && blockState2.getValue(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockState3 = blockState2.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                level.setBlock(blockPos2, blockState3, 35);
                level.levelEvent(player, 2001, blockPos2, Block.getId(blockState2));
            }
        }

    }

    public void playerWillDestroy(Level world, BlockPos pos, BlockState state, Player player) {
        DoubleBlockHalf half = (DoubleBlockHalf)state.getValue(HALF);
        BlockPos blockPos = half == DoubleBlockHalf.LOWER ? pos.above() : pos.below();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.getBlock() == this && blockState.getValue(HALF) != half) {
            world.setBlock(blockPos, Blocks.AIR.defaultBlockState(), 35);
            world.levelEvent(player, 2001, blockPos, Block.getId(blockState));
            if (!world.isClientSide && !player.isCreative()) {
                dropResources(state, world, pos, (BlockEntity)null, player, player.getMainHandItem());
                dropResources(blockState, world, blockPos, (BlockEntity)null, player, player.getMainHandItem());
            }
        }

        super.playerWillDestroy(world, pos, state, player);
    }

    public void playerDestroy(Level level, Player player, BlockPos blockPos, BlockState blockState, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, blockPos, Blocks.AIR.defaultBlockState(), blockEntity, itemStack);
        BlockPos blockPos2;
        BlockState blockState2;
        if (blockState.getValue(HALF) == DoubleBlockHalf.LOWER) {
            blockPos2 = blockPos.above();
            blockState2 = level.getBlockState(blockPos2);
            if (blockState2.is(this) && blockState2.getValue(HALF) == DoubleBlockHalf.UPPER) {
                level.destroyBlock(blockPos2, true);
            }
        } else {
            blockPos2 = blockPos.below();
            blockState2 = level.getBlockState(blockPos2);
            if (blockState2.is(this) && blockState2.getValue(HALF) == DoubleBlockHalf.LOWER) {
                level.destroyBlock(blockPos2, true);
            }
        }

    }

    public long getSeed(BlockState blockState, BlockPos blockPos) {
        return Mth.getSeed(blockPos.getX(), blockPos.below(blockState.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), blockPos.getZ());
    }

    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource randomSource) {
        float chance = randomSource.nextFloat();
        if (chance < 0.1F) {
            spawnDripParticle(world, pos, state);
        }

    }

    public static void spawnDripParticle(Level level, BlockPos blockPos, BlockState blockState) {
        Vec3 vec3 = blockState.getOffset(level, blockPos);
        double d = 0.0625;
        double e = (double)blockPos.getX() + 0.5 + vec3.x;
        double f = (double)((float)((double)blockPos.getY() + 0.9) - 0.6875F) - d;
        double g = (double)blockPos.getZ() + 0.5 + vec3.z;
        ParticleOptions particleOptions = ParticleTypes.DRIPPING_WATER;
        level.addParticle(particleOptions, e, f, g, 0.0, 0.0, 0.0);
    }

    static {
        FACING = BlockStateProperties.HORIZONTAL_FACING;
        TOP_SHAPES = new HashMap();
        BOTTOM_SHAPES = new HashMap();
        Supplier<VoxelShape> topShapeSupplier = SinkBlock::makeTopShape;
        Supplier<VoxelShape> bottomShapeSupplier = SinkBlock::makeBottomShape;
        Iterator var2 = Plane.HORIZONTAL.iterator();

        while(var2.hasNext()) {
            Direction direction = (Direction)var2.next();
            TOP_SHAPES.put(direction, GeneralUtil.rotateShape(Direction.NORTH, direction, (VoxelShape)topShapeSupplier.get()));
            BOTTOM_SHAPES.put(direction, GeneralUtil.rotateShape(Direction.NORTH, direction, (VoxelShape)bottomShapeSupplier.get()));
        }

    }
}

