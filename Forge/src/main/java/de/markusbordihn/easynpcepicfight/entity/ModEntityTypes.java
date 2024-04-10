/*
 * Copyright 2023 Markus Bordihn
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.markusbordihn.easynpcepicfight.entity;

import de.markusbordihn.easynpc.entity.easynpc.npc.Humanoid;
import de.markusbordihn.easynpc.entity.easynpc.npc.HumanoidSlim;
import de.markusbordihn.easynpc.entity.easynpc.npc.Illager;
import de.markusbordihn.easynpc.entity.easynpc.npc.IronGolem;
import de.markusbordihn.easynpc.entity.easynpc.npc.Skeleton;
import de.markusbordihn.easynpc.entity.easynpc.npc.Zombie;
import de.markusbordihn.easynpc.entity.easynpc.npc.ZombieVillager;
import de.markusbordihn.easynpcepicfight.entity.npc.HumanoidEF;
import de.markusbordihn.easynpcepicfight.entity.npc.HumanoidSlimEF;
import de.markusbordihn.easynpcepicfight.entity.npc.HuskEF;
import de.markusbordihn.easynpcepicfight.entity.npc.IllagerEF;
import de.markusbordihn.easynpcepicfight.entity.npc.IronGolemEF;
import de.markusbordihn.easynpcepicfight.entity.npc.SkeletonEF;
import de.markusbordihn.easynpcepicfight.entity.npc.WitherSkeletonEF;
import de.markusbordihn.easynpcepicfight.entity.npc.ZombieEF;
import de.markusbordihn.easynpcepicfight.entity.npc.ZombieVillagerEF;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntityTypes {
  public static final int CLIENT_TRACKING_RANGE = 12;
  public static final float HUMANOID_SIZE_WIDTH = 0.6F;
  public static final float HUMANOID_SIZE_HEIGHT = 1.96F;
  public static final MobCategory CATEGORY = MobCategory.MISC;

  public static final EntityType<IllagerEF> EVOKER =
      EntityType.Builder.<IllagerEF>of(
              (entityType, level) ->
                  new IllagerEF(entityType, level, Illager.Variant.EVOKER_CROSSED_ARMS),
              CATEGORY)
          .sized(HUMANOID_SIZE_WIDTH, HUMANOID_SIZE_HEIGHT)
          .clientTrackingRange(CLIENT_TRACKING_RANGE)
          .build(Illager.ID_EVOKER);
  public static final EntityType<HumanoidEF> HUMANOID =
      EntityType.Builder.of(HumanoidEF::new, CATEGORY)
          .sized(HUMANOID_SIZE_WIDTH, HUMANOID_SIZE_HEIGHT)
          .clientTrackingRange(CLIENT_TRACKING_RANGE)
          .build(Humanoid.ID);
  public static final EntityType<HumanoidSlimEF> HUMANOID_SLIM =
      EntityType.Builder.of(HumanoidSlimEF::new, CATEGORY)
          .sized(HUMANOID_SIZE_WIDTH, HUMANOID_SIZE_HEIGHT)
          .clientTrackingRange(CLIENT_TRACKING_RANGE)
          .build(HumanoidSlim.ID);
  public static final EntityType<HuskEF> HUSK =
      EntityType.Builder.of(HuskEF::new, CATEGORY)
          .sized(HUMANOID_SIZE_WIDTH, HUMANOID_SIZE_HEIGHT)
          .clientTrackingRange(CLIENT_TRACKING_RANGE)
          .build(Zombie.ID_HUSK);
  public static final EntityType<IllagerEF> ILLUSIONER =
      EntityType.Builder.<IllagerEF>of(
              (entityType, level) ->
                  new IllagerEF(entityType, level, Illager.Variant.ILLUSIONER_CROSSED_ARMS),
              CATEGORY)
          .sized(HUMANOID_SIZE_WIDTH, HUMANOID_SIZE_HEIGHT)
          .clientTrackingRange(CLIENT_TRACKING_RANGE)
          .build(Illager.ID_ILLUSIONER);
  public static final EntityType<IronGolemEF> IRON_GOLEM =
      EntityType.Builder.<IronGolemEF>of(IronGolemEF::new, CATEGORY)
          .sized(1.4F, 2.7F)
          .clientTrackingRange(CLIENT_TRACKING_RANGE)
          .build(IronGolem.ID);
  public static final EntityType<SkeletonEF> SKELETON =
      EntityType.Builder.<SkeletonEF>of(SkeletonEF::new, CATEGORY)
          .sized(HUMANOID_SIZE_WIDTH, HUMANOID_SIZE_HEIGHT)
          .clientTrackingRange(CLIENT_TRACKING_RANGE)
          .build(Skeleton.ID);
  public static final EntityType<SkeletonEF> STRAY =
      EntityType.Builder.<SkeletonEF>of(
              (entityType, level) -> new SkeletonEF(entityType, level, Skeleton.Variant.STRAY),
              CATEGORY)
          .sized(HUMANOID_SIZE_WIDTH, HUMANOID_SIZE_HEIGHT)
          .clientTrackingRange(CLIENT_TRACKING_RANGE)
          .build(Skeleton.ID_STRAY);
  public static final EntityType<IllagerEF> PILLAGER =
      EntityType.Builder.<IllagerEF>of(
              (entityType, level) -> new IllagerEF(entityType, level, Illager.Variant.PILLAGER),
              CATEGORY)
          .sized(HUMANOID_SIZE_WIDTH, HUMANOID_SIZE_HEIGHT)
          .clientTrackingRange(CLIENT_TRACKING_RANGE)
          .build(Illager.ID_PILLAGER);
  public static final EntityType<IllagerEF> VINDICATOR =
      EntityType.Builder.<IllagerEF>of(
              (entityType, level) ->
                  new IllagerEF(entityType, level, Illager.Variant.VINDICATOR_CROSSED_ARMS),
              CATEGORY)
          .sized(HUMANOID_SIZE_WIDTH, HUMANOID_SIZE_HEIGHT)
          .clientTrackingRange(CLIENT_TRACKING_RANGE)
          .build(Illager.ID_VINDICATOR);
  public static final EntityType<WitherSkeletonEF> WITHER_SKELETON =
      EntityType.Builder.of(WitherSkeletonEF::new, CATEGORY)
          .sized(HUMANOID_SIZE_WIDTH, HUMANOID_SIZE_HEIGHT)
          .clientTrackingRange(CLIENT_TRACKING_RANGE)
          .build(Skeleton.ID_WITHER_SKELETON);
  public static final EntityType<ZombieEF> ZOMBIE =
      EntityType.Builder.<ZombieEF>of(ZombieEF::new, CATEGORY)
          .sized(HUMANOID_SIZE_WIDTH, HUMANOID_SIZE_HEIGHT)
          .clientTrackingRange(CLIENT_TRACKING_RANGE)
          .build(Zombie.ID);
  public static final EntityType<ZombieVillagerEF> ZOMBIE_VILLAGER =
      EntityType.Builder.of(ZombieVillagerEF::new, CATEGORY)
          .sized(HUMANOID_SIZE_WIDTH, HUMANOID_SIZE_HEIGHT)
          .clientTrackingRange(CLIENT_TRACKING_RANGE)
          .build(ZombieVillager.ID);

  private ModEntityTypes() {}
}
