package com.mmodding.ds;

import com.mmodding.ds.init.DelicateSipBlocks;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.datagen.api.ExtendedDataGeneratorEntrypoint;
import com.mmodding.library.datagen.api.family.BlockFamilyProcessor;
import com.mmodding.library.datagen.api.lang.DefaultLangProcessors;
import com.mmodding.library.datagen.api.management.DataManager;
import com.mmodding.library.datagen.api.management.DefaultContentTypes;
import com.mmodding.library.datagen.api.model.block.DefaultBlockModelProcessing;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.PaneBlock;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.registry.RegistryKeys;

public class DelicateSipDataGenerator implements ExtendedDataGeneratorEntrypoint {

	@Override
	public void setupManager(DataManager manager) {
		manager.chain(DelicateSipBlocks.class, Block.class, DefaultContentTypes.BLOCK_MODELS, block -> block instanceof LadderBlock, DefaultBlockModelProcessing::ladder)
			.chain(block -> block instanceof PaneBlock, DelicateSipDataProcessors::registerDelicateSipWoodPane)
			.chain(BlockStateModelGenerator::registerSimpleCubeAll);
		manager.task(DelicateSipBlocks.class, BlockFamily.class, DefaultContentTypes.BLOCK_FAMILIES, new BlockFamilyProcessor());
		manager.task(DelicateSipBlocks.class, Block.class, DefaultContentTypes.getTranslationHandler(RegistryKeys.BLOCK), DefaultLangProcessors.getClassic());
	}

	@Override
	public void onInitializeDataGenerator(AdvancedContainer advancedContainer, FabricDataGenerator generator, FabricDataGenerator.Pack pack) {}
}
