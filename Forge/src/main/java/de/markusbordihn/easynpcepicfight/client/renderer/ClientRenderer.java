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

package de.markusbordihn.easynpcepicfight.client.renderer;

import de.markusbordihn.easynpc.client.renderer.entity.SkeletonRenderer;
import de.markusbordihn.easynpc.client.renderer.entity.ZombieRenderer;
import de.markusbordihn.easynpcepicfight.Constants;
import de.markusbordihn.easynpcepicfight.entity.ModEntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class ClientRenderer {

  protected static final Logger log = LogManager.getLogger(Constants.LOG_NAME);

  protected ClientRenderer() {}

  public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
    log.info("{} Entity Renders ...", Constants.LOG_REGISTER_PREFIX);

    event.registerEntityRenderer(ModEntityType.HUSK.get(), ZombieRenderer::new);
    event.registerEntityRenderer(ModEntityType.SKELETON.get(), SkeletonRenderer::new);
    event.registerEntityRenderer(ModEntityType.WITHER_SKELETON.get(), SkeletonRenderer::new);
    event.registerEntityRenderer(ModEntityType.ZOMBIE.get(), ZombieRenderer::new);
  }
}
