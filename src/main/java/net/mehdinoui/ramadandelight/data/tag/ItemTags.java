package net.mehdinoui.ramadandelight.data.tag;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.mehdinoui.ramadandelight.common.tag.RDCommonTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class ItemTags extends ItemTagsProvider {
    public ItemTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, CompletableFuture<TagLookup<Block>> blockTagProvider,
                    @Nullable ExistingFileHelper existingFileHelper) {
        super(output, provider, blockTagProvider, RamadanDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(@NotNull HolderLookup.Provider provider) {
        registerCommonTags();
        registerMinecraftTags();
        registerFarmersDelightTags();
        registerRamadanDelightTags();
    }

    protected void registerCommonTags() {
        // Storage Blocks Items
        tag(RDCommonTags.STORAGE_BLOCKS_ITEM_CHICKPEA).add(ModItems.CHICKPEA_BAG.get());
        tag(RDCommonTags.STORAGE_BLOCKS_ITEM_DATE).add(ModItems.DATE_CRATE.get());
        tag(RDCommonTags.STORAGE_BLOCKS_ITEM_PARSLEY).add(ModItems.PARSLEY_BAG.get());
        tag(Tags.Items.STORAGE_BLOCKS)
                .addTag(RDCommonTags.STORAGE_BLOCKS_ITEM_CHICKPEA)
                .addTag(RDCommonTags.STORAGE_BLOCKS_ITEM_DATE)
                .addTag(RDCommonTags.STORAGE_BLOCKS_ITEM_PARSLEY);

        tag(Tags.Items.DRINK_CONTAINING_BOTTLE).add(ModItems.DATE_SYRUP.get());

        // Foods
        tag(Tags.Items.FOODS_SOUP).add(ModItems.HARIRA.get()).add(ModItems.HALEEM.get()).add(ModItems.CHORBA.get());
        tag(Tags.Items.FOODS_COOKIE).add(ModItems.DATE_STUFFED_COOKIE.get());

        // Crops
        tag(Tags.Items.CROPS).addTag(RDCommonTags.CROPS_CHICKPEA);
        tag(RDCommonTags.CROPS_CHICKPEA).add(ModItems.CHICKPEA.get());
        tag(Tags.Items.CROPS).addTag(RDCommonTags.CROPS_PARSLEY);
        tag(RDCommonTags.CROPS_PARSLEY).add(ModItems.PARSLEY.get());

        // Dyed Blocks
        tag(Tags.Items.DYED_BLUE)
                .add(ModItems.BLUE_STAINED_GLASS_BLOCK.get())
                .add(ModItems.BLUE_STAINED_GLASS_PANE.get());
        tag(Tags.Items.DYED_GREEN)
                .add(ModItems.GREEN_STAINED_GLASS_BLOCK.get())
                .add(ModItems.GREEN_STAINED_GLASS_PANE.get());
        tag(Tags.Items.DYED_ORANGE)
                .add(ModItems.ORANGE_STAINED_GLASS_BLOCK.get())
                .add(ModItems.ORANGE_STAINED_GLASS_PANE.get());

        // Grains
        tag(CommonTags.CROPS_GRAIN).addTag(RDCommonTags.GRAIN_CHICKPEA);
        tag(RDCommonTags.GRAIN_CHICKPEA).add(ModItems.CHICKPEA.get());

        // Seeds
        tag(Tags.Items.SEEDS).addTag(RDCommonTags.SEEDS_PARSLEY);
        tag(RDCommonTags.SEEDS_PARSLEY).add(ModItems.PARSLEY_SEEDS.get());

        // Fruits
        tag(Tags.Items.FOODS_FRUIT).add(ModItems.DATE.get());

        // Tortilla / Bread
        tag(RDCommonTags.TORTILLA).add(ModItems.FLAT_BREAD.get());

        // Logs
        tag(Tags.Items.STRIPPED_LOGS).add(ModItems.STRIPPED_PALM_LOG.get());
        tag(Tags.Items.STRIPPED_WOODS).add(ModItems.STRIPPED_PALM_WOOD.get());

        // Glass Blocks
        tag(Tags.Items.GLASS_BLOCKS_COLORLESS).add(ModItems.STAINED_GLASS_BLOCK.get());
        tag(Tags.Items.GLASS_BLOCKS).add(ModItems.BLUE_STAINED_GLASS_BLOCK.get());
        tag(Tags.Items.GLASS_BLOCKS).add(ModItems.GREEN_STAINED_GLASS_BLOCK.get());
        tag(Tags.Items.GLASS_BLOCKS).add(ModItems.ORANGE_STAINED_GLASS_BLOCK.get());

        // Glass Panes
        tag(Tags.Items.GLASS_PANES_COLORLESS).add(ModItems.STAINED_GLASS_PANE.get());
        tag(Tags.Items.GLASS_PANES).add(ModItems.BLUE_STAINED_GLASS_PANE.get());
        tag(Tags.Items.GLASS_PANES).add(ModItems.GREEN_STAINED_GLASS_PANE.get());
        tag(Tags.Items.GLASS_PANES).add(ModItems.ORANGE_STAINED_GLASS_PANE.get());

        // Wooden Fences & Gates
        tag(Tags.Items.FENCES_WOODEN).add(ModItems.PALM_FENCE.get());
        tag(Tags.Items.FENCE_GATES_WOODEN).add(ModItems.PALM_FENCE_GATE.get());
    }
    protected void registerMinecraftTags() {
        // Animals
        tag(net.minecraft.tags.ItemTags.BEE_FOOD).add(ModItems.DATE.get());
        tag(net.minecraft.tags.ItemTags.CAMEL_FOOD).add(ModItems.DATE.get());
        tag(net.minecraft.tags.ItemTags.CHICKEN_FOOD)
                .add(ModItems.CHICKPEA.get())
                .add(ModItems.PARSLEY_SEEDS.get());
        tag(net.minecraft.tags.ItemTags.COW_FOOD).add(ModItems.PARSLEY.get());
        tag(net.minecraft.tags.ItemTags.GOAT_FOOD).add(ModItems.PARSLEY.get());
        tag(net.minecraft.tags.ItemTags.HORSE_FOOD).add(ModItems.PARSLEY.get());
        tag(net.minecraft.tags.ItemTags.LLAMA_FOOD).add(ModItems.PARSLEY.get());
        tag(net.minecraft.tags.ItemTags.PARROT_FOOD)
                .add(ModItems.CHICKPEA.get())
                .add(ModItems.PARSLEY_SEEDS.get());
        tag(net.minecraft.tags.ItemTags.PIG_FOOD).add(ModItems.CHICKPEA.get());
        tag(net.minecraft.tags.ItemTags.RABBIT_FOOD).add(ModItems.PARSLEY.get());
        tag(net.minecraft.tags.ItemTags.SHEEP_FOOD).add(ModItems.PARSLEY.get());

        // Boats
        tag(net.minecraft.tags.ItemTags.BOATS).add(ModItems.PALM_BOAT.get());
        tag(net.minecraft.tags.ItemTags.CHEST_BOATS).add(ModItems.PALM_CHEST_BOAT.get());

        // Fences and Gates
        tag(net.minecraft.tags.ItemTags.FENCES).add(ModItems.PALM_FENCE.get());
        tag(net.minecraft.tags.ItemTags.FENCE_GATES).add(ModItems.PALM_FENCE_GATE.get());

        // Hanging Signs
        tag(net.minecraft.tags.ItemTags.HANGING_SIGNS).add(ModItems.PALM_HANGING_SIGN.get());

        // Leaves, Logs, Planks
        tag(net.minecraft.tags.ItemTags.LEAVES).add(ModItems.PALM_LEAVES.get());
        tag(net.minecraft.tags.ItemTags.LOGS_THAT_BURN).add(ModItems.PALM_LOG.get());
        tag(net.minecraft.tags.ItemTags.PLANKS).add(ModItems.PALM_PLANKS.get());

        // Piglin Repellents
        tag(net.minecraft.tags.ItemTags.PIGLIN_REPELLENTS).add(ModItems.SOUL_FANOUS.get());

        // Saplings
        tag(net.minecraft.tags.ItemTags.SAPLINGS).add(ModItems.PALM_SAPLING.get());

        // Signs
        tag(net.minecraft.tags.ItemTags.SIGNS).add(ModItems.PALM_SIGN.get());

        // Small Flowers (wild crops)
        tag(net.minecraft.tags.ItemTags.SMALL_FLOWERS).add(ModItems.WILD_CHICKPEA.get(), ModItems.WILD_PARSLEY.get());

        // Villager Plantable Seeds
        tag(net.minecraft.tags.ItemTags.VILLAGER_PLANTABLE_SEEDS)
                .add(ModItems.CHICKPEA.get(), ModItems.PARSLEY_SEEDS.get());

        // Wooden components
        tag(net.minecraft.tags.ItemTags.WOODEN_BUTTONS).add(ModItems.PALM_BUTTON.get());
        tag(net.minecraft.tags.ItemTags.WOODEN_DOORS).add(ModItems.PALM_DOOR.get());
        tag(net.minecraft.tags.ItemTags.WOODEN_FENCES).add(ModItems.PALM_FENCE.get());
        tag(net.minecraft.tags.ItemTags.WOODEN_PRESSURE_PLATES).add(ModItems.PALM_PRESSURE_PLATE.get());
        tag(net.minecraft.tags.ItemTags.WOODEN_STAIRS).add(ModItems.PALM_STAIRS.get());
        tag(net.minecraft.tags.ItemTags.WOODEN_SLABS).add(ModItems.PALM_SLAB.get());
        tag(net.minecraft.tags.ItemTags.WOODEN_TRAPDOORS).add(ModItems.PALM_TRAPDOOR.get());
    }
    protected void registerFarmersDelightTags() {
        // Food
        tag(ModTags.DRINKS).add(ModItems.DATE_SYRUP.get());
        tag(ModTags.MEALS).add(
                ModItems.LUQAIMAT.get(),
                ModItems.HUMMUS_TAHINI.get(),
                ModItems.SAVORY_FILLING.get(),
                ModItems.SWEET_TAGINE.get(),
                ModItems.TABBOULEH.get(),
                ModItems.HARIRA.get(),
                ModItems.CHORBA.get(),
                ModItems.HALEEM.get(),
                ModItems.CHICKPEA_AND_RICE.get(),
                ModItems.SAYADIEH.get(),
                ModItems.TAGINE.get(),
                ModItems.MAQLUBA.get()
        );

        // Feasts
        tag(ModTags.FEASTS).add(
                ModItems.BOUREK_BLOCK.get(),
                ModItems.KNAFEH_TRAY_BLOCK.get(),
                ModItems.MAQLUBA_BLOCK.get()
        );

        // Wild Crops
        tag(ModTags.WILD_CROPS_ITEM).add(ModItems.WILD_CHICKPEA.get(), ModItems.WILD_PARSLEY.get());
    }
    protected void registerRamadanDelightTags() {
        tag(RDCommonTags.FANOUS_ITEM).add(
                ModItems.FANOUS.get(),
                ModItems.COPPER_FANOUS.get(),
                ModItems.REDSTONE_FANOUS.get(),
                ModItems.SOUL_FANOUS.get()
        );

        tag(RDCommonTags.STAINED_GLASS_BLOCKS_ITEM).add(
                ModItems.STAINED_GLASS_BLOCK.get(),
                ModItems.BLUE_STAINED_GLASS_BLOCK.get(),
                ModItems.GREEN_STAINED_GLASS_BLOCK.get(),
                ModItems.ORANGE_STAINED_GLASS_BLOCK.get()
        );

        tag(RDCommonTags.STAINED_GLASS_PANES_ITEM).add(
                ModItems.STAINED_GLASS_PANE.get(),
                ModItems.BLUE_STAINED_GLASS_PANE.get(),
                ModItems.GREEN_STAINED_GLASS_PANE.get(),
                ModItems.ORANGE_STAINED_GLASS_PANE.get()
        );

        tag(RDCommonTags.PALM_LOGS_ITEM).add(
                ModItems.PALM_LOG.get(),
                ModItems.PALM_WOOD.get(),
                ModItems.STRIPPED_PALM_LOG.get(),
                ModItems.STRIPPED_PALM_WOOD.get()
        );
    }
}
