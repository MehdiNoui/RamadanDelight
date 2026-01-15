package net.mehdinoui.ramadandelight.common.world.tree.custom;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.mehdinoui.ramadandelight.common.block.crops.DatesBranchBlock;
import net.mehdinoui.ramadandelight.common.registry.ModBlocks;
import net.mehdinoui.ramadandelight.common.world.tree.ModFoliagePlacer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;

public class PalmFoliagePlacer extends FoliagePlacer {
    public static final MapCodec<PalmFoliagePlacer> CODEC = RecordCodecBuilder.mapCodec((instance) ->
            foliagePlacerParts(instance)
                    .and(Codec.intRange(0, 16).fieldOf("height").forGetter(fp -> fp.height))
                    .apply(instance, PalmFoliagePlacer::new));
    protected final int height;

    public PalmFoliagePlacer(IntProvider pRadius, IntProvider pOffset, int height) {
        super(pRadius, pOffset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> type() {
        return ModFoliagePlacer.PALM_FOLIAGE_PLACER.get();
    }

    @Override
    protected void createFoliage(LevelSimulatedReader pLevel, FoliageSetter foliageSetter, RandomSource pRandom,
                                 TreeConfiguration pConfig, int maxFreeTreeHeight,
                                 FoliageAttachment attachment, int foliageHeight,
                                 int foliageRadius, int offset) {

        BlockPos startingPos = attachment.pos().above(1);

        placeLayer(startingPos, new int[][]{
                {3, 3}
        }, pLevel, foliageSetter, pRandom, pConfig);

        BlockPos y1 = startingPos.below();
        placeLayer(y1, new int[][]{
                        {1, 2},         {1, 4},
                {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 5},
                        {3, 2}, {3, 3}, {3, 4},
                {4, 1}, {4, 2}, {4, 3}, {4, 4}, {4, 5},
                        {5, 2},         {5, 4}
        }, pLevel, foliageSetter, pRandom, pConfig);

        BlockPos y2 = y1.below();
        placeLayer(y2, new int[][]{
                                {0, 2},         {0, 4},
                                {1, 2},         {1, 4},
                {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 5}, {2, 6},
                                {3, 2},         {3, 4},
                {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4}, {4, 5}, {4, 6},
                                {5, 2},         {5, 4},
                                {6, 2},         {6, 4}
        }, pLevel, foliageSetter, pRandom, pConfig);

        BlockPos y3 = y2.below();
        placeLayer(y3, new int[][]{
                                {1, 3},
                        {2, 2}, {2, 3}, {2, 4},
                {3, 1}, {3, 2},         {3, 4}, {3, 5},
                        {4, 2}, {4, 3}, {4, 4},
                                {5, 3}
        }, pLevel, foliageSetter, pRandom, pConfig);

        BlockPos y4 = y3.below();
        placeLayer(y4, new int[][]{
                {0, 3}, {1, 3},
                {5, 3}, {6, 3},
                {3, 0}, {3, 1},
                {3, 5}, {3, 6},
        }, pLevel, foliageSetter, pRandom, pConfig);

        placeRandomDatesLayer(y4, new int[][]{
                {2, 2}, {2, 3}, {2, 4},
                {3, 2},         {3, 4},
                {4, 2}, {4, 3}, {4, 4}
        }, pLevel, foliageSetter, pRandom, pConfig);
    }

    private void placeLayer(BlockPos center, int[][] offsets, LevelSimulatedReader pLevel, FoliageSetter foliageSetter,
                            RandomSource pRandom, TreeConfiguration pConfig) {
        for (int[] offset : offsets) {
            BlockPos leafPos = center.offset(offset[0] - 3, 0, offset[1] - 3);
            tryPlaceLeaf(pLevel, foliageSetter, pRandom, pConfig, leafPos);
        }
    }
    private void placeRandomDatesLayer(BlockPos center, int[][] offsets, LevelSimulatedReader pLevel, FoliageSetter foliageSetter,
                                       RandomSource pRandom, TreeConfiguration pConfig) {
        for (int[] offset : offsets) {
            BlockPos pos = center.offset(offset[0] - 3, 0, offset[1] - 3);
            //TO-DO: replace the wool with dates
            if (pRandom.nextFloat() < 0.4) {
                int randomAge = pRandom.nextInt(4);
                foliageSetter.set(pos,  ModBlocks.DATES_BRANCH.get().defaultBlockState().setValue(DatesBranchBlock.AGE, randomAge));
            }
        }
    }


    @Override
    public int foliageHeight(RandomSource pRandom, int pHeight, TreeConfiguration pConfig) {
        return this.height;
    }

    @Override
    protected boolean shouldSkipLocation(RandomSource pRandom, int pLocalX, int pLocalY, int pLocalZ, int pRange, boolean pLarge) {
        return false;
    }
}
