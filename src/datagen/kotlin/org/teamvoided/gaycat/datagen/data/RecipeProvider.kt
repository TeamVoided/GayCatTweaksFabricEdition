package org.teamvoided.gaycat.datagen.data

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.recipes.RecipeOutput
import java.util.concurrent.CompletableFuture

class RecipeProvider(o: FabricDataOutput, p: CompletableFuture<HolderLookup.Provider>) : FabricRecipeProvider(o, p) {

    override fun buildRecipes(e: RecipeOutput) {
//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.APPLE_2)
//            .requires(Items.APPLE)
//            .requires(Items.APPLE)
//            .unlockedBy("has_apple", has(Items.APPLE))
//            .unlockedBy("has_apple_2", has(Items.APPLE_2))
//            .save(e)
    }

}