package com.mmodding.ds.item;

import com.mmodding.ds.block.RoundWindowBlock;
import com.mmodding.ds.block.RoundWindowPaneBlock;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;

public class ScrewdriverItem extends Item {

	public ScrewdriverItem(Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		BlockState state = context.getLevel().getBlockState(context.getClickedPos());
		if (state.getBlock() instanceof RoundWindowBlock || state.getBlock() instanceof RoundWindowPaneBlock) {
			if (!context.getLevel().isClientSide()) {
				context.getLevel().setBlock(context.getClickedPos(), state.cycle(RoundWindowBlock.WINDOW_ROTATION), 3);
				if (context.getPlayer() != null) {
					context.getItemInHand().hurtAndBreak(1, (ServerLevel) context.getLevel(), (ServerPlayer) context.getPlayer(), brokenItem -> context.getPlayer().onEquippedItemBroken(brokenItem, EquipmentSlot.MAINHAND));
				}
			}
			return InteractionResult.SUCCESS;
		}
		else {
			return super.useOn(context);
		}
	}
}
