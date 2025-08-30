package net.mehdinoui.ramadandelight.common.registry;

import net.mehdinoui.ramadandelight.RamadanDelight;
import net.mehdinoui.ramadandelight.common.block.entity.RDSignBlockEntity;
import net.mehdinoui.ramadandelight.common.block.entity.RDHangingSignBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, RamadanDelight.MOD_ID);

    public static void register(IEventBus eventBus){
        BLOCK_ENTITES.register(eventBus);
    }

    public static final RegistryObject<BlockEntityType<RDSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITES.register("mod_sign", ()->
                    BlockEntityType.Builder.of(RDSignBlockEntity::new,
                            ModBlocks.PALM_SIGN.get(), ModBlocks.PALM_WALL_SIGN.get()).build(null));


    public static final RegistryObject<BlockEntityType<RDHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITES.register("mod_hanging_sign", ()->
                    BlockEntityType.Builder.of(RDHangingSignBlockEntity::new,
                            ModBlocks.PALM_HANGING_SIGN.get(), ModBlocks.PALM_WALL_HANGING_SIGN.get()).build(null));


}
