package com.mmodding.ds.init;

import com.mmodding.library.core.api.AdvancedContainer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

public class DelicateSipSoundTypes {

	public static final SoundType WAXED_WOOD = new SoundType(
		1.0f,
		1.0f,
		DelicateSipSoundEvents.BLOCK_WAXED_WOOD_BREAK,
		DelicateSipSoundEvents.BLOCK_WAXED_WOOD_STEP,
		DelicateSipSoundEvents.BLOCK_WAXED_WOOD_PLACE,
		SoundEvents.WOOD_HIT,
		SoundEvents.WOOD_FALL
	);

	public static void register(AdvancedContainer mod) {}
}
