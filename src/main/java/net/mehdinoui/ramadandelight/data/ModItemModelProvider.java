package net.mehdinoui.ramadandelight.data;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModBlocks;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

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
        simpleBlock(ModBlocks.CHICKPEA_BAG);
        simpleBlock(ModBlocks.DATE_CRATE);
        simpleBlock(ModBlocks.PARSLEY_BAG);
        simpleBlock(ModBlocks.MOSAIC_TILES);
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
    public void buttonItem(DeferredHolder<Block, ? extends Block> block, DeferredHolder<Block, ? extends Block> baseBlock) {
        String path = block.getId().getPath();
        String basePath = baseBlock.getId().getPath();
        this.withExistingParent(path, mcLoc("block/button_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "block/" + basePath));
    }

    public void fenceItem(DeferredHolder<Block, ? extends Block> block, DeferredHolder<Block, ? extends Block> baseBlock) {
        String path = block.getId().getPath();
        String basePath = baseBlock.getId().getPath();
        this.withExistingParent(path, mcLoc("block/fence_inventory"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "block/" + basePath));
    }

    public void fenceGateItem(DeferredHolder<Block, ? extends Block> block, DeferredHolder<Block, ? extends Block> baseBlock) {
        String path = block.getId().getPath();
        String basePath = baseBlock.getId().getPath();
        this.withExistingParent(path, mcLoc("block/template_fence_gate"))
                .texture("texture", ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "block/" + basePath));
    }

    // Helpers
    private ItemModelBuilder simpleItem(DeferredHolder<Item, ? extends Item> item) {
        String path = item.getId().getPath();
        return withExistingParent(path, ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "item/" + path));
    }

    public void simpleBlock(DeferredHolder<Block, ? extends Block> block) {
        String path = block.getId().getPath();
        this.withExistingParent(path, modLoc("block/" + path));
    }

    private ItemModelBuilder simpleBlockLayer0(DeferredHolder<Block, ? extends Block> block) {
        String path = block.getId().getPath();
        return withExistingParent(path, ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "block/" + path));
    }

    private ItemModelBuilder simpleBlockLayer0Custom(DeferredHolder<Block, ? extends Block> block, DeferredHolder<Block, ? extends Block> baseBlock) {
        String path = block.getId().getPath();
        String basePath = baseBlock.getId().getPath();
        return withExistingParent(path, ResourceLocation.withDefaultNamespace("item/generated"))
                .texture("layer0", ResourceLocation.fromNamespaceAndPath(RamadanDelight.MOD_ID, "block/" + basePath));
    }
}