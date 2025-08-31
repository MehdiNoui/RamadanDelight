package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.block.crops.ChickpeaCropBlock;
import net.mehdinoui.ramadandelight.common.block.crops.DatesBranchBlock;
import net.mehdinoui.ramadandelight.common.block.crops.ParsleyCropBlock;
import net.mehdinoui.ramadandelight.common.block.food.BourekBlock;
import net.mehdinoui.ramadandelight.common.block.food.MaklobaBlock;
import net.mehdinoui.ramadandelight.common.block.misc.CustomTiles;
import net.mehdinoui.ramadandelight.common.block.misc.DrumBlock;
import net.mehdinoui.ramadandelight.common.block.misc.FanousLantern;
import net.mehdinoui.ramadandelight.common.block.signs.PalmHangingSignBlock;
import net.mehdinoui.ramadandelight.common.block.signs.PalmStandingSignBlock;
import net.mehdinoui.ramadandelight.common.block.signs.PalmWallHangingSignBlock;
import net.mehdinoui.ramadandelight.common.block.signs.PalmWallSignBlock;
import net.mehdinoui.ramadandelight.common.block.tree.PalmSapling;
import net.mehdinoui.ramadandelight.common.block.tree.WoodBlock;
import net.mehdinoui.ramadandelight.common.util.RDWoodTypes;
import net.mehdinoui.ramadandelight.common.worldgen.tree.PalmTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;


import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, RamadanDelight.MOD_ID);

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    //Parsley
    public static final RegistryObject<Block> PARSLEY_BAG = registerBlock("parsley_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> PARSLEY_CROP = BLOCKS.register("parsley_crop",
            () -> new ParsleyCropBlock(Block.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> WILD_PARSLEY = registerBlock("wild_parsley",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noCollission().noOcclusion()));

    //Chickpea
    public static final RegistryObject<Block> CHICKPEA_BAG = registerBlock("chickpea_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> CHICKPEA_CROP = BLOCKS.register("chickpea_crop",
            () -> new ChickpeaCropBlock(Block.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> WILD_CHICKPEA = registerBlock("wild_chickpea",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noCollission().noOcclusion()));

    //Makloba
    public static final RegistryObject<Block> MAKLOBA_BLOCK = BLOCKS.register("makloba_block",
            () -> new MaklobaBlock(Block.Properties.copy(Blocks.CAKE), ModItems.MAKLOBA, true));
    public static final RegistryObject<Block> BOUREK_BLOCK = BLOCKS.register("bourek_block",
            () -> new BourekBlock(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> QUICHE = BLOCKS.register("quiche",
            () -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.QUICHE_SLICE));

    //Fanous
    public static final RegistryObject<Block> FANOUS = BLOCKS.register("fanous",
            () -> new FanousLantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> COPPER_FANOUS = BLOCKS.register("copper_fanous",
            () -> new FanousLantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SOUL_FANOUS = BLOCKS.register("soul_fanous",
            () -> new FanousLantern(BlockBehaviour.Properties.copy(Blocks.SOUL_LANTERN).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> REDSTONE_FANOUS = BLOCKS.register("redstone_fanous",
            () -> new FanousLantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).pushReaction(PushReaction.DESTROY)));

    //Misc
    public static final RegistryObject<Block> MOSAIC_TILES = registerBlock("mosaic_tiles",
            () -> new CustomTiles(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> DRUM_BLOCK = BLOCKS.register("drum",
            () -> new DrumBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    //Glass
    public static final RegistryObject<Block> STAINED_GLASS_BLOCK = registerBlock("stained_glass_block",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(1.2f, 2.0f)));
    public static final RegistryObject<Block> BLUE_STAINED_GLASS_BLOCK = registerBlock("blue_stained_glass_block",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(1.2f, 2.0f)));
    public static final RegistryObject<Block> GREEN_STAINED_GLASS_BLOCK = registerBlock("green_stained_glass_block",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(1.2f, 2.0f)));
    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_BLOCK = registerBlock("orange_stained_glass_block",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(1.2f, 2.0f)));

    //Glass Panes
    public static final RegistryObject<Block> STAINED_GLASS_PANE = registerBlock("stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.WHITE, BlockBehaviour.Properties.copy(Blocks.BLUE_STAINED_GLASS_PANE).strength(1.2f, 2.0f).noOcclusion()));
    public static final RegistryObject<Block> BLUE_STAINED_GLASS_PANE = registerBlock("blue_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.BLUE, BlockBehaviour.Properties.copy(Blocks.BLUE_STAINED_GLASS_PANE).strength(1.2f, 2.0f).noOcclusion()));
    public static final RegistryObject<Block> GREEN_STAINED_GLASS_PANE = registerBlock("green_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.GREEN, BlockBehaviour.Properties.copy(Blocks.GREEN_STAINED_GLASS_PANE).strength(1.2f, 2.0f).noOcclusion()));
    public static final RegistryObject<Block> ORANGE_STAINED_GLASS_PANE = registerBlock("orange_stained_glass_pane",
            () -> new StainedGlassPaneBlock(DyeColor.ORANGE, BlockBehaviour.Properties.copy(Blocks.ORANGE_STAINED_GLASS_PANE).strength(1.2f, 2.0f).noOcclusion()));

    //Tree Base
    public static final RegistryObject<Block> PALM_LOG = registerBlock("palm_log",
            () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> PALM_WOOD = registerBlock("palm_wood",
            () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)));
    public static final RegistryObject<Block> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log",
            () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));
    public static final RegistryObject<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood",
            () -> new WoodBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)));

    public static final RegistryObject<Block> PALM_PLANKS = registerBlock("palm_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)){
                public boolean isFlammable(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
                    return 5;
                }
            });
    public static final RegistryObject<Block> PALM_LEAVES = registerBlock("palm_leaves",
            () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)){
                public boolean isFlammable(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final RegistryObject<Block> PALM_SAPLING = registerBlock("palm_sapling",
            () -> new PalmSapling(new PalmTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));


    //Wood set
    public static final RegistryObject<Block> PALM_STAIRS = registerBlock("palm_stairs",
            () -> new StairBlock(() -> ModBlocks.PALM_PLANKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.OAK_STAIRS).sound(SoundType.WOOD)){
                public boolean isFlammable(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> PALM_SLAB = registerBlock("palm_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SLAB).sound(SoundType.WOOD)){
                public boolean isFlammable(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> PALM_PRESSURE_PLATE = registerBlock("palm_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.OAK_PRESSURE_PLATE).sound(SoundType.WOOD), BlockSetType.OAK));
    public static final RegistryObject<Block> PALM_BUTTON = registerBlock("palm_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.OAK_BUTTON).sound(SoundType.WOOD), BlockSetType.OAK, 10, true));

    public static final RegistryObject<Block> PALM_FENCE = registerBlock("palm_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE).sound(SoundType.WOOD)){
                public boolean isFlammable(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> PALM_FENCE_GATE = registerBlock("palm_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.OAK_FENCE_GATE), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE){
                public boolean isFlammable(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> PALM_DOOR = registerBlock("palm_door",
            () -> new DoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_DOOR), BlockSetType.OAK){
                public boolean isFlammable(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> PALM_TRAPDOOR = registerBlock("palm_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.copy(Blocks.OAK_TRAPDOOR), BlockSetType.OAK){
                public boolean isFlammable(final BlockState state, final BlockGetter world, final BlockPos pos, final Direction face) {
                    return true;
                }
                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 20;
                }
                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction direction) {
                    return 5;
                }
            });

    public static final RegistryObject<Block> DATES_BRANCH = BLOCKS.register("dates_branch",
            () -> new DatesBranchBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                    .noOcclusion()
                    .strength(0.2f)
                    .sound(SoundType.AZALEA)));

    public static final RegistryObject<Block> PALM_SIGN = BLOCKS.register("palm_sign",
            () -> new PalmStandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN),
                    RDWoodTypes.PALM));
    public static final RegistryObject<Block> PALM_WALL_SIGN = BLOCKS.register("palm_wall_sign",
            () -> new PalmWallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_SIGN),
                    RDWoodTypes.PALM));
    public static final RegistryObject<Block> PALM_HANGING_SIGN = BLOCKS.register("palm_hanging_sign",
            () -> new PalmHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_HANGING_SIGN),
                    RDWoodTypes.PALM));
    public static final RegistryObject<Block> PALM_WALL_HANGING_SIGN = BLOCKS.register("palm_wall_hanging_sign",
            () -> new PalmWallHangingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WALL_HANGING_SIGN),
                    RDWoodTypes.PALM));
}
