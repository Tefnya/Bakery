package net.satisfy.bakery.core.block;

import dev.architectury.registry.registries.RegistrySupplier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Supplier;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Plane;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.satisfy.bakery.core.util.GeneralUtil;
import org.jetbrains.annotations.NotNull;

public class CabinetWallBlock extends CabinetBlock {
    private static final Supplier<VoxelShape> voxelShapeSupplier = () -> {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.joinUnoptimized(shape, Shapes.box(0.0, 0.0, 0.25, 1.0, 1.0, 1.0), BooleanOp.OR);
        return shape;
    };
    public static final Map<Direction, VoxelShape> SHAPE = (Map)Util.make(new HashMap(), (map) -> {
        Iterator var1 = Plane.HORIZONTAL.stream().toList().iterator();

        while(var1.hasNext()) {
            Direction direction = (Direction)var1.next();
            map.put(direction, GeneralUtil.rotateShape(Direction.NORTH, direction, (VoxelShape)voxelShapeSupplier.get()));
        }

    });

    public CabinetWallBlock(BlockBehaviour.Properties settings, RegistrySupplier<SoundEvent> openSound, RegistrySupplier<SoundEvent> closeSound) {
        super(settings, openSound, closeSound);
    }

    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return (VoxelShape)SHAPE.get(state.getValue(FACING));
    }
}

