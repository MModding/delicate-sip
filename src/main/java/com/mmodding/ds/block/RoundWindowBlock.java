package com.mmodding.ds.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.util.math.Direction;

public class RoundWindowBlock extends GlassBlock {

	public RoundWindowBlock(Settings settings) {
		super(settings);
	}

	@Override
	public boolean isSideInvisible(BlockState state, BlockState stateFrom, Direction direction) {
		return stateFrom.getBlock() instanceof RoundWindowBlock;
	}
}
