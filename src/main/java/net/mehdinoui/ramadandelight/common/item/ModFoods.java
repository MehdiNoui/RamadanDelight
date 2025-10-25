package net.mehdinoui.ramadandelight.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static vectorwing.farmersdelight.common.FoodValues.*;

public class ModFoods {

    // RAW CROPS
    public static final FoodProperties CHICKPEA = new FoodProperties.Builder().
            nutrition(2).saturationMod(0.1F).fast().build();

    // DATES
    public static final FoodProperties DATE = new FoodProperties.Builder().
            nutrition(4).saturationMod(0.3f).build();
    public static final FoodProperties DATE_STUFFED_COOKIE = new FoodProperties.Builder().
            nutrition(6).saturationMod(0.6f).build();
    public static final FoodProperties DATE_SYRUP = new FoodProperties.Builder().
            effect(() -> new MobEffectInstance(MobEffects.SATURATION, 100, 0), 1.0F).
            nutrition(8).saturationMod(0.6f).alwaysEat().build();

    // DESSERTS & SWEETS
    public static final FoodProperties KUNAFA = new FoodProperties.Builder().
            nutrition(10).saturationMod(0.7F).build();
    public static final FoodProperties LUQAIMAT= new FoodProperties.Builder().
            nutrition(10).saturationMod(0.7F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), SHORT_DURATION, 0), 1.0F)
            .build();
    public static final FoodProperties MHALBIYA= new FoodProperties.Builder().
            nutrition(7).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.LUCK, 100, 0), 1.0F)
            .build();
    public static final FoodProperties ZALABIYA = new FoodProperties.Builder().
            nutrition(8).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 100, 0), 0.3F)
            .build();

    // BASIC INGREDIENTS & COMPONENTS
    public static final FoodProperties BOUREK_SHEET = new FoodProperties.Builder().
            nutrition(2).saturationMod(0.1F).fast().build();
    public static final FoodProperties SMALL_DOUGH = new FoodProperties.Builder().
            nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.3F)
            .build();
    public static final FoodProperties SAVORY_FILLING = new FoodProperties.Builder().
            nutrition(8).saturationMod(0.6F).build();

    // SALADS
    public static final FoodProperties TABBOULEH = new FoodProperties.Builder().
            nutrition(6).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F)
            .build();

    // SNACKS & BAKED GOODS
    public static final FoodProperties BOUREK = new FoodProperties.Builder().
            nutrition(10).saturationMod(0.75F).build();
    public static final FoodProperties FLAT_BREAD = new FoodProperties.Builder().
            nutrition(3).saturationMod(0.3F).fast().build();
    public static final FoodProperties KEBAB = new FoodProperties.Builder().
            nutrition(7).saturationMod(0.7F).fast().build();
    public static final FoodProperties MUSAKHAN = new FoodProperties.Builder().
            nutrition(9).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0), 1.0F)
            .build();
    public static final FoodProperties QUICHE_SLICE = new FoodProperties.Builder().
            nutrition(7).saturationMod(0.6f).build();
    public static final FoodProperties RAW_BOUREK= new FoodProperties.Builder().
            nutrition(6).saturationMod(0.3F).build();
    public static final FoodProperties RAW_SAMOSA = new FoodProperties.Builder().
            nutrition(3).saturationMod(0.3F).build();
    public static final FoodProperties RAW_KEBAB = new FoodProperties.Builder().
            nutrition(2).saturationMod(0.3F).build();
    public static final FoodProperties SAMOSA = new FoodProperties.Builder().
            nutrition(6).saturationMod(0.6F).fast().build();

    // SOUPS & BOWLED MEALS
    public static final FoodProperties CHORBA = new FoodProperties.Builder().
            nutrition(10).saturationMod(0.7F)
            .effect(()-> new MobEffectInstance(ModEffects.COMFORT.get(), BRIEF_DURATION,0),1.0f)
            .build();
    public static final FoodProperties HALEEM = new FoodProperties.Builder().
            nutrition(14).saturationMod(0.75f)
            .effect(()-> new MobEffectInstance(ModEffects.COMFORT.get(), LONG_DURATION,0),1.0f)
            .build();
    public static final FoodProperties HARIRA = new FoodProperties.Builder().
            nutrition(12).saturationMod(0.7F)
            .effect(()-> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION,0),1.0f)
            .build();
    public static final FoodProperties HUMMUS_TAHINI = new FoodProperties.Builder().
            nutrition(6).saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 100, 0), 1.0F)
            .build();
    public static final FoodProperties SWEET_TAGINE = new FoodProperties.Builder().
            nutrition(12).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            .build();

    // PLATED MEALS
    public static final FoodProperties CHICKPEA_AND_RICE = new FoodProperties.Builder().
            nutrition(10).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), SHORT_DURATION, 0), 1.0F)
            .build();
    public static final FoodProperties SAYADIEH = new FoodProperties.Builder().
            nutrition(12).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F)
            .build();
    public static final FoodProperties TAGINE = new FoodProperties.Builder().
            nutrition(14).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F)
            .build();

    // FEAST SLICES
    public static final FoodProperties MAKLOBA = new FoodProperties.Builder().
            nutrition(14).saturationMod(0.75f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F)
            .build();
}
