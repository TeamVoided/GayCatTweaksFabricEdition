package org.teamvoided.gaycat.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.gaycat.GayCatTweaks.config;


@Mixin(Block.class)
public abstract class BlockMixin {

    @SuppressWarnings("DeprecatedIsStillUsed")
    @Shadow
    @Deprecated
    public abstract Holder.Reference<Block> builtInRegistryHolder();

    @ModifyReturnValue(method = "getExplosionResistance", at = @At("RETURN"))
    float modifyExplosionResistance(float original) {
        return config.getCustomExplosionResistance(builtInRegistryHolder(), original);
    }

}