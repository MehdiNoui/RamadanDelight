package net.mehdinoui.ramadandelight.common.block.misc;

import net.mehdinoui.ramadandelight.common.registry.ModSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.level.BlockGetter;

public class DrumBlock extends Block {
    private static final VoxelShape SHAPE = Block.box(1, 0.0, 1, 15, 5, 15);

    public DrumBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        return SHAPE;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide) {
            SoundEvent drumSound = ModSoundEvents.DRUM_BEAT.get();
            float randomPitch = 0.8F + level.random.nextFloat() * 0.4F;
            level.playSound(null, pos, drumSound, SoundSource.BLOCKS, 1.0F, randomPitch);
            return InteractionResult.SUCCESS;
        } else {
            level.addParticle(ParticleTypes.NOTE,
                    pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                    (double) level.random.nextInt(24) / 24.0D, 0.0D, 0.0D);
        }
        return InteractionResult.CONSUME;
    }

}
