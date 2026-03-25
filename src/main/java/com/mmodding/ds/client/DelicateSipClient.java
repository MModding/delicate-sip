package com.mmodding.ds.client;

import com.mmodding.ds.init.DelicateSipBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class DelicateSipClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		DelicateSipBlocks.LATTICES.cutout();
		DelicateSipBlocks.NARROW_WINDOWS.cutout();
		DelicateSipBlocks.NARROW_WINDOWS_PANES.cutout();
		DelicateSipBlocks.ROUND_WINDOWS.cutout();
		DelicateSipBlocks.ROUND_WINDOW_PANES.cutout();
		DelicateSipBlocks.WINDOWS.cutout();
		DelicateSipBlocks.WINDOW_PANES.cutout();
		DelicateSipBlocks.WINDOW_TILES.cutout();
		DelicateSipBlocks.WINDOW_TILE_PANES.cutout();
		DelicateSipBlocks.WAXED_DOORS.cutout();
		DelicateSipBlocks.WAXED_TRAPDOORS.cutout();
	}
}
