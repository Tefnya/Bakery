package net.satisfy.bakery.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.satisfy.bakery.Bakery;
import net.satisfy.bakery.item.StandardItem;
import net.satisfy.bakery.registry.EntityTypeRegistry;
import org.jetbrains.annotations.NotNull;

public class StandardBlockEntity extends BlockEntity implements BlockEntityTicker<StandardBlockEntity> {
    private ItemStack stack;

    public StandardBlockEntity(BlockPos blockPos, BlockState state) {
        super((BlockEntityType) EntityTypeRegistry.STANDARD.get(), blockPos, state);
    }

    public void saveAdditional(CompoundTag nbt) {
        CompoundTag tag = new CompoundTag();
        if (this.stack == null) {
            this.stack = ItemStack.EMPTY;
        }

        this.stack.save(tag);
        nbt.put("stack", tag);
        super.saveAdditional(nbt);
    }

    public void load(CompoundTag nbt) {
        super.load(nbt);
        this.stack = ItemStack.of(nbt.getCompound("stack"));
    }

    public void fromItem(ItemStack stack) {
        Item item = stack.getItem();
        if (item instanceof StandardItem) {
            this.stack = new ItemStack(stack.getItem());
        } else {
            throw new RuntimeException("[DoApi] False item for standard! At: " + this.getBlockPos());
        }
    }

    public Item getItem() {
        return this.stack == null ? Items.AIR : this.stack.getItem();
    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public @NotNull CompoundTag getUpdateTag() {
        return this.saveWithoutMetadata();
    }

    public void tick(Level level, BlockPos pos, BlockState blockState, StandardBlockEntity blockEntity) {
        if (!level.isClientSide() && level.getGameTime() % 80L == 0L) {
            MobEffectInstance instance = StandardItem.getEffectInstanceOrNull(this.getItem());
            if (instance == null) {
                Bakery.LOGGER.error("MobEffectInstance for StandardBlock is null! At: " + pos);
                return;
            }

            level.getEntitiesOfClass(Player.class, (new AABB(pos)).inflate(8.0), (player) -> {
                return true;
            }).forEach((player) -> {
                player.addEffect(instance);
            });
        }

    }
}

