package com.mmodding.ds.item;

import com.mmodding.ds.block.RoundWindowBlock;
import com.mmodding.ds.block.RoundWindowPaneBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;

public class ScrewdriverItem extends ToolItem {

	public ScrewdriverItem(ToolMaterial material, Settings settings) {
		super(material, settings);
	}

	@Override
	public ActionResult useOnBlock(ItemUsageContext context) {
		BlockState state = context.getWorld().getBlockState(context.getBlockPos());
		if (state.getBlock() instanceof RoundWindowBlock || state.getBlock() instanceof RoundWindowPaneBlock) {
			if (!context.getWorld().isClient()) {
				context.getWorld().setBlockState(context.getBlockPos(), state.cycle(RoundWindowBlock.WINDOW_ROTATION));
				if (context.getPlayer() != null) {
					context.getStack().damage(1, context.getPlayer(), player -> player.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
				}
			}
			return ActionResult.SUCCESS;
		}
		else {
			return super.useOnBlock(context);
		}
	}
}
