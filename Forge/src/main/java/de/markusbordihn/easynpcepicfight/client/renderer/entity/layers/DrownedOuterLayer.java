package de.markusbordihn.easynpcepicfight.client.renderer.entity.layers;

import com.mojang.blaze3d.platform.NativeImage;
import de.markusbordihn.easynpcepicfight.Constants;
import de.markusbordihn.easynpcepicfight.EasyNPCEpicFight;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@OnlyIn(Dist.CLIENT)
public class DrownedOuterLayer {
    private ResourceLocation TEXTURE_BY_VARIANT;
    private ResourceLocation OUTER_TEXTURE_BY_VARIANT;
    private ResourceLocation OUT_TEXTURE;


    public DrownedOuterLayer(ResourceLocation TEXTURE_BY_VARIANT, ResourceLocation OUTER_TEXTURE_BY_VARIANT) {
        this.TEXTURE_BY_VARIANT = TEXTURE_BY_VARIANT;
        this.OUTER_TEXTURE_BY_VARIANT = OUTER_TEXTURE_BY_VARIANT;
        try {
            this.OUT_TEXTURE = textureCombination();
        } catch (IOException e) {
            e.printStackTrace();
            EasyNPCEpicFight.log.error("Error while creating combined texture for drowned outer layer.");
        }
    }

    public ResourceLocation getTexture() {
        return OUT_TEXTURE;
    }

    private ResourceLocation textureCombination() throws IOException {
        BufferedImage innerImage = loadImage(TEXTURE_BY_VARIANT);
        BufferedImage outerImage = loadImage(OUTER_TEXTURE_BY_VARIANT);
        if (null != innerImage && null != outerImage) {
            BufferedImage combinedImage = combineImages(innerImage, outerImage);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(combinedImage, "png", baos);
            byte[] imageBytes = baos.toByteArray();
            String base64String = Base64.getEncoder().encodeToString(imageBytes);
            return registerBufferedImageAsTexture(base64String, Constants.MOD_ID);
        }
        return null;
    }

    private ResourceLocation registerBufferedImageAsTexture(String image, String name) throws IOException {
        DynamicTexture dynamicTexture = new DynamicTexture(NativeImage.fromBase64(image));
        ResourceLocation resourceLocation = new ResourceLocation(name);
        Minecraft.getInstance().getTextureManager().register(resourceLocation, dynamicTexture);
        return resourceLocation;
    }

    private BufferedImage loadImage(ResourceLocation textureByVariant) throws IOException {
        return ImageIO.read(Minecraft.getInstance().getResourceManager().getResource(textureByVariant).getInputStream());
    }

    private BufferedImage combineImages(BufferedImage TEXTURE_BY_VARIANT, BufferedImage OUTER_TEXTURE_BY_VARIANT) {
        // Get the maximum width and height of the two images
        int width = Math.max(TEXTURE_BY_VARIANT.getWidth(), OUTER_TEXTURE_BY_VARIANT.getWidth());
        int height = Math.max(TEXTURE_BY_VARIANT.getHeight(), OUTER_TEXTURE_BY_VARIANT.getHeight());
        // Create a new image with the maximum width and height
        BufferedImage combinedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        // Draw the images onto the combined image
        combinedImage.getGraphics().drawImage(TEXTURE_BY_VARIANT, 0, 0, null);
        // Shift the X-axis by half to make it a double layered skin
        combinedImage.getGraphics().drawImage(OUTER_TEXTURE_BY_VARIANT, width / 2, 0, null);
        combinedImage.getGraphics().drawImage(OUTER_TEXTURE_BY_VARIANT, 0, 0, null);
        // Return the combined image
        return combinedImage;
    }
}
