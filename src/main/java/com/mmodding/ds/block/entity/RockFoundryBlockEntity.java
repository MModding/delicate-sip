package com.mmodding.ds.block.entity;

import com.mmodding.ds.init.DelicateSipBlockEntities;
import com.mmodding.ds.mixin.AbstractFurnaceBlockEntityMixin;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.FurnaceMenu;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

/**
 * Relies on {@link AbstractFurnaceBlockEntityMixin}.
 */
public class RockFoundryBlockEntity extends AbstractFurnaceBlockEntity {

	private static final Component DEFAULT_NAME = Component.translatable("container.delicate_sip.rock_foundry");

	public RockFoundryBlockEntity(BlockPos worldPosition, BlockState blockState) {
		super(DelicateSipBlockEntities.ROCK_FOUNDRY, worldPosition, blockState, RecipeType.SMELTING);
	}

	@Override
	protected Component getDefaultName() {
		return DEFAULT_NAME;
	}

	@Override
	protected AbstractContainerMenu createMenu(int containerId, Inventory inventory) {
		return new FurnaceMenu(containerId, inventory, this, this.dataAccess);
	}
}
