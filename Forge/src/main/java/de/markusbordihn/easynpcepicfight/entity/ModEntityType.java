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
import de.markusbordihn.easynpcepicfight.Constants;
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
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.entity.monster.Illusioner;
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

  public static final RegistryObject<EntityType<IllagerEF>> EVOKER =
      ENTITY_TYPES.register(Illager.ID_EVOKER, () -> ModEntityTypes.EVOKER);
  public static final RegistryObject<EntityType<HumanoidEF>> HUMANOID =
      ENTITY_TYPES.register(Humanoid.ID, () -> ModEntityTypes.HUMANOID);
  public static final RegistryObject<EntityType<HumanoidSlimEF>> HUMANOID_SLIM =
      ENTITY_TYPES.register(HumanoidSlim.ID, () -> ModEntityTypes.HUMANOID_SLIM);
  public static final RegistryObject<EntityType<HuskEF>> HUSK =
      ENTITY_TYPES.register(Zombie.ID_HUSK, () -> ModEntityTypes.HUSK);
  public static final RegistryObject<EntityType<IllagerEF>> ILLUSIONER =
      ENTITY_TYPES.register(Illager.ID_ILLUSIONER, () -> ModEntityTypes.ILLUSIONER);
  public static final RegistryObject<EntityType<IronGolemEF>> IRON_GOLEM =
      ENTITY_TYPES.register(IronGolem.ID, () -> ModEntityTypes.IRON_GOLEM);
  public static final RegistryObject<EntityType<SkeletonEF>> SKELETON =
      ENTITY_TYPES.register(Skeleton.ID, () -> ModEntityTypes.SKELETON);
  public static final RegistryObject<EntityType<SkeletonEF>> STRAY =
      ENTITY_TYPES.register(Skeleton.ID_STRAY, () -> ModEntityTypes.STRAY);
  public static final RegistryObject<EntityType<IllagerEF>> PILLAGER =
      ENTITY_TYPES.register(Illager.ID_PILLAGER, () -> ModEntityTypes.PILLAGER);
  public static final RegistryObject<EntityType<IllagerEF>> VINDICATOR =
      ENTITY_TYPES.register(Illager.ID_VINDICATOR, () -> ModEntityTypes.VINDICATOR);
  public static final RegistryObject<EntityType<WitherSkeletonEF>> WITHER_SKELETON =
      ENTITY_TYPES.register(Skeleton.ID_WITHER_SKELETON, () -> ModEntityTypes.WITHER_SKELETON);
  public static final RegistryObject<EntityType<ZombieEF>> ZOMBIE =
      ENTITY_TYPES.register(Zombie.ID, () -> ModEntityTypes.ZOMBIE);
  public static final RegistryObject<EntityType<ZombieVillagerEF>> ZOMBIE_VILLAGER =
      ENTITY_TYPES.register(ZombieVillager.ID, () -> ModEntityTypes.ZOMBIE_VILLAGER);

  protected ModEntityType() {}

  @SubscribeEvent
  public static void entityAttributeCreation(EntityAttributeCreationEvent event) {
    event.put(EVOKER.get(), Evoker.createAttributes().build());
    event.put(HUMANOID.get(), Humanoid.createAttributes().build());
    event.put(HUMANOID_SLIM.get(), HumanoidSlim.createAttributes().build());
    event.put(HUSK.get(), Zombie.createAttributes().build());
    event.put(ILLUSIONER.get(), Illusioner.createAttributes().build());
    event.put(IRON_GOLEM.get(), IronGolem.createAttributes().build());
    event.put(SKELETON.get(), Skeleton.createAttributes().build());
    event.put(STRAY.get(), Skeleton.createAttributes().build());
    event.put(PILLAGER.get(), Illager.createAttributes().build());
    event.put(VINDICATOR.get(), Illager.createAttributes().build());
    event.put(WITHER_SKELETON.get(), Skeleton.createAttributes().build());
    event.put(ZOMBIE.get(), de.markusbordihn.easynpcepicfight.entity.npc.SuperModels.Zombie.createAttributes().build());
    event.put(ZOMBIE_VILLAGER.get(), ZombieVillager.createAttributes().build());
  }
}
