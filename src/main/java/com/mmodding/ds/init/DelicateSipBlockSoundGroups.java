package com.mmodding.ds.init;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvents;

public class DelicateSipBlockSoundGroups {

	public static final BlockSoundGroup WAXED_WOOD = new BlockSoundGroup(
		1.0f,
		1.0f,
		DelicateSipSoundEvents.BLOCK_WAXED_WOOD_BREAK,
		DelicateSipSoundEvents.BLOCK_WAXED_WOOD_STEP,
		DelicateSipSoundEvents.BLOCK_WAXED_WOOD_PLACE,
		SoundEvents.BLOCK_WOOD_HIT,
		SoundEvents.BLOCK_WOOD_FALL
	);
}
