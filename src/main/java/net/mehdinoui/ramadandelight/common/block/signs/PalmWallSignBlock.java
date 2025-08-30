package net.mehdinoui.ramadandelight.common.block.signs;

import net.mehdinoui.ramadandelight.common.block.entity.RDSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class PalmWallSignBlock extends WallSignBlock {
    public PalmWallSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new RDSignBlockEntity(pPos, pState);
    }
}
