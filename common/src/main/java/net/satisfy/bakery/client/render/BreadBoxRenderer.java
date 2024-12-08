package net.satisfy.bakery.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.satisfy.bakery.block.entity.StorageBlockEntity;
import net.satisfy.bakery.client.ClientUtil;
import net.satisfy.bakery.registry.ObjectRegistry;

@Environment(EnvType.CLIENT)
public class BreadBoxRenderer implements StorageTypeRenderer {
    @Override
    public void render(StorageBlockEntity entity, PoseStack matrices, MultiBufferSource vertexConsumers, NonNullList<ItemStack> itemStacks) {
        matrices.translate(-0.25, 0.3, 0);
        matrices.scale(0.5f, 0.5f, 0.5f);
        for (int i = 0; i < itemStacks.size(); i++) {
            ItemStack stack = itemStacks.get(i);
            if (!stack.isEmpty()) {
                matrices.pushPose();
                if (stack.getItem() instanceof BlockItem blockItem) {
                    if (blockItem.getBlock() == ObjectRegistry.CRUSTY_BREAD_BLOCK.get()) {
                        matrices.translate(-0.5f, -0.5f, -0.9f);
                        matrices.scale(2f, 2f, 2f);
                        ClientUtil.renderBlockFromItem(blockItem, matrices, vertexConsumers, entity);
                    } else if (blockItem.getBlock() == ObjectRegistry.BUN_BLOCK.get()) {
                        matrices.translate(-0.5f, -0.5f, -0.9f);
                        matrices.scale(2f, 2f, 2f);
                        ClientUtil.renderBlockFromItem(blockItem, matrices, vertexConsumers, entity);
                    } else if (blockItem.getBlock() == ObjectRegistry.BREAD_BLOCK.get()) {
                        matrices.translate(-0.5f, -0.5f, 0.93f);
                        matrices.scale(2f, 2f, 2f);
                        matrices.mulPose(Axis.YP.rotationDegrees(90.0f));
                        ClientUtil.renderBlockFromItem(blockItem, matrices, vertexConsumers, entity);
                    } else if (blockItem.getBlock() == ObjectRegistry.BRAIDED_BREAD_BLOCK.get()) {
                        matrices.translate(-0.5f, -0.5f, 0.93f);
                        matrices.scale(2f, 2f, 2f);
                        matrices.mulPose(Axis.YP.rotationDegrees(90.0f));
                        ClientUtil.renderBlockFromItem(blockItem, matrices, vertexConsumers, entity);
                    } else if (blockItem.getBlock() == ObjectRegistry.TOAST_BLOCK.get()) {
                        matrices.translate(-0.5f, -0.5f, 0.93f);
                        matrices.scale(2f, 2f, 2f);
                        matrices.mulPose(Axis.YP.rotationDegrees(90.0f));
                        ClientUtil.renderBlockFromItem(blockItem, matrices, vertexConsumers, entity);
                    } else if (blockItem.getBlock() == ObjectRegistry.BAGUETTE_BLOCK.get()) {
                        matrices.translate(-0.28f, -0.48f, 0.6f);
                        matrices.scale(1.5f, 1.5f, 1.5f);
                        matrices.mulPose(Axis.YP.rotationDegrees(90.0f));
                        ClientUtil.renderBlockFromItem(blockItem, matrices, vertexConsumers, entity);
                    } else {
                        matrices.translate(0.2, -0.5f, -0.3f);
                        matrices.scale(0.6f, 0.6f, 0.6f);
                        ClientUtil.renderBlockFromItem(blockItem, matrices, vertexConsumers, entity);
                    }
                } else {
                    matrices.translate(0.3f * i, 0, 0);
                    matrices.mulPose(Axis.YN.rotationDegrees(45.0f));
                    ClientUtil.renderItem(stack, matrices, vertexConsumers, entity);
                }

                matrices.popPose();
            }
        }
    }
}