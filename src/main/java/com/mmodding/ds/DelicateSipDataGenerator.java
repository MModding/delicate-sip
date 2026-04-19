package com.mmodding.ds;

import com.mmodding.ds.block.RockFoundryBlock;
import com.mmodding.ds.block.RoundWindowBlock;
import com.mmodding.ds.block.RoundWindowPaneBlock;
import com.mmodding.ds.init.DelicateSipBlocks;
import com.mmodding.ds.init.DelicateSipItems;
import com.mmodding.ds.item.ScrewdriverItem;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.datagen.api.ExtendedDataGeneratorEntrypoint;
import com.mmodding.library.datagen.api.lang.DefaultLangProcessors;
import com.mmodding.library.datagen.api.management.DataManager;
import com.mmodding.library.datagen.api.management.DefaultDataHandlers;
import com.mmodding.library.datagen.api.model.block.DefaultBlockModelProcessing;
import com.mmodding.library.datagen.api.model.block.MModdingTexturedModels;
import com.mmodding.library.datagen.api.provider.MModdingLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;

import java.util.concurrent.CompletableFuture;

public class DelicateSipDataGenerator implements ExtendedDataGeneratorEntrypoint {

	@Override
	public void setupManager(DataManager manager) {
		manager.chain(DelicateSipBlocks.class, DefaultDataHandlers.BLOCK_MODELS)
			.chain(block -> block instanceof RockFoundryBlock, (generator, block) -> generator.createFurnace(block, MModdingTexturedModels.ORIENTABLE_WITH_BACK))
			.chain(block -> block instanceof LadderBlock, DefaultBlockModelProcessing::createLadder)
			.chain(block -> block instanceof RoundWindowBlock, DelicateSipDataProcessors::registerRoundWindow)
			.chain(block -> block instanceof RoundWindowPaneBlock, DelicateSipDataProcessors::registerRoundWindowPane)
			.chain(block -> block instanceof IronBarsBlock, DelicateSipDataProcessors::registerSipWoodPane)
			.chain(block -> block instanceof DoorBlock, BlockModelGenerators::createDoor)
			.chain(block -> block instanceof TrapDoorBlock, BlockModelGenerators::createOrientableTrapdoor)
			.chain(BlockModelGenerators::createTrivialCube);
		manager.task(DelicateSipBlocks.class, DefaultDataHandlers.BLOCK_FAMILIES);
		manager.chain(DelicateSipBlocks.class, DefaultDataHandlers.BLOCK_TAGS)
			.chain(block -> block instanceof DoorBlock, (tags, block) -> tags.apply(BlockTags.DOORS).add(block))
			.chain(block -> block instanceof TrapDoorBlock, (tags, block) -> tags.apply(BlockTags.TRAPDOORS).add(block));
		manager.task(DelicateSipBlocks.class, DefaultDataHandlers.getTranslationHandler(Registries.BLOCK, Block.class), DefaultLangProcessors.CLASSIC);
		manager.task(DelicateSipItems.class, DefaultDataHandlers.ITEM_MODELS, item -> item instanceof ScrewdriverItem, (generator, item) -> generator.generateFlatItem(item, ModelTemplates.FLAT_HANDHELD_ITEM));
		manager.task(DelicateSipItems.class, DefaultDataHandlers.getTranslationHandler(Registries.ITEM, Item.class), DefaultLangProcessors.CLASSIC);
	}

	@Override
	public void onInitializeDataGenerator(AdvancedContainer advancedContainer, FabricDataGenerator generator, FabricDataGenerator.Pack pack) {
		pack.addProvider(DelicateSipLanguageProvider::new);
	}

	private static class DelicateSipLanguageProvider extends MModdingLanguageProvider {

		protected DelicateSipLanguageProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> future) {
			super(dataOutput, future);
		}

		@Override
		public void generateTranslations(HolderLookup.Provider provider, TranslationBuilder builder) {
			builder.add("container.delicate_sip.rock_foundry", "Rock Foundry");
			builder.add("itemGroup.delicate_sip.woodwork", "Delicate Sip Woodwork");
			builder.add("itemGroup.delicate_sip.stonework", "Delicate Sip Stonework");
			builder.add("itemGroup.delicate_sip.furniture", "Delicate Sip Furniture");
			builder.add("itemGroup.delicate_sip.miscellaneous", "Delicate Sip Miscellaneous");
		}
	}
}
