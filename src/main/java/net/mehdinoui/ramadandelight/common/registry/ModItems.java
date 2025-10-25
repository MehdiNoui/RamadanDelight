package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.entity.custom.RDBoatEntity;
import net.mehdinoui.ramadandelight.common.item.ModFoods;
import net.mehdinoui.ramadandelight.common.item.custom.ModBoatItem;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static vectorwing.farmersdelight.common.registry.ModItems.*;


public class ModItems {
    //long list of ITEMS
    public final static DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RamadanDelight.MOD_ID);

    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    // --- Blocks ---
    public static final RegistryObject<Item> PARSLEY_BAG = ITEMS.register("parsley_bag",
            () -> new BlockItem(ModBlocks.PARSLEY_BAG.get(), basicItem()));
    public static final RegistryObject<Item> WILD_PARSLEY = ITEMS.register("wild_parsley",
            () -> new BlockItem(ModBlocks.WILD_PARSLEY.get(), basicItem()));

    public static final RegistryObject<Item> CHICKPEA_BAG = ITEMS.register("chickpea_bag",
            () -> new BlockItem(ModBlocks.CHICKPEA_BAG.get(), basicItem()));
    public static final RegistryObject<Item> WILD_CHICKPEA = ITEMS.register("wild_chickpea",
            () -> new BlockItem(ModBlocks.WILD_CHICKPEA.get(), basicItem()));

    public static final RegistryObject<Item> MOSAIC_TILES = ITEMS.register("mosaic_tiles",
            () -> new BlockItem(ModBlocks.MOSAIC_TILES.get(), basicItem()));

    public static final RegistryObject<Item> STAINED_GLASS_BLOCK = ITEMS.register("stained_glass_block",
            () -> new BlockItem(ModBlocks.STAINED_GLASS_BLOCK.get(), basicItem()));
    public static final RegistryObject<Item> BLUE_STAINED_GLASS_BLOCK = ITEMS.register("blue_stained_glass_block",
            () -> new BlockItem(ModBlocks.BLUE_STAINED_GLASS_BLOCK.get(), basicItem()));
    public static final RegistryObject<Item> GREEN_STAINED_GLASS_BLOCK = ITEMS.register("green_stained_glass_block",
            () -> new BlockItem(ModBlocks.GREEN_STAINED_GLASS_BLOCK.get(), basicItem()));
    public static final RegistryObject<Item> ORANGE_STAINED_GLASS_BLOCK = ITEMS.register("orange_stained_glass_block",
            () -> new BlockItem(ModBlocks.ORANGE_STAINED_GLASS_BLOCK.get(), basicItem()));

    public static final RegistryObject<Item> STAINED_GLASS_PANE = ITEMS.register("stained_glass_pane",
            () -> new BlockItem(ModBlocks.STAINED_GLASS_PANE.get(), basicItem()));
    public static final RegistryObject<Item> BLUE_STAINED_GLASS_PANE = ITEMS.register("blue_stained_glass_pane",
            () -> new BlockItem(ModBlocks.BLUE_STAINED_GLASS_PANE.get(), basicItem()));
    public static final RegistryObject<Item> GREEN_STAINED_GLASS_PANE = ITEMS.register("green_stained_glass_pane",
            () -> new BlockItem(ModBlocks.GREEN_STAINED_GLASS_PANE.get(), basicItem()));
    public static final RegistryObject<Item> ORANGE_STAINED_GLASS_PANE = ITEMS.register("orange_stained_glass_pane",
            () -> new BlockItem(ModBlocks.ORANGE_STAINED_GLASS_PANE.get(), basicItem()));

    // Palm wood set
    public static final RegistryObject<Item> PALM_LOG = ITEMS.register("palm_log",
            () -> new BlockItem(ModBlocks.PALM_LOG.get(), basicItem()));
    public static final RegistryObject<Item> PALM_WOOD = ITEMS.register("palm_wood",
            () -> new BlockItem(ModBlocks.PALM_WOOD.get(), basicItem()));
    public static final RegistryObject<Item> STRIPPED_PALM_LOG = ITEMS.register("stripped_palm_log",
            () -> new BlockItem(ModBlocks.STRIPPED_PALM_LOG.get(), basicItem()));
    public static final RegistryObject<Item> STRIPPED_PALM_WOOD = ITEMS.register("stripped_palm_wood",
            () -> new BlockItem(ModBlocks.STRIPPED_PALM_WOOD.get(), basicItem()));

    public static final RegistryObject<Item> PALM_PLANKS = ITEMS.register("palm_planks",
            () -> new BlockItem(ModBlocks.PALM_PLANKS.get(), basicItem()));
    public static final RegistryObject<Item> PALM_LEAVES = ITEMS.register("palm_leaves",
            () -> new BlockItem(ModBlocks.PALM_LEAVES.get(), basicItem()));
    public static final RegistryObject<Item> PALM_SAPLING = ITEMS.register("palm_sapling",
            () -> new BlockItem(ModBlocks.PALM_SAPLING.get(), basicItem()));

    public static final RegistryObject<Item> PALM_STAIRS = ITEMS.register("palm_stairs",
            () -> new BlockItem(ModBlocks.PALM_STAIRS.get(), basicItem()));
    public static final RegistryObject<Item> PALM_SLAB = ITEMS.register("palm_slab",
            () -> new BlockItem(ModBlocks.PALM_SLAB.get(), basicItem()));
    public static final RegistryObject<Item> PALM_PRESSURE_PLATE = ITEMS.register("palm_pressure_plate",
            () -> new BlockItem(ModBlocks.PALM_PRESSURE_PLATE.get(), basicItem()));
    public static final RegistryObject<Item> PALM_BUTTON = ITEMS.register("palm_button",
            () -> new BlockItem(ModBlocks.PALM_BUTTON.get(), basicItem()));
    public static final RegistryObject<Item> PALM_FENCE = ITEMS.register("palm_fence",
            () -> new BlockItem(ModBlocks.PALM_FENCE.get(), basicItem()));
    public static final RegistryObject<Item> PALM_FENCE_GATE = ITEMS.register("palm_fence_gate",
            () -> new BlockItem(ModBlocks.PALM_FENCE_GATE.get(), basicItem()));
    public static final RegistryObject<Item> PALM_DOOR = ITEMS.register("palm_door",
            () -> new BlockItem(ModBlocks.PALM_DOOR.get(), basicItem()));
    public static final RegistryObject<Item> PALM_TRAPDOOR = ITEMS.register("palm_trapdoor",
            () -> new BlockItem(ModBlocks.PALM_TRAPDOOR.get(), basicItem()));



    //Soups
    public static final RegistryObject<Item> HARIRA = ITEMS.register("harira",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.HARIRA),true));
    public static final RegistryObject<Item> CHORBA = ITEMS.register("chorba",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.CHORBA),true));
    public static final RegistryObject<Item> HALEEM = ITEMS.register("haleem",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.HALEEM),true));

    //Savory and misc
    public static final RegistryObject<Item> SAVORY_FILLING = ITEMS.register("savory_filling",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.SAVORY_FILLING),true));

    public static final RegistryObject<Item> BOUREK = ITEMS.register("bourek",
            () -> new Item(new Item.Properties().food(ModFoods.BOUREK)));
    public static final RegistryObject<Item> BOUREK_SHEET = ITEMS.register("bourek_sheet",
            () -> new Item(new Item.Properties().food(ModFoods.BOUREK_SHEET)));
    public static final RegistryObject<Item> RAW_BOUREK = ITEMS.register("raw_bourek",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_BOUREK)));
    public static final RegistryObject<Item> BOUREK_BLOCK = ITEMS.register("bourek_block",
            () -> new BlockItem(ModBlocks.BOUREK_BLOCK.get(), basicItem().stacksTo(1)));

    public static final RegistryObject<Item> RAW_SAMOSA = ITEMS.register("raw_samosa",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_SAMOSA)));
    public static final RegistryObject<Item> SAMOSA = ITEMS.register("samosa",
            () -> new Item(new Item.Properties().food(ModFoods.SAMOSA)));

    public static final RegistryObject<Item> RAW_KEBAB = ITEMS.register("raw_kebab",
            () -> new Item(new Item.Properties().food(ModFoods.RAW_KEBAB)));
    public static final RegistryObject<Item> KEBAB = ITEMS.register("kebab",
            () -> new Item(new Item.Properties().food(ModFoods.KEBAB)));

    public static final RegistryObject<Item> SMALL_DOUGH = ITEMS.register("small_dough",
            () -> new Item(new Item.Properties().food(ModFoods.SMALL_DOUGH)));
    public static final RegistryObject<Item> FLAT_BREAD = ITEMS.register("flat_bread",
            () -> new Item(new Item.Properties().food(ModFoods.FLAT_BREAD)));
    public static final RegistryObject<Item> MUSAKHAN = ITEMS.register("musakhan",
            () -> new Item(new Item.Properties().food(ModFoods.MUSAKHAN)));

    //Dishes
    public static final RegistryObject<Item> MAKLOBA_BLOCK = ITEMS.register("makloba_block",
            () -> new BlockItem(ModBlocks.MAKLOBA_BLOCK.get(), basicItem().stacksTo(1)));
    public static final RegistryObject<Item> MAKLOBA = ITEMS.register("makloba",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.MAKLOBA),true));
    public static final RegistryObject<Item> SAYADIEH = ITEMS.register("sayadieh",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.SAYADIEH),true));
    public static final RegistryObject<Item> TAGINE = ITEMS.register("tagine",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.TAGINE),true));
    public static final RegistryObject<Item> CHICKPEA_AND_RICE = ITEMS.register("chickpea_and_rice",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.CHICKPEA_AND_RICE),true));
    public static final RegistryObject<Item> SWEET_TAGINE = ITEMS.register("sweet_tagine",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.SWEET_TAGINE),true));
    public static final RegistryObject<Item> HUMMUS_TAHINI = ITEMS.register("hummus_tahini",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.HUMMUS_TAHINI),true));

    //Salads
    public static final RegistryObject<Item> TABBOULEH = ITEMS.register("tabbouleh",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.TABBOULEH),true));

    //Parsley
    public static final RegistryObject<Item> PARSLEY = ITEMS.register("parsley",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> PARSLEY_SEEDS = ITEMS.register("parsley_seeds",
            ()->new ItemNameBlockItem(ModBlocks.PARSLEY_CROP.get(),new Item.Properties()));

    //Chickpea
    public static final RegistryObject<Item> CHICKPEA = ITEMS.register("chickpea",
            ()->new ItemNameBlockItem(ModBlocks.CHICKPEA_CROP.get(),new Item.Properties()
                    .food(ModFoods.CHICKPEA)));

    //Quiche
    public static final RegistryObject<Item> QUICHE = ITEMS.register("quiche",
            () -> new BlockItem(ModBlocks.QUICHE.get(), basicItem()));
    public static final RegistryObject<Item> QUICHE_SLICE = ITEMS.register("quiche_slice",
            ()->new Item(new Item.Properties().food(ModFoods.QUICHE_SLICE)));

    //Fanous
    public static final RegistryObject<Item> FANOUS = ITEMS.register("fanous",
            () -> new BlockItem(ModBlocks.FANOUS.get(), basicItem()));
    public static final RegistryObject<Item> COPPER_FANOUS = ITEMS.register("copper_fanous",
            () -> new BlockItem(ModBlocks.COPPER_FANOUS.get(), basicItem()));
    public static final RegistryObject<Item> REDSTONE_FANOUS = ITEMS.register("redstone_fanous",
            () -> new BlockItem(ModBlocks.REDSTONE_FANOUS.get(), basicItem()));
    public static final RegistryObject<Item> SOUL_FANOUS = ITEMS.register("soul_fanous",
            () -> new BlockItem(ModBlocks.SOUL_FANOUS.get(), basicItem()));


    //Misc
    public static final RegistryObject<Item> DRUM = ITEMS.register("drum",
            () -> new BlockItem(ModBlocks.DRUM_BLOCK.get(), basicItem()));

    //Dates
    public static final RegistryObject<Item> DATE = ITEMS.register("date",
            () -> new Item(new Item.Properties().food(ModFoods.DATE)));
    public static final RegistryObject<Item> DATE_STUFFED_COOKIE = ITEMS.register("date_stuffed_cookie",
            () -> new Item(new Item.Properties().food(ModFoods.DATE_STUFFED_COOKIE)));
    public static final RegistryObject<Item> DATES_BRANCH = ITEMS.register("dates_branch",
            () -> new BlockItem(ModBlocks.DATES_BRANCH.get(), basicItem()));
    public static final RegistryObject<Item> CLUSTER_OF_DATES = ITEMS.register("cluster_of_dates",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> DATE_SYRUP = ITEMS.register("date_syrup",
            () -> new DrinkableItem(drinkItem().food(ModFoods.DATE_SYRUP), true, false) {
                @Override
                public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity consumer) {
                    if (!level.isClientSide) { consumer.removeAllEffects(); }
                    return super.finishUsingItem(stack, level, consumer);
                }
            });

    //DESERTS
    public static final RegistryObject<Item> MHALBIYA = ITEMS.register("mhalbiya",
            () -> new ConsumableItem(foodItem(ModFoods.MHALBIYA).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    public static final RegistryObject<Item> ZALABIYA = ITEMS.register("zalabiya",
            () -> new Item(new Item.Properties().food(ModFoods.ZALABIYA)));
    public static final RegistryObject<Item> LUQAIMAT = ITEMS.register("luqaimat",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.LUQAIMAT),true));
    public static final RegistryObject<Item> KUNAFA = ITEMS.register("kunafa",
            () -> new Item(new Item.Properties().food(ModFoods.KUNAFA)));

    //SIGNS
    public static final RegistryObject<Item> PALM_SIGN = ITEMS.register("palm_sign",
            () -> new SignItem(new Item.Properties().stacksTo(16),
                    ModBlocks.PALM_SIGN.get(),ModBlocks.PALM_WALL_SIGN.get()));
    public static final RegistryObject<Item> PALM_HANGING_SIGN = ITEMS.register("palm_hanging_sign",
            () -> new HangingSignItem(ModBlocks.PALM_HANGING_SIGN.get(),ModBlocks.PALM_WALL_HANGING_SIGN.get(),
                new Item.Properties().stacksTo(16)));

    //BOATS
    public static final RegistryObject<Item> PALM_BOAT = ITEMS.register("palm_boat",
            () -> new ModBoatItem(false, RDBoatEntity.Type.PALM,
                    new Item.Properties()));
    public static final RegistryObject<Item> PALM_CHEST_BOAT = ITEMS.register("palm_chest_boat",
            () -> new ModBoatItem(true, RDBoatEntity.Type.PALM,
                    new Item.Properties()));
}
