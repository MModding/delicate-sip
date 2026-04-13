package com.mmodding.ds.block;

import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class RoundWindowBlock extends TransparentBlock {

	public static final EnumProperty<Rotation> WINDOW_ROTATION = EnumProperty.create("window_rotation", Rotation.class);

	public RoundWindowBlock(BlockBehaviour.Properties properties) {
		super(properties);
		this.registerDefaultState(this.defaultBlockState().setValue(WINDOW_ROTATION, Rotation.TOP_LEFT));
	}

	@Override
	protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
		super.createBlockStateDefinition(builder);
		builder.add(WINDOW_ROTATION);
	}

	public enum Rotation implements StringRepresentable {

		TOP_LEFT("top_left"),
		TOP_RIGHT("top_right"),
		BOTTOM_LEFT("bottom_left"),
		BOTTOM_RIGHT("bottom_right");

		private final String value;

		Rotation(String value) {
			this.value = value;
		}

		@Override
		public String getSerializedName() {
			return this.value;
		}
	}
}
