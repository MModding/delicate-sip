package com.mmodding.ds.block;

import com.mmodding.ds.block.entity.RockFoundryBlockEntity;
import com.mmodding.ds.init.DelicateSipBlockEntities;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.Nullable;

public class RockFoundryBlock extends AbstractFurnaceBlock {

	public static final MapCodec<RockFoundryBlock> CODEC = simpleCodec(RockFoundryBlock::new);

	@Override
	public MapCodec<? extends AbstractFurnaceBlock> codec() {
		return CODEC;
	}

	public RockFoundryBlock(Properties properties) {
		super(properties);
	}

	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(final Level level, final BlockState blockState, final BlockEntityType<T> type) {
		return createFurnaceTicker(level, type, DelicateSipBlockEntities.ROCK_FOUNDRY);
	}

	@Override
	protected void openContainer(Level level, BlockPos pos, Player player) {
		BlockEntity blockEntity = level.getBlockEntity(pos);
		if (blockEntity instanceof RockFoundryBlockEntity) {
			player.openMenu((MenuProvider) blockEntity);
			player.awardStat(Stats.INTERACT_WITH_FURNACE);
		}
	}

	@Override
	@Nullable
	public BlockEntity newBlockEntity(BlockPos worldPosition, BlockState blockState) {
		return new RockFoundryBlockEntity(worldPosition, blockState);
	}
}
