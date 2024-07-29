package de.markusbordihn.easynpcepicfight.entity.npc.SuperModels;

import de.markusbordihn.easynpc.data.skin.SkinModel;
import de.markusbordihn.easynpc.data.sound.SoundDataSet;
import de.markusbordihn.easynpc.data.sound.SoundType;
import de.markusbordihn.easynpc.entity.easynpc.npc.Humanoid;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;

public class Zombie extends Humanoid  {
    public static final String ID = "zombie";
    public static final String ID_DROWNED = "drowned";
    public static final String ID_HUSK = "husk";

    public Zombie(EntityType<? extends PathfinderMob> entityType, Level level, Enum<?> variant) {
        super(entityType, level, variant);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes().add(Attributes.MAX_HEALTH, 20.0).add(Attributes.FOLLOW_RANGE, 32.0).add(Attributes.KNOCKBACK_RESISTANCE, 0.0).add(Attributes.MOVEMENT_SPEED, 0.5).add(Attributes.ATTACK_DAMAGE, 1.0).add(Attributes.ATTACK_KNOCKBACK, 0.0).add(Attributes.ATTACK_SPEED, 0.0).add(Attributes.ARMOR, 0.0).add(Attributes.ARMOR_TOUGHNESS, 0.0);
    }

    public SkinModel getSkinModel() {
        return SkinModel.HUMANOID;
    }

    public Enum<?>[] getVariants() {
        return Variant.values();
    }

    public Enum<?> getDefaultVariant() {
        return Variant.ZOMBIE;
    }

    public Enum<?> getVariant(String name) {
        return Variant.valueOf(name);
    }
    public SoundDataSet getDefaultSoundDataSet(SoundDataSet soundDataSet, String variantName) {
        Variant soundVariant = Variant.valueOf(variantName);
        switch (soundVariant) {
            case DROWNED:
                soundDataSet.addSound(SoundType.AMBIENT, SoundEvents.DROWNED_AMBIENT);
                soundDataSet.addSound(SoundType.HURT, SoundEvents.DROWNED_HURT);
                soundDataSet.addSound(SoundType.DEATH, SoundEvents.DROWNED_DEATH);
                soundDataSet.addSound(SoundType.STEP, SoundEvents.DROWNED_STEP);
                break;
            case HUSK:
                soundDataSet.addSound(SoundType.AMBIENT, SoundEvents.HUSK_AMBIENT);
                soundDataSet.addSound(SoundType.HURT, SoundEvents.HUSK_HURT);
                soundDataSet.addSound(SoundType.DEATH, SoundEvents.HUSK_DEATH);
                soundDataSet.addSound(SoundType.STEP, SoundEvents.HUSK_STEP);
                break;
            case ZOMBIE:
                soundDataSet.addSound(SoundType.AMBIENT, SoundEvents.ZOMBIE_AMBIENT);
                soundDataSet.addSound(SoundType.HURT, SoundEvents.ZOMBIE_HURT);
                soundDataSet.addSound(SoundType.DEATH, SoundEvents.ZOMBIE_DEATH);
                soundDataSet.addSound(SoundType.STEP, SoundEvents.ZOMBIE_STEP);
                break;
            default:
                super.getDefaultSoundDataSet(soundDataSet, variantName);
                break;
        }
        return soundDataSet;
    }

    public static enum Variant {
        DROWNED,
        HUSK,
        ZOMBIE;
    }
}
