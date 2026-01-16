package net.mehdinoui.ramadandelight.common.block.misc;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class FanousLantern extends Block implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty HANGING = BlockStateProperties.HANGING;

    private static final VoxelShape SHAPE = Shapes.or(
            Block.box(4, 0, 4, 12, 1, 12),
            Block.box(5,1,5,11,8,11),
            Block.box(4, 8, 4, 12, 9, 12),
            Block.box(6, 9, 5, 10, 11, 11)
    );
    private static final VoxelShape SHAPE_HANGING = Shapes.or(
            Block.box(5, 0, 5, 11, 2, 11),
            Block.box(6, 2, 6, 10, 8, 10),
            Block.box(4, 8, 4, 12, 9, 12)
    );

    public FanousLantern(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(WATERLOGGED, false)
                .setValue(HANGING, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, HANGING);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if(state.getValue(HANGING)){
            return SHAPE_HANGING;
        }else{
            return SHAPE;
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos pos = context.getClickedPos();
        FluidState fluidState = context.getLevel().getFluidState(pos);

        boolean canHang = context.getLevel()
                .getBlockState(pos.above()).isFaceSturdy(context.getLevel(), pos.above(), Direction.DOWN)
                || context.getLevel().getBlockState(pos.above()).is(Blocks.CHAIN);;
        boolean canStand = context.getLevel()
                .getBlockState(pos.below()).isFaceSturdy(context.getLevel(), pos.below(), Direction.UP);

        if(canHang){
            return this.defaultBlockState()
                    .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER)
                    .setValue(HANGING, true);
        }else if(canStand){
            return this.defaultBlockState()
                    .setValue(WATERLOGGED, fluidState.getType() == Fluids.WATER)
                    .setValue(HANGING, false);
        }
        return null;
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        Direction direction = state.getValue(HANGING) ? Direction.UP : Direction.DOWN;
        BlockPos supportPos = pos.relative(direction);
        BlockState supportState = level.getBlockState(supportPos);

        if (state.getValue(HANGING)) {
            return Block.canSupportCenter(level, supportPos, Direction.DOWN) || supportState.is(Blocks.CHAIN);
        } else {
            return Block.canSupportCenter(level, supportPos, Direction.UP);
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction facing, BlockState facingState, LevelAccessor level, BlockPos pos, BlockPos facingPos) {
        if (state.getValue(WATERLOGGED)) {
            level.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        Direction requiredSupport = state.getValue(HANGING) ? Direction.UP : Direction.DOWN;
        if (facing == requiredSupport && !state.canSurvive(level, pos)) {
            return Blocks.AIR.defaultBlockState();
        }

        return super.updateShape(state, facing, facingState, level, pos, facingPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return false;
    }
}
