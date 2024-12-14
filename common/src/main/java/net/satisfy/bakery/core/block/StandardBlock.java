package net.satisfy.bakery.core.block;

import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.RotationSegment;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.satisfy.bakery.core.block.entity.StandardBlockEntity;
import net.satisfy.bakery.core.registry.EntityTypeRegistry;
import org.jetbrains.annotations.Nullable;

public class StandardBlock extends BaseEntityBlock {
    public static final IntegerProperty ROTATION;
    private static final VoxelShape SHAPE;

    public StandardBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.makeDefaultState();
    }

    public void onRemove(BlockState state, Level world, BlockPos pos, BlockState newState, boolean moved) {
        if (((GameRules.BooleanValue)world.getGameRules().getRule(GameRules.RULE_DOBLOCKDROPS)).get() && state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof StandardBlockEntity) {
                StandardBlockEntity entity = (StandardBlockEntity)blockEntity;
                Item item = entity.getItem();
                if (item != null) {
                    Containers.dropItemStack(world, (double)pos.getX(), (double)pos.getY(), (double)pos.getZ(), new ItemStack(item));
                }
            }

            super.onRemove(state, world, pos, newState, moved);
        }

    }

    protected void makeDefaultState() {
        this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(ROTATION, 0));
    }

    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        Optional<StandardBlockEntity> entity = blockGetter.getBlockEntity(blockPos, (BlockEntityType) EntityTypeRegistry.STANDARD.get());
        if (entity.isPresent()) {
            Item item = ((StandardBlockEntity)entity.get()).getItem();
            if (item != null) {
                return new ItemStack(item);
            }
        }

        return super.getCloneItemStack(blockGetter, blockPos, blockState);
    }

    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new StandardBlockEntity(blockPos, blockState);
    }

    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity livingEntity, ItemStack itemStack) {
        level.getBlockEntity(blockPos, (BlockEntityType) EntityTypeRegistry.STANDARD.get()).ifPresent((entity) -> {
            ((StandardBlockEntity)entity).fromItem(itemStack);
        });
    }

    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos blockPos) {
        return levelReader.getBlockState(blockPos.below()).isSolid();
    }

    public boolean isPossibleToRespawnInThis(BlockState blockState) {
        return true;
    }

    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        return SHAPE;
    }

    public BlockState getStateForPlacement(BlockPlaceContext blockPlaceContext) {
        return (BlockState)this.defaultBlockState().setValue(ROTATION, RotationSegment.convertToSegment(blockPlaceContext.getRotation() + 180.0F));
    }

    public BlockState rotate(BlockState blockState, Rotation rotation) {
        return (BlockState)blockState.setValue(ROTATION, rotation.rotate((Integer)blockState.getValue(ROTATION), 16));
    }

    public BlockState mirror(BlockState blockState, Mirror mirror) {
        return (BlockState)blockState.setValue(ROTATION, mirror.mirror((Integer)blockState.getValue(ROTATION), 16));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{ROTATION});
    }

    public <T extends BlockEntity> @Nullable BlockEntityTicker<T> getTicker(Level world, BlockState state, BlockEntityType<T> type) {
        return createTickerHelper(type, (BlockEntityType)EntityTypeRegistry.STANDARD.get(), (world1, pos, state1, be) -> {
            ((StandardBlockEntity)be).tick(world1, pos, state1, (StandardBlockEntity)be);
        });
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState2, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos2) {
        return direction == Direction.DOWN && !blockState.canSurvive(levelAccessor, blockPos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, blockState2, levelAccessor, blockPos, blockPos2);
    }

    static {
        ROTATION = BlockStateProperties.ROTATION_16;
        SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 16.0, 12.0);
    }
}

