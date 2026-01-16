package net.mehdinoui.ramadandelight.common.block.tree;

import net.mehdinoui.ramadandelight.common.tag.RDForgeTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;

public class PalmSapling extends SaplingBlock {
    public PalmSapling(AbstractTreeGrower pTreeGrower, Properties pProperties) {
        super(pTreeGrower, pProperties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return pState.is(RDForgeTags.PALM_PLACEABLE_ON);
    }
}