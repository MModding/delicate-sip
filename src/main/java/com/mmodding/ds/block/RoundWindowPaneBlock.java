package com.mmodding.ds.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class RoundWindowPaneBlock extends IronBarsBlock {

	public RoundWindowPaneBlock(Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(RoundWindowBlock.WINDOW_ROTATION, RoundWindowBlock.Rotation.TOP_LEFT));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(RoundWindowBlock.WINDOW_ROTATION);
	}
}
