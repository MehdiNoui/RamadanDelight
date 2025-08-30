package net.mehdinoui.ramadandelight.common.block.entity;

import net.mehdinoui.ramadandelight.common.registry.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class RDSignBlockEntity extends SignBlockEntity {
    public RDSignBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModEntities.MOD_SIGN.get(), pPos, pBlockState);
    }

    @Override
    public BlockEntityType<?> getType() {
        return ModEntities.MOD_SIGN.get();
    }
}
