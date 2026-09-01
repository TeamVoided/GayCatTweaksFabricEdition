package org.teamvoided.gaycat.config

import me.fzzyhmstrs.fzzy_config.annotations.Action
import me.fzzyhmstrs.fzzy_config.annotations.RequiresAction
import me.fzzyhmstrs.fzzy_config.config.Config
import me.fzzyhmstrs.fzzy_config.util.AllowableIdentifiers
import me.fzzyhmstrs.fzzy_config.validation.collection.ValidatedMap
import me.fzzyhmstrs.fzzy_config.validation.minecraft.ValidatedIdentifier
import me.fzzyhmstrs.fzzy_config.validation.number.ValidatedFloat
import net.minecraft.core.Holder
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import org.teamvoided.gaycat.GayCatTweaks.MODID
import org.teamvoided.gaycat.GayCatTweaks.id
import org.teamvoided.gaycat.util.identifier
import kotlin.jvm.optionals.getOrNull

@Suppress("unused")
class GayCatConfig : Config(id(MODID)) {

    @JvmField
    var customBreakSpeed = ValidatedMap.Builder<ResourceLocation, Float>()
        .keyHandler(registryBackedId(BuiltInRegistries.BLOCK))
        .valueHandler(ValidatedFloat(-1f, Float.MAX_VALUE, -1f))
        .defaults(
            listOf(
                Blocks.SPAWNER to -1f,
                Blocks.TRIAL_SPAWNER to -1f,
                Blocks.VAULT to -1f,
            ).toBlockSet()
        )
        .build()

    @JvmField
    var customExplosionResistance = ValidatedMap.Builder<ResourceLocation, Float>()
        .keyHandler(registryBackedId(BuiltInRegistries.BLOCK))
        .valueHandler(ValidatedFloat(12000f, Float.MAX_VALUE, 0f))
        .defaults(
            listOf(
                Blocks.SPAWNER to 12000f,
                Blocks.TRIAL_SPAWNER to 12000f,
                Blocks.VAULT to 12000f,
            ).toBlockSet()
        )
        .build()


    fun getCustomBreakSpeed(holder: Holder.Reference<Block>, original: Float): Float {
        return holder.identifier()?.let(customBreakSpeed::get) ?: original
    }

    fun getCustomExplosionResistance(holder: Holder.Reference<Block>, original: Float): Float {
        return holder.identifier()?.let(customExplosionResistance::get) ?: original
    }

    @JvmField
    @RequiresAction(Action.RELOAD_DATA)
    var recipesToRemove = ValidatedIdentifier(id("minecraft", "oak_button")).toSet()

    var packDevUtils = false

    companion object {

        fun <T : Any> registryBackedId(registry: Registry<T>): ValidatedIdentifier {
            return ValidatedIdentifier(
                id("c", "c"),
                AllowableIdentifiers({ _ -> true }, { registry.keySet().toList() }, true)
            )
        }

        fun List<Pair<Block, Float>>.toBlockSet(): Map<ResourceLocation, Float> {
            return associate { BuiltInRegistries.BLOCK.getKey(it.first) to it.second }
        }

    }
}