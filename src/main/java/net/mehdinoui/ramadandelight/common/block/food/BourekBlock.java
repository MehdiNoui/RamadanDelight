package net.mehdinoui.ramadandelight.common.block.food;

import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class BourekBlock extends FeastBlock {
    protected static final VoxelShape PLATE_SHAPE = Block.box(1.0D, 0.0D, 4.0D, 15.0D, 2.0D, 12.0D);
    protected static final VoxelShape BOUREK_SHAPE = Shapes.joinUnoptimized(PLATE_SHAPE, Block.box(2.0D, 2.0D, 5.0D, 14.0D, 8.0D, 11.0D), BooleanOp.OR);

    public static final IntegerProperty BOUREK_SERVINGS = IntegerProperty.create("servings", 0, 8);
    public final List<Supplier<Item>> bourekServings = Arrays.asList(
            ModItems.BOUREK,
            ModItems.BOUREK,
            ModItems.BOUREK,
            ModItems.BOUREK,
            ModItems.BOUREK,
            ModItems.BOUREK,
            ModItems.BOUREK,
            ModItems.BOUREK
    );
    public BourekBlock(Properties properties) {
        super(properties, ModItems.BOUREK, true);
    }

    @Override
    public IntegerProperty getServingsProperty() {
        return BOUREK_SERVINGS;
    }

    @Override
    public int getMaxServings() {
        return 8;
    }

    @Override
    public ItemStack getServingItem(BlockState state) {
        return new ItemStack(bourekServings.get(state.getValue(getServingsProperty()) - 1).get());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return state.getValue(getServingsProperty()) == 0 ? PLATE_SHAPE : BOUREK_SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(FACING, BOUREK_SERVINGS);
    }
}
