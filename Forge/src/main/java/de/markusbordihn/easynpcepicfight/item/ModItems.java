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

package de.markusbordihn.easynpcepicfight.item;

import de.markusbordihn.easynpc.entity.npc.Zombie;
import de.markusbordihn.easynpcepicfight.Constants;
import de.markusbordihn.easynpcepicfight.entity.ModEntityType;
import de.markusbordihn.easynpcepicfight.entity.npc.HuskEpicFight;
import de.markusbordihn.easynpcepicfight.entity.npc.SkeletonEpicFight;
import de.markusbordihn.easynpcepicfight.entity.npc.WitherSkeletonEpicFight;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
  public static final DeferredRegister<Item> ITEMS =
      DeferredRegister.create(ForgeRegistries.ITEMS, Constants.MOD_ID);

  private static final String SPAWN_EGG_PREFIX = "_spawn_egg";

  public static final RegistryObject<Item> HUSK_NPC_SPAWN_EGG =
      ITEMS.register(
          HuskEpicFight.ID + SPAWN_EGG_PREFIX,
          () ->
              new EasyNPCEpicFightSpawnEggItem(
                  ModEntityType.HUSK, new Item.Properties().rarity(Rarity.EPIC)));

  public static final RegistryObject<Item> SKELETON_NPC_SPAWN_EGG =
      ITEMS.register(
          SkeletonEpicFight.ID + SPAWN_EGG_PREFIX,
          () ->
              new EasyNPCEpicFightSpawnEggItem(
                  ModEntityType.SKELETON, new Item.Properties().rarity(Rarity.EPIC)));

  public static final RegistryObject<Item> WITHER_SKELETON_NPC_SPAWN_EGG =
      ITEMS.register(
          WitherSkeletonEpicFight.ID + SPAWN_EGG_PREFIX,
          () ->
              new EasyNPCEpicFightSpawnEggItem(
                  ModEntityType.WITHER_SKELETON, new Item.Properties().rarity(Rarity.EPIC)));
  public static final RegistryObject<Item> ZOMBIE_NPC_SPAWN_EGG =
      ITEMS.register(
          Zombie.ID + SPAWN_EGG_PREFIX,
          () ->
              new EasyNPCEpicFightSpawnEggItem(
                  ModEntityType.ZOMBIE, new Item.Properties().rarity(Rarity.EPIC)));

  protected ModItems() {}
}
