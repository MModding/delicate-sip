package com.mmodding.ds.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.mmodding.ds.block.entity.RockFoundryBlockEntity;
import com.mmodding.ds.init.DelicateSipItemTags;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(AbstractFurnaceBlockEntity.class)
public class AbstractFurnaceBlockEntityMixin {

	@ModifyExpressionValue(method = "serverTick", at = @At(value = "INVOKE", target = "Ljava/util/Optional;orElse(Ljava/lang/Object;)Ljava/lang/Object;"))
	private static <T> T cancelRecipeIfWrongTagInRockFoundry(T original, final ServerLevel level, final BlockPos pos, BlockState state, final AbstractFurnaceBlockEntity entity) {
		if (entity instanceof RockFoundryBlockEntity) {
			ItemStack ingredient = entity.getItem(0);
			if (!ingredient.is(DelicateSipItemTags.ROCK_FOUNDRY_AFFECTED)) {
				return null;
			}
		}
		return original;
	}

	@ModifyExpressionValue(method = "serverTick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/crafting/AbstractCookingRecipe;cookingTime()I"))
	private static int tickCookTimeForRockFoundry(int original, final ServerLevel level, final BlockPos pos, BlockState state, final AbstractFurnaceBlockEntity entity) {
		if (entity instanceof RockFoundryBlockEntity) {
			return original / RockFoundryBlockEntity.ROCK_FOUNDRY_SPEED_FACTOR;
		}
		else {
			return original;
		}
	}

	@ModifyExpressionValue(method = "setItem", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/entity/AbstractFurnaceBlockEntity;getTotalCookTime(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/level/block/entity/AbstractFurnaceBlockEntity;)I"))
	private int reduceCookTimeForRockFoundry(int original) {
		if (((Object) this) instanceof RockFoundryBlockEntity) {
			return original / RockFoundryBlockEntity.ROCK_FOUNDRY_SPEED_FACTOR;
		}
		else {
			return original;
		}
	}
}
