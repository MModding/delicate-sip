package com.mmodding.ds.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PaneBlock;
import net.minecraft.state.StateManager;

public class RoundWindowPaneBlock extends PaneBlock {

	public RoundWindowPaneBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.getDefaultState().with(RoundWindowBlock.WINDOW_ROTATION, RoundWindowBlock.Rotation.TOP_LEFT));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(RoundWindowBlock.WINDOW_ROTATION);
	}
}
