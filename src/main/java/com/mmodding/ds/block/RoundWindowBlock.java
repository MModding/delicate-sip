package com.mmodding.ds.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;

public class RoundWindowBlock extends GlassBlock {

	public static final EnumProperty<Rotation> WINDOW_ROTATION = EnumProperty.of("window_rotation", Rotation.class);

	public RoundWindowBlock(Settings settings) {
		super(settings);
		this.setDefaultState(this.getDefaultState().with(WINDOW_ROTATION, Rotation.TOP_LEFT));
	}

	@Override
	protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
		super.appendProperties(builder);
		builder.add(WINDOW_ROTATION);
	}

	public enum Rotation implements StringIdentifiable {
		TOP_LEFT("top_left"),
		TOP_RIGHT("top_right"),
		BOTTOM_LEFT("bottom_left"),
		BOTTOM_RIGHT("bottom_right");

		private final String value;

		Rotation(String value) {
			this.value = value;
		}

		@Override
		public String asString() {
			return this.value;
		}
	}
}
