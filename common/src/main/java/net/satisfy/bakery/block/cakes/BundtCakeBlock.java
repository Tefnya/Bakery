package net.satisfy.bakery.block.cakes;

import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.satisfy.bakery.util.GeneralUtil;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;


public class BundtCakeBlock extends PieBlock {
    public BundtCakeBlock(Properties settings, Supplier<Item> slice) {
        super(settings, slice);
    }

    private static final Supplier<VoxelShape> fullShapeSupplier = () -> Shapes.box(0.25, 0, 0.25, 0.75, 0.5, 0.75);
    public static final Map<Direction, VoxelShape> FULL_SHAPE = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            map.put(direction, GeneralUtil.rotateShape(Direction.NORTH, direction, fullShapeSupplier.get()));
        }
    });

    private static final Supplier<VoxelShape> threeShapeSupplier = () -> {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.or(shape, Shapes.box(0.25, 0, 0.25, 0.5, 0.5, 0.5));
        shape = Shapes.or(shape, Shapes.box(0.25, 0, 0.5, 0.5, 0.5, 0.75));
        shape = Shapes.or(shape, Shapes.box(0.5, 0, 0.5, 0.75, 0.5, 0.75));
        return shape;
    };
    public static final Map<Direction, VoxelShape> THREE_SHAPE = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            map.put(direction, GeneralUtil.rotateShape(Direction.NORTH, direction, threeShapeSupplier.get()));
        }
    });

    private static final Supplier<VoxelShape> halfShapeSupplier = () -> {
        VoxelShape shape = Shapes.empty();
        shape = Shapes.or(shape, Shapes.box(0.25, 0, 0.5, 0.5, 0.5, 0.75));
        shape = Shapes.or(shape, Shapes.box(0.5, 0, 0.5, 0.75, 0.5, 0.75));
        return shape;
    };
    public static final Map<Direction, VoxelShape> HALF_SHAPE = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            map.put(direction, GeneralUtil.rotateShape(Direction.NORTH, direction, halfShapeSupplier.get()));
        }
    });

    private static final Supplier<VoxelShape> quarterShapeSupplier = () -> Shapes.box(0.25, 0, 0.5, 0.5, 0.5, 0.75);
    public static final Map<Direction, VoxelShape> QUARTER_SHAPE = Util.make(new HashMap<>(), map -> {
        for (Direction direction : Direction.Plane.HORIZONTAL) {
            map.put(direction, GeneralUtil.rotateShape(Direction.NORTH, direction, quarterShapeSupplier.get()));
        }
    });

    @Override
    public @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        int cuts = state.getValue(CUTS);
        Map<Direction, VoxelShape> shape = switch (cuts) {
            case 1 -> THREE_SHAPE;
            case 2 -> HALF_SHAPE;
            case 3 -> QUARTER_SHAPE;
            default -> FULL_SHAPE;
        };
        Direction direction = state.getValue(FACING);
        return shape.get(direction);
    }
}
