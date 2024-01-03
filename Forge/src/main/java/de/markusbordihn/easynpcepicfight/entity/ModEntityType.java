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

import de.markusbordihn.easynpc.entity.EasyNPCEntity;
import de.markusbordihn.easynpc.entity.npc.Zombie;
import de.markusbordihn.easynpcepicfight.Constants;
import de.markusbordihn.easynpcepicfight.entity.npc.HuskEpicFight;
import de.markusbordihn.easynpcepicfight.entity.npc.SkeletonEpicFight;
import de.markusbordihn.easynpcepicfight.entity.npc.WitherSkeletonEpicFight;
import de.markusbordihn.easynpcepicfight.entity.npc.ZombieEpicFight;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityType {
  public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
      DeferredRegister.create(ForgeRegistries.ENTITIES, Constants.MOD_ID);

  public static final RegistryObject<EntityType<HuskEpicFight>> HUSK =
      ENTITY_TYPES.register(
          HuskEpicFight.ID,
          () ->
              EntityType.Builder.of(HuskEpicFight::new, EasyNPCEntity.CATEGORY)
                  .sized(0.6F, 1.95F)
                  .clientTrackingRange(12)
                  .build(HuskEpicFight.ID));

  public static final RegistryObject<EntityType<SkeletonEpicFight>> SKELETON =
      ENTITY_TYPES.register(
          SkeletonEpicFight.ID,
          () ->
              EntityType.Builder.of(SkeletonEpicFight::new, EasyNPCEntity.CATEGORY)
                  .sized(0.6F, 1.99F)
                  .clientTrackingRange(12)
                  .build(SkeletonEpicFight.ID));

  public static final RegistryObject<EntityType<WitherSkeletonEpicFight>> WITHER_SKELETON =
      ENTITY_TYPES.register(
          WitherSkeletonEpicFight.ID,
          () ->
              EntityType.Builder.of(WitherSkeletonEpicFight::new, EasyNPCEntity.CATEGORY)
                  .sized(0.7F, 2.4F)
                  .clientTrackingRange(12)
                  .build(WitherSkeletonEpicFight.ID));
  public static final RegistryObject<EntityType<ZombieEpicFight>> ZOMBIE =
      ENTITY_TYPES.register(
          ZombieEpicFight.ID,
          () ->
              EntityType.Builder.of(ZombieEpicFight::new, EasyNPCEntity.CATEGORY)
                  .sized(0.6F, 1.96F)
                  .clientTrackingRange(12)
                  .build(ZombieEpicFight.ID));

  protected ModEntityType() {}

  @SubscribeEvent
  public static void entityAttributeCreation(EntityAttributeCreationEvent event) {
    event.put(HUSK.get(), Zombie.createAttributes().build());
    event.put(SKELETON.get(), Zombie.createAttributes().build());
    event.put(WITHER_SKELETON.get(), Zombie.createAttributes().build());
    event.put(ZOMBIE.get(), Zombie.createAttributes().build());
  }
}
