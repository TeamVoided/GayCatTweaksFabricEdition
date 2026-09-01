package org.teamvoided.gaycat.data.tags

import net.minecraft.core.registries.Registries
import org.teamvoided.gaycat.GayCatTweaks.id
import org.teamvoided.gaycat.util.tag

object GCBlockTags {

//    val APPLE_LIKE = create("apple_like")

    fun create(id: String) = Registries.BLOCK.tag(id(id))

}