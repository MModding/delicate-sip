package com.mmodding.ds.init;

import com.mmodding.ds.DelicateSip;
import com.mmodding.library.core.api.AdvancedContainer;
import net.minecraft.registry.Registries;
import net.minecraft.sound.SoundEvent;

public class DelicateSipSoundEvents {

	public static final SoundEvent BLOCK_WAXED_WOOD_BREAK = SoundEvent.of(DelicateSip.createId("block.waxed_wood.break"));
	public static final SoundEvent BLOCK_WAXED_WOOD_PLACE = SoundEvent.of(DelicateSip.createId("block.waxed_wood.place"));
	public static final SoundEvent BLOCK_WAXED_WOOD_STEP = SoundEvent.of(DelicateSip.createId("block.waxed_wood.step"));

	public static void register(AdvancedContainer mod) {
		mod.register(Registries.SOUND_EVENT, factory -> {
			factory.register("block.waxed_wood.break", BLOCK_WAXED_WOOD_BREAK);
			factory.register("block.waxed_wood.place", BLOCK_WAXED_WOOD_PLACE);
			factory.register("block.waxed_wood.step", BLOCK_WAXED_WOOD_STEP);
		});
	}
}
