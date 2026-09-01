package org.teamvoided.gaycat

import me.fzzyhmstrs.fzzy_config.api.ConfigApi
import net.minecraft.resources.ResourceLocation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.teamvoided.gaycat.config.GayCatConfig

object GayCatTweaks {

    const val MODID = "gaycat_tweaks"

    @JvmField
    val log: Logger = LoggerFactory.getLogger(GayCatTweaks::class.simpleName)

    @JvmField
    var config = ConfigApi.registerAndLoadConfig(::GayCatConfig)

    fun init() {
    }

    fun id(namespace: String, path: String): ResourceLocation = ResourceLocation.fromNamespaceAndPath(namespace, path)
    fun mc(path: String): ResourceLocation = ResourceLocation.withDefaultNamespace(path)
    fun id(path: String) = id(MODID, path)

}