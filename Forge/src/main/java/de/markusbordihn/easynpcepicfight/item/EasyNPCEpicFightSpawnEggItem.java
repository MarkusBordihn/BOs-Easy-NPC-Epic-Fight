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

import de.markusbordihn.easynpc.item.EasyNPCSpawnEggItem;
import de.markusbordihn.easynpcepicfight.Constants;
import java.util.List;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

public class EasyNPCEpicFightSpawnEggItem extends EasyNPCSpawnEggItem {

  public EasyNPCEpicFightSpawnEggItem(
      Supplier<? extends EntityType<? extends Mob>> type, Item.Properties props) {
    super(type, props);
  }

  @Override
  public void appendHoverText(
      ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag flag) {
    super.appendHoverText(itemStack, level, list, flag);
    list.add(new TranslatableComponent(Constants.TEXT_ITEM_PREFIX + "spawn_egg.tooltip"));
    list.add(
        new TranslatableComponent(Constants.TEXT_ITEM_PREFIX + "spawn_egg.tooltip_note")
            .withStyle(ChatFormatting.RED));
  }
}
