package net.mehdinoui.ramadandelight.common.block.signs;

import net.mehdinoui.ramadandelight.common.block.entity.RDHangingSignBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.WallHangingSignBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;

public class PalmWallHangingSignBlock extends WallHangingSignBlock {
    public PalmWallHangingSignBlock(Properties pProperties, WoodType pType) {
        super(pProperties, pType);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new RDHangingSignBlockEntity(pPos, pState);
    }
}
