package org.teamvoided.gaycat.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;

import static org.teamvoided.gaycat.GayCatTweaks.config;


@Mixin(BlockBehaviour.BlockStateBase.class)
public abstract class BlockStateBaseMixin {

    @Shadow
    public abstract Block getBlock();

    @SuppressWarnings("deprecation")
    @ModifyReturnValue(method = "getDestroySpeed", at = @At("RETURN"))
    float modifyDestroyTime(float original) {
        return config.getCustomBreakSpeed(getBlock().builtInRegistryHolder(), original);
    }

}