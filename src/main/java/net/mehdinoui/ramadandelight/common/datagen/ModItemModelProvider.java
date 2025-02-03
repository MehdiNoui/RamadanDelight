package net.mehdinoui.ramadandelight.common.datagen;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, RamadanDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.HARIRA);
        simpleItem(ModItems.CHORBA);
        simpleItem(ModItems.HALEEM);
        simpleItem(ModItems.BOUREK);
        simpleItem(ModItems.BOUREK_SHEET);
        simpleItem(ModItems.BOUREK_BLOCK);
        simpleItem(ModItems.RAW_BOUREK);
        simpleItem(ModItems.RAW_SAMOSA);
        simpleItem(ModItems.SAMOSA);
        simpleItem(ModItems.RAW_KEBAB);
        simpleItem(ModItems.KEBAB);
        simpleItem(ModItems.MANAKISH);
        simpleItem(ModItems.MAKLOBA_BLOCK);
        simpleItem(ModItems.MAKLOBA);
        simpleItem(ModItems.SAYADIEH);
        simpleItem(ModItems.TABBOULEH);
        simpleItem(ModItems.PARSLEY);
        simpleItem(ModItems.PARSLEY_SEEDS);
        simpleItem(ModItems.FLAT_BREAD);
        simpleItem(ModItems.TAGINE);
        simpleItem(ModItems.QUICHE);
        simpleItem(ModItems.QUICHE_SLICE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RamadanDelight.MOD_ID,"item/" + item.getId().getPath()));
    }
}