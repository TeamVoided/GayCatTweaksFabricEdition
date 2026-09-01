package org.teamvoided.gaycat.mixin;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.gaycat.GayCatTweaks.config;

@Mixin(RecipeManager.class)
public abstract class RecipeManagerMixin {

    @WrapWithCondition(
            method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V",
            at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMap$Builder;put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;")
    )
    <K, V> boolean preventRecipeLoading(ImmutableMap.Builder instance, K key, V value, @Local ResourceLocation id) {
        return !config.recipesToRemove.contains(id);
    }

    @WrapWithCondition(
            method = "apply(Ljava/util/Map;Lnet/minecraft/server/packs/resources/ResourceManager;Lnet/minecraft/util/profiling/ProfilerFiller;)V",
            at = @At(value = "INVOKE", target = "Lcom/google/common/collect/ImmutableMultimap$Builder;put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMultimap$Builder;")
    )
    <K, V> boolean preventRecipeLoading2(ImmutableMultimap.Builder instance, K key, V value, @Local ResourceLocation id) {
        return !config.recipesToRemove.contains(id);
    }

}
