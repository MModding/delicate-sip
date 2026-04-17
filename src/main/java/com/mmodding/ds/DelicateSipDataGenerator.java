package com.mmodding.ds;

import com.mmodding.ds.block.RoundWindowBlock;
import com.mmodding.ds.block.RoundWindowPaneBlock;
import com.mmodding.ds.init.DelicateSipBlocks;
import com.mmodding.ds.init.DelicateSipItems;
import com.mmodding.ds.item.ScrewdriverItem;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.datagen.api.ExtendedDataGeneratorEntrypoint;
import com.mmodding.library.datagen.api.family.BlockFamilyProcessor;
import com.mmodding.library.datagen.api.lang.DefaultLangProcessors;
import com.mmodding.library.datagen.api.management.DataManager;
import com.mmodding.library.datagen.api.management.DefaultContentTypes;
import com.mmodding.library.datagen.api.model.block.DefaultBlockModelProcessing;
import com.mmodding.library.datagen.api.provider.MModdingLanguageProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.BlockFamily;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;

import java.util.concurrent.CompletableFuture;

public class DelicateSipDataGenerator implements ExtendedDataGeneratorEntrypoint {

	@Override
	public void setupManager(DataManager manager) {
		manager.chain(DelicateSipBlocks.class, Block.class, DefaultContentTypes.BLOCK_MODELS, block -> block instanceof LadderBlock, DefaultBlockModelProcessing::createLadder)
			.chain(block -> block instanceof RoundWindowBlock, DelicateSipDataProcessors::registerDelicateSipRoundWindow)
			.chain(block -> block instanceof RoundWindowPaneBlock, DelicateSipDataProcessors::registerDelicateSipRoundWindowPane)
			.chain(block -> block instanceof IronBarsBlock, DelicateSipDataProcessors::registerDelicateSipWoodPane)
			.chain(block -> block instanceof DoorBlock, BlockModelGenerators::createDoor)
			.chain(block -> block instanceof TrapDoorBlock, BlockModelGenerators::createOrientableTrapdoor)
			.chain(BlockModelGenerators::createTrivialCube);
		manager.task(DelicateSipBlocks.class, BlockFamily.class, DefaultContentTypes.BLOCK_FAMILIES, new BlockFamilyProcessor());
		manager.chain(DelicateSipBlocks.class, Block.class, DefaultContentTypes.BLOCK_TAGS, block -> block instanceof DoorBlock, (tags, block) -> tags.apply(BlockTags.DOORS).add(block))
			.chain(block -> block instanceof TrapDoorBlock, (tags, block) -> tags.apply(BlockTags.TRAPDOORS).add(block));
		manager.task(DelicateSipBlocks.class, Block.class, DefaultContentTypes.getTranslationHandler(Registries.BLOCK), DefaultLangProcessors.getClassic());
		manager.task(DelicateSipItems.class, Item.class, DefaultContentTypes.ITEM_MODELS, item -> item instanceof ScrewdriverItem, (generator, item) -> generator.createFlatItemModel(item, ModelTemplates.FLAT_HANDHELD_ITEM));
		manager.task(DelicateSipItems.class, Item.class, DefaultContentTypes.getTranslationHandler(Registries.ITEM), DefaultLangProcessors.getClassic());
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
