package org.teamvoided.gaycat.data.tags

import net.minecraft.core.registries.Registries
import org.teamvoided.gaycat.GayCatTweaks.id
import org.teamvoided.gaycat.util.tag

object GCItemTags {

//    val APPLE_LIKE = create("apple_like")

    fun create(id: String) = Registries.ITEM.tag(id(id))

}