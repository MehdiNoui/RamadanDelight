package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.item.ModFoods;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

import static vectorwing.farmersdelight.common.registry.ModItems.basicItem;


public class ModItems {
    //long list of ITEMS
    public final static DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RamadanDelight.MOD_ID);

    public static Item.Properties bowlFoodItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.BOWL).stacksTo(16);
    }

    public static Item.Properties bottleItem(FoodProperties food) {
        return new Item.Properties().food(food).craftRemainder(Items.GLASS_BOTTLE).stacksTo(32);
    }

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    //Soups
    public static final RegistryObject<Item> HARIRA = ITEMS.register("harira",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.HARIRA),true));
    public static final RegistryObject<Item> CHORBA = ITEMS.register("chorba",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.CHORBA),true));
    public static final RegistryObject<Item> HALEEM = ITEMS.register("haleem",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.HALEEM),true));


    //Savory and misc
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

    public static final RegistryObject<Item> FLAT_BREAD = ITEMS.register("flat_bread",
            () -> new Item(new Item.Properties().food(ModFoods.MANAKISH)));
    public static final RegistryObject<Item> MANAKISH = ITEMS.register("manakish",
            () -> new Item(new Item.Properties().food(ModFoods.MANAKISH)));


    //Dishes
    public static final RegistryObject<Item> MAKLOBA_BLOCK = ITEMS.register("makloba_block",
            () -> new BlockItem(ModBlocks.MAKLOBA_BLOCK.get(), basicItem().stacksTo(1)));
    public static final RegistryObject<Item> MAKLOBA = ITEMS.register("makloba",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.MAKLOBA),true));

    public static final RegistryObject<Item> SAYADIEH = ITEMS.register("sayadieh",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.SAYADIEH),true));

    public static final RegistryObject<Item> TAGINE = ITEMS.register("tagine",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.SAYADIEH),true));


    //Salads
    public static final RegistryObject<Item> TABBOULEH = ITEMS.register("tabbouleh",
            ()->new ConsumableItem(bowlFoodItem(ModFoods.TABBOULEH),true));


    //Parsley
    public static final RegistryObject<Item> PARSLEY = ITEMS.register("parsley",
            ()->new Item(new Item.Properties()));
    public static final RegistryObject<Item> PARSLEY_SEEDS = ITEMS.register("parsley_seeds",
            ()->new ItemNameBlockItem(ModBlocks.PARSLEY_CROP.get(),new Item.Properties()));


    //Quiche
    public static final RegistryObject<Item> QUICHE = ITEMS.register("quiche",
            () -> new BlockItem(ModBlocks.QUICHE.get(), basicItem()));
    public static final RegistryObject<Item> QUICHE_SLICE = ITEMS.register("quiche_slice",
            ()->new Item(new Item.Properties().food(ModFoods.QUICHE_SLICE)));

}
