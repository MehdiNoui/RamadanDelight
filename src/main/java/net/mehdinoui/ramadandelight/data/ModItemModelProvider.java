package net.mehdinoui.ramadandelight.data;

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
        // Items
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
        simpleItem(ModItems.MUSAKHAN);
        simpleItem(ModItems.MAQLUBA_BLOCK);
        simpleItem(ModItems.MAQLUBA);
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
        simpleItem(ModItems.COPPER_FANOUS);
        simpleItem(ModItems.REDSTONE_FANOUS);
        simpleItem(ModItems.SOUL_FANOUS);
        simpleItem(ModItems.DRUM);
        simpleItem(ModItems.DATES_BRANCH);
        simpleItem(ModItems.DATE);
        simpleItem(ModItems.DATE_STUFFED_COOKIE);
        simpleItem(ModItems.CLUSTER_OF_DATES);
        simpleItem(ModItems.CHICKPEA);
        simpleItem(ModItems.SWEET_TAGINE);
        simpleItem(ModItems.ZALABIYEH);
        simpleItem(ModItems.LUQAIMAT);
        simpleItem(ModItems.MAHALABIA);
        simpleItem(ModItems.KNAFEH_TRAY_BLOCK);
        simpleItem(ModItems.KNAFEH);
        simpleItem(ModItems.DATE_SYRUP);
        simpleItem(ModItems.CHICKPEA_AND_RICE);
        simpleItem(ModItems.HUMMUS_TAHINI);
        // Blocks
        // Bags
        simpleBlock(ModBlocks.CHICKPEA_BAG);
        simpleBlock(ModBlocks.DATE_CRATE);
        simpleBlock(ModBlocks.PARSLEY_BAG);
        // Mosaic Tiles
        simpleBlock(ModBlocks.MOSAIC_TILES);
        // Glass
        simpleBlock(ModBlocks.STAINED_GLASS_BLOCK);
        simpleBlock(ModBlocks.BLUE_STAINED_GLASS_BLOCK);
        simpleBlock(ModBlocks.GREEN_STAINED_GLASS_BLOCK);
        simpleBlock(ModBlocks.ORANGE_STAINED_GLASS_BLOCK);
        // Glass Panes
        simpleBlockLayer0Custom(ModBlocks.STAINED_GLASS_PANE, ModBlocks.STAINED_GLASS_BLOCK);
        simpleBlockLayer0Custom(ModBlocks.BLUE_STAINED_GLASS_PANE, ModBlocks.BLUE_STAINED_GLASS_BLOCK);
        simpleBlockLayer0Custom(ModBlocks.GREEN_STAINED_GLASS_PANE, ModBlocks.GREEN_STAINED_GLASS_BLOCK);
        simpleBlockLayer0Custom(ModBlocks.ORANGE_STAINED_GLASS_PANE, ModBlocks.ORANGE_STAINED_GLASS_BLOCK);
        // Wild Flowers and Saplings
        simpleBlockLayer0(ModBlocks.PALM_SAPLING);
        simpleBlockLayer0(ModBlocks.WILD_CHICKPEA);
        simpleBlockLayer0(ModBlocks.WILD_PARSLEY);
        // Wood
        buttonItem(ModBlocks.PALM_BUTTON, ModBlocks.PALM_PLANKS);
        fenceItem(ModBlocks.PALM_FENCE, ModBlocks.PALM_PLANKS);
        fenceGateItem(ModBlocks.PALM_FENCE_GATE, ModBlocks.PALM_PLANKS);

        simpleBlock(ModBlocks.PALM_LOG);
        simpleBlock(ModBlocks.PALM_WOOD);
        simpleBlock(ModBlocks.STRIPPED_PALM_LOG);
        simpleBlock(ModBlocks.STRIPPED_PALM_WOOD);
        simpleBlock(ModBlocks.PALM_LEAVES);
        simpleBlock(ModBlocks.PALM_PLANKS);

        simpleItem(ModItems.PALM_BOAT);
        simpleItem(ModItems.PALM_CHEST_BOAT);
        simpleItem(ModItems.PALM_DOOR);
        simpleItem(ModItems.PALM_SIGN);
        simpleItem(ModItems.PALM_HANGING_SIGN);
    }
    // Palm Stuff Helpers
    public void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation(RamadanDelight.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(RamadanDelight.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    public void fenceGateItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/template_fence_gate"))
                .texture("texture",  new ResourceLocation(RamadanDelight.MOD_ID, "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    // Helpers
    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RamadanDelight.MOD_ID,"item/" + item.getId().getPath()));
    }
    public void simpleBlock(RegistryObject<Block> block) {
        this.withExistingParent(
                RamadanDelight.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    private ItemModelBuilder simpleBlockLayer0(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RamadanDelight.MOD_ID,"block/" + item.getId().getPath()));
    }
    private ItemModelBuilder simpleBlockLayer0Custom(RegistryObject<Block> item, RegistryObject<Block> baseBlock) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(RamadanDelight.MOD_ID,"block/"  + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
}