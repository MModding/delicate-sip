package com.mmodding.ds;

import com.mmodding.library.datagen.api.model.block.DefaultBlockModelProcessing;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;

public class DelicateSipDataProcessors {

	static void registerDelicateSipWoodPane(BlockStateModelGenerator generator, Block paneBlock) {
		RegistryKey<Block> paneKey = paneBlock.getRegistryEntry().getKey().orElseThrow();
		RegistryKey<Block> glassKey = paneKey.mapValue(value -> value.withPath(path -> path.replace("_pane", "")));
		if (!Registries.BLOCK.contains(glassKey)) {
			glassKey = paneKey.mapValue(value -> value.withPath(path -> path.replace("_pane", "s")));
		}
		Block glassBlock = Registries.BLOCK.get(glassKey);
		String woodSet = paneKey.getValue().getPath().split("_")[0];
		String paneTop = "block/" + woodSet + "_pane_top";
		DefaultBlockModelProcessing.pane(generator, glassBlock, paneBlock, DelicateSip.createId(paneTop));
	}
}
