package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.block.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
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

    public static final RegistryObject<Block> PARSLEY_BAG = registerBlock("parsley_bag",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));
    public static final RegistryObject<Block> PARSLEY_CROP = BLOCKS.register("parsley_crop",
            () -> new ParsleyCropBlock(Block.Properties.copy(Blocks.WHEAT).noOcclusion().noCollission()));
    public static final RegistryObject<Block> WILD_PARSLEY = registerBlock("wild_parsley",
            () -> new FlowerBlock(() -> MobEffects.LUCK, 5,
                    BlockBehaviour.Properties.copy(Blocks.ALLIUM).noCollission().noOcclusion()));


    public static final RegistryObject<Block> MAKLOBA_BLOCK = BLOCKS.register("makloba_block",
            () -> new MaklobaBlock(Block.Properties.copy(Blocks.CAKE), ModItems.MAKLOBA, true));
    public static final RegistryObject<Block> BOUREK_BLOCK = BLOCKS.register("bourek_block",
            () -> new BourekBlock(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> QUICHE = BLOCKS.register("quiche",
            () -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.QUICHE_SLICE));

    public static final RegistryObject<Block> FANOUS = BLOCKS.register("fanous",
            () -> new FanousLantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SOUL_FANOUS = BLOCKS.register("soul_fanous",
            () -> new FanousLantern(BlockBehaviour.Properties.copy(Blocks.SOUL_LANTERN).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> REDSTONE_FANOUS = BLOCKS.register("redstone_fanous",
            () -> new FanousLantern(BlockBehaviour.Properties.copy(Blocks.LANTERN).pushReaction(PushReaction.DESTROY)));

    public static final RegistryObject<Block> MOSAIC_TILES = registerBlock("mosaic_tiles",
            () -> new CustomTiles(BlockBehaviour.Properties.copy(Blocks.CALCITE)));
    public static final RegistryObject<Block> DRUM_BLOCK = BLOCKS.register("drum",
            () -> new DrumBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<Block> WINDOW_BLOCK = registerBlock("window_block",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(1.2f, 3.0f)));

    public static final RegistryObject<Block> BLUE_STAINED_WINDOW_BLOCK = registerBlock("blue_stained_window_block",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(1.2f, 3.0f)));
    public static final RegistryObject<Block> GREEN_STAINED_WINDOW_BLOCK = registerBlock("green_stained_window_block",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(1.2f, 3.0f)));
    public static final RegistryObject<Block> ORANGE_STAINED_WINDOW_BLOCK = registerBlock("orange_stained_window_block",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(1.2f, 3.0f)));
}
