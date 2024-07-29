package de.markusbordihn.easynpcepicfight.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import de.markusbordihn.easynpc.client.model.standard.StandardPlayerModel;
import de.markusbordihn.easynpc.client.renderer.EasyNPCModelRenderer;
import de.markusbordihn.easynpc.client.renderer.entity.base.BaseLivingEntityModelRenderer;
import de.markusbordihn.easynpc.entity.easynpc.npc.Humanoid;
import de.markusbordihn.easynpcepicfight.client.renderer.entity.layers.DrownedOuterLayer;
import de.markusbordihn.easynpcepicfight.entity.npc.SuperModels.Zombie;
import net.minecraft.Util;
import net.minecraft.client.model.DrownedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ElytraLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Pose;

import java.util.HashMap;
import java.util.Map;

public class HumanoidModelRenderer extends BaseLivingEntityModelRenderer<Humanoid, Humanoid.Variant, StandardPlayerModel<Humanoid>> {
    protected static final Map TEXTURE_BY_VARIANT = Util.make(new HashMap(), (map) -> {
        map.put(Humanoid.Variant.STEVE, new ResourceLocation("textures/entity/steve.png"));
        map.put(Humanoid.Variant.JAYJASONBO, new ResourceLocation("easy_npc", "textures/entity/humanoid/jayjasonbo.png"));
        map.put(Humanoid.Variant.PROFESSOR_01, new ResourceLocation("easy_npc", "textures/entity/humanoid/professor_01.png"));
        map.put(Humanoid.Variant.SECURITY_01, new ResourceLocation("easy_npc", "textures/entity/humanoid/security_01.png"));
        map.put(Humanoid.Variant.KNIGHT_01, new ResourceLocation("easy_npc", "textures/entity/humanoid/knight_01.png"));
        map.put(Zombie.Variant.DROWNED, new DrownedOuterLayer(new ResourceLocation("textures/entity/zombie/drowned.png"), new ResourceLocation("textures/entity/zombie/drowned_outer_layer.png")).getTexture());
        map.put(Zombie.Variant.HUSK, new ResourceLocation("textures/entity/zombie/husk.png"));
        map.put(Zombie.Variant.ZOMBIE, new ResourceLocation("textures/entity/zombie/zombie.png"));
    });
    protected static final ResourceLocation DEFAULT_TEXTURE;

    public <L extends RenderLayer<Humanoid, StandardPlayerModel<Humanoid>>> HumanoidModelRenderer(EntityRendererProvider.Context context, Class<L> humanoidArmorLayerClass) {
        super(context, new StandardPlayerModel<>(context.bakeLayer(ModelLayers.PLAYER), false), 0.5F, DEFAULT_TEXTURE, TEXTURE_BY_VARIANT);
        this.addLayer(EasyNPCModelRenderer.getHumanoidArmorLayer(this, context, ModelLayers.PLAYER_INNER_ARMOR, ModelLayers.PLAYER_OUTER_ARMOR, humanoidArmorLayerClass));
        this.addLayer(new CustomHeadLayer(this, context.getModelSet()));
        this.addLayer(new ItemInHandLayer(this));
        this.addLayer(new ElytraLayer(this, context.getModelSet()));
    }

    public ResourceLocation getTextureLocation(Humanoid entity) {
        return this.getEntityPlayerTexture(entity);
    }

    public void renderDefaultPose(Humanoid entity, StandardPlayerModel<Humanoid> model, Pose pose, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int light) {
        switch (pose) {
            case DYING:
                poseStack.translate(-1.0, 0.0, 0.0);
                poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F));
                poseStack.mulPose(Vector3f.ZP.rotationDegrees(this.getFlipDegrees(entity)));
                poseStack.mulPose(Vector3f.YP.rotationDegrees(270.0F));
                model.getHead().xRot = -0.7853982F;
                model.getHead().yRot = -0.7853982F;
                model.getHead().zRot = -0.7853982F;
                break;
            case LONG_JUMPING:
                model.leftArmPose = HumanoidModel.ArmPose.CROSSBOW_HOLD;
                model.rightArmPose = HumanoidModel.ArmPose.SPYGLASS;
                break;
            case SLEEPING:
                poseStack.translate(1.0, 0.0, 0.0);
                break;
            case SPIN_ATTACK:
                model.leftArmPose = HumanoidModel.ArmPose.BLOCK;
                model.rightArmPose = HumanoidModel.ArmPose.THROW_SPEAR;
                poseStack.mulPose(Vector3f.YP.rotationDegrees(-35.0F));
                break;
            default:
                model.leftArmPose = HumanoidModel.ArmPose.EMPTY;
                model.rightArmPose = HumanoidModel.ArmPose.EMPTY;
                model.getHead().xRot = 0.0F;
                model.getHead().yRot = 0.0F;
                model.getHead().zRot = 0.0F;
        }

    }

    static {
        DEFAULT_TEXTURE = (ResourceLocation) TEXTURE_BY_VARIANT.get(Humanoid.Variant.STEVE);
    }
}
