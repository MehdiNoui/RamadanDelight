package net.mehdinoui.ramadandelight.common.entity.custom;

import net.mehdinoui.ramadandelight.common.registry.ModEntities;
import net.mehdinoui.ramadandelight.common.registry.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.entity.vehicle.ChestBoat;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class RDBoatChestEntity extends ChestBoat {
    // FIX: Use RDBoatChestEntity.class here
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE =
            SynchedEntityData.defineId(RDBoatChestEntity.class, EntityDataSerializers.INT);

    public RDBoatChestEntity(EntityType<? extends Boat> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public RDBoatChestEntity(Level level, double pX, double pY, double pZ) {
        this(ModEntities.MOD_CHEST_BOAT.get(), level);
        this.setPos(pX, pY, pZ);
        this.xo = pX;
        this.yo = pY;
        this.zo = pZ;
    }

    @Override
    public Item getDropItem() {
        return switch (getModVariant()) {
            case PALM -> ModItems.PALM_CHEST_BOAT.get();
        };
    }

    public void setVariant(RDBoatEntity.Type pVariant) {
        this.entityData.set(DATA_ID_TYPE, pVariant.ordinal());
    }

    public RDBoatEntity.Type getModVariant() {
        return RDBoatEntity.Type.byId(this.entityData.get(DATA_ID_TYPE));
    }

    // FIX: 1.21 Method Signature Change
    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {
        super.defineSynchedData(builder);
        builder.define(DATA_ID_TYPE, RDBoatEntity.Type.PALM.ordinal());
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag pCompound) {
        pCompound.putString("Type", this.getModVariant().getSerializedName());
        super.addAdditionalSaveData(pCompound); // Good practice to call super for Chest contents
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag pCompound) {
        if (pCompound.contains("Type", 8)) {
            this.setVariant(RDBoatEntity.Type.byName(pCompound.getString("Type")));
        }
        super.readAdditionalSaveData(pCompound); // Good practice to call super for Chest contents
    }
}