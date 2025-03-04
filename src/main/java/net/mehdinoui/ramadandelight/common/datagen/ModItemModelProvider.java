package net.mehdinoui.ramadandelight.common.datagen;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModBlocks;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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
        simpleItem(ModItems.SAVORY_FILLING);
        simpleItem(ModItems.SMALL_DOUGH);
        simpleItem(ModItems.FANOUS);
        simpleItem(ModItems.REDSTONE_FANOUS);
        simpleItem(ModItems.SOUL_FANOUS);
        simpleItem(ModItems.DRUM);
        simpleItem(ModItems.DATES_BRANCH);
        simpleItem(ModItems.DATE);
        simpleItem(ModItems.DATE_STUFFED_COOKIE);
        simpleItem(ModItems.CLUSTER_OF_DATES);
        simpleItem(ModItems.CHICKPEA);

        buttonItem(ModBlocks.PALM_BUTTON, ModBlocks.PALM_PLANKS);
        fenceItem(ModBlocks.PALM_FENCE, ModBlocks.PALM_PLANKS);
        simpleBlockItem(ModBlocks.PALM_DOOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RamadanDelight.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RamadanDelight.MOD_ID,"item/" + item.getId().getPath()));
    }

    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(RamadanDelight.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(RamadanDelight.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}