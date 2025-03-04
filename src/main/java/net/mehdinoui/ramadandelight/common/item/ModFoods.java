package net.mehdinoui.ramadandelight.common.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static vectorwing.farmersdelight.common.FoodValues.*;

public class ModFoods {

    //Chickpea
    public static final FoodProperties CHICKPEA = new FoodProperties.Builder().
            nutrition(2).saturationMod(0.1F).fast().build();

    //Soups
    public static final FoodProperties CHORBA = new FoodProperties.Builder().
            nutrition(10).saturationMod(0.75F)
            .effect(()-> new MobEffectInstance(ModEffects.COMFORT.get(),BRIEF_DURATION,0),1.0f)
            .build();
    public static final FoodProperties HALEEM = new FoodProperties.Builder().
            nutrition(12).saturationMod(0.8f)
            .effect(()-> new MobEffectInstance(ModEffects.COMFORT.get(),BRIEF_DURATION,0),1.0f)
            .build();
    public static final FoodProperties HARIRA = new FoodProperties.Builder().
            nutrition(11).saturationMod(0.6F)
            .effect(()-> new MobEffectInstance(ModEffects.COMFORT.get(),BRIEF_DURATION,0),1.0f)
            .build();

    //Bourek
    public static final FoodProperties BOUREK_SHEET = new FoodProperties.Builder().
            nutrition(2).saturationMod(0.1F).fast().build();
    public static final FoodProperties RAW_BOUREK= new FoodProperties.Builder().
            nutrition(5).saturationMod(0.3F).build();
    public static final FoodProperties BOUREK = new FoodProperties.Builder().
            nutrition(10).saturationMod(0.8F).build();

    //Samosa
    public static final FoodProperties RAW_SAMOSA = new FoodProperties.Builder().
            nutrition(3).saturationMod(0.3F).build();
    public static final FoodProperties SAMOSA = new FoodProperties.Builder().
            nutrition(6).saturationMod(0.6F).fast().build();

    //Kebab
    public static final FoodProperties RAW_KEBAB = new FoodProperties.Builder().
            nutrition(2).saturationMod(0.3F).build();
    public static final FoodProperties KEBAB = new FoodProperties.Builder().
            nutrition(5).saturationMod(0.8F).fast().build();

    //Free Palestine
    public static final FoodProperties FLAT_BREAD = new FoodProperties.Builder().
            nutrition(3).saturationMod(0.3F).fast().build();
    public static final FoodProperties MANAKISH = new FoodProperties.Builder().
            nutrition(9).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, BRIEF_DURATION, 0), 1.0F)
            .build();

    //Dishes
    public static final FoodProperties MAKLOBA = new FoodProperties.Builder().
            nutrition(14).saturationMod(0.75f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), LONG_DURATION, 0), 1.0F)
            .build();
    public static final FoodProperties SAYADIEH = new FoodProperties.Builder().
            nutrition(10).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), MEDIUM_DURATION, 0), 1.0F)
            .build();
    public static final FoodProperties TAGINE = new FoodProperties.Builder().
            nutrition(12).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), MEDIUM_DURATION, 0), 1.0F)
            .build();

    //Salades
    public static final FoodProperties TABBOULEH = new FoodProperties.Builder().
            nutrition(6).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 0), 1.0F)
            .build();

    //Quiche
    public static final FoodProperties QUICHE_SLICE = new FoodProperties.Builder().
            nutrition(7).saturationMod(0.6f).build();

    //Dates

    public static final FoodProperties DATE = new FoodProperties.Builder().
            nutrition(4).saturationMod(0.3f).build();
    public static final FoodProperties DATE_STUFFED_COOKIE = new FoodProperties.Builder().
            nutrition(6).saturationMod(0.6f).build();

    //misc
    public static final FoodProperties SMALL_DOUGH = new FoodProperties.Builder().
            nutrition(1).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.3F)
            .build();
    public static final FoodProperties SAVORY_FILLING = new FoodProperties.Builder().
            nutrition(7).saturationMod(0.6F).build();

}
