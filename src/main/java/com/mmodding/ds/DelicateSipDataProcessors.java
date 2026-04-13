package com.mmodding.ds;

import com.mmodding.ds.block.RoundWindowBlock;
import com.mmodding.library.datagen.api.model.block.DefaultBlockModelProcessing;
import com.mojang.math.Quadrant;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import static net.minecraft.client.data.models.BlockModelGenerators.condition;
import static net.minecraft.client.data.models.BlockModelGenerators.variant;

public class DelicateSipDataProcessors {

	static void registerDelicateSipRoundWindow(BlockModelGenerators generator, Block roundWindowBlock) {
		Identifier topLeft = ModelTemplates.CUBE_ALL.createWithSuffix(roundWindowBlock, "_top_left", TextureMapping.cube(TextureMapping.getBlockTexture(roundWindowBlock, "_top_left")), generator.modelOutput);
		Identifier topRight = ModelTemplates.CUBE_ALL.createWithSuffix(roundWindowBlock, "_top_right", TextureMapping.cube(TextureMapping.getBlockTexture(roundWindowBlock, "_top_right")), generator.modelOutput);
		Identifier bottomLeft = ModelTemplates.CUBE_ALL.createWithSuffix(roundWindowBlock, "_bottom_left", TextureMapping.cube(TextureMapping.getBlockTexture(roundWindowBlock, "_bottom_left")), generator.modelOutput);
		Identifier bottomRight = ModelTemplates.CUBE_ALL.createWithSuffix(roundWindowBlock, "_bottom_right", TextureMapping.cube(TextureMapping.getBlockTexture(roundWindowBlock, "_bottom_right")), generator.modelOutput);
		generator.registerSimpleItemModel(roundWindowBlock, topLeft);
		generator.blockStateOutput.accept(
			MultiVariantGenerator.dispatch(roundWindowBlock).with(
				PropertyDispatch.initial(RoundWindowBlock.WINDOW_ROTATION)
					.select(RoundWindowBlock.Rotation.TOP_LEFT, variant(new Variant(topLeft)))
					.select(RoundWindowBlock.Rotation.TOP_RIGHT, variant(new Variant(topRight)))
					.select(RoundWindowBlock.Rotation.BOTTOM_LEFT, variant(new Variant(bottomLeft)))
					.select(RoundWindowBlock.Rotation.BOTTOM_RIGHT, variant(new Variant(bottomRight)))
			)
		);
	}

	private static void registerDelicateSipRoundWindowPaneSubModel(BlockModelGenerators generator, MultiPartGenerator multiPart, Block roundWindowBlock, Block roundWindowPaneBlock, String paneTopPath, RoundWindowBlock.Rotation rotation) {
		TextureMapping textures = new TextureMapping();
		textures.put(TextureSlot.PANE, TextureMapping.getBlockTexture(roundWindowBlock, "_" + rotation.getSerializedName())).put(TextureSlot.EDGE, new Material(DelicateSip.createId(paneTopPath)));
		Identifier panePost = ModelTemplates.STAINED_GLASS_PANE_POST.createWithSuffix(roundWindowPaneBlock, "_" + rotation.getSerializedName(), textures, generator.modelOutput);
		Identifier paneSide = ModelTemplates.STAINED_GLASS_PANE_SIDE.createWithSuffix(roundWindowPaneBlock, "_" + rotation.getSerializedName(), textures, generator.modelOutput);
		Identifier paneSideAlt = ModelTemplates.STAINED_GLASS_PANE_SIDE_ALT.createWithSuffix(roundWindowPaneBlock, "_" + rotation.getSerializedName(), textures, generator.modelOutput);
		Identifier paneNoSide = ModelTemplates.STAINED_GLASS_PANE_NOSIDE.createWithSuffix(roundWindowPaneBlock, "_" + rotation.getSerializedName(), textures, generator.modelOutput);
		Identifier paneNoSideAlt = ModelTemplates.STAINED_GLASS_PANE_NOSIDE_ALT.createWithSuffix(roundWindowPaneBlock, "_" + rotation.getSerializedName(), textures, generator.modelOutput);
		multiPart.with(condition(RoundWindowBlock.WINDOW_ROTATION, rotation), variant(new Variant(panePost)))
			.with(condition(RoundWindowBlock.WINDOW_ROTATION, rotation).term(BlockStateProperties.NORTH, true), variant(new Variant(paneSide)))
			.with(condition(RoundWindowBlock.WINDOW_ROTATION, rotation).term(BlockStateProperties.EAST, true), variant(new Variant(paneSide).withYRot(Quadrant.R90)))
			.with(condition(RoundWindowBlock.WINDOW_ROTATION, rotation).term(BlockStateProperties.SOUTH, true), variant(new Variant(paneSideAlt)))
			.with(condition(RoundWindowBlock.WINDOW_ROTATION, rotation).term(BlockStateProperties.WEST, true), variant(new Variant(paneSideAlt).withYRot(Quadrant.R90)))
			.with(condition(RoundWindowBlock.WINDOW_ROTATION, rotation).term(BlockStateProperties.NORTH, false), variant(new Variant(paneNoSide)))
			.with(condition(RoundWindowBlock.WINDOW_ROTATION, rotation).term(BlockStateProperties.EAST, false), variant(new Variant(paneNoSideAlt)))
			.with(condition(RoundWindowBlock.WINDOW_ROTATION, rotation).term(BlockStateProperties.SOUTH, false), variant(new Variant(paneNoSideAlt).withYRot(Quadrant.R90)))
			.with(condition(RoundWindowBlock.WINDOW_ROTATION, rotation).term(BlockStateProperties.WEST, false), variant(new Variant(paneNoSide).withYRot(Quadrant.R270)));
	}

	static void registerDelicateSipRoundWindowPane(BlockModelGenerators generator, Block roundWindowPaneBlock) {
		ResourceKey<Block> roundWindowPaneKey = roundWindowPaneBlock.builtInRegistryHolder().key();
		ResourceKey<Block> roundWindowKey = roundWindowPaneKey.mapValue(value -> value.withPath(path -> path.replace("_pane", "")));
		Block roundWindowBlock = BuiltInRegistries.BLOCK.getValueOrThrow(roundWindowKey);
		Identifier itemModel = generator.createFlatItemModelWithBlockTexture(roundWindowPaneBlock.asItem(), roundWindowBlock);
		generator.registerSimpleItemModel(roundWindowPaneBlock, itemModel);
		String[] split = roundWindowPaneKey.identifier().getPath().split("_");
		String woodSet = split[0];
		if (woodSet.equals("dark") || woodSet.equals("pale")) woodSet += "_" + split[1];
		String paneTop = "block/" + woodSet + "_pane_top";
		MultiPartGenerator multiPart = MultiPartGenerator.multiPart(roundWindowPaneBlock);
		for (RoundWindowBlock.Rotation rotation : RoundWindowBlock.Rotation.values()) {
			DelicateSipDataProcessors.registerDelicateSipRoundWindowPaneSubModel(generator, multiPart, roundWindowBlock, roundWindowPaneBlock, paneTop, rotation);
		}
		generator.blockStateOutput.accept(multiPart);
	}

	static void registerDelicateSipWoodPane(BlockModelGenerators generator, Block paneBlock) {
		ResourceKey<Block> paneKey = paneBlock.builtInRegistryHolder().key();
		ResourceKey<Block> glassKey = paneKey.mapValue(value -> value.withPath(path -> path.replace("_pane", "")));
		if (!BuiltInRegistries.BLOCK.containsKey(glassKey)) {
			glassKey = paneKey.mapValue(value -> value.withPath(path -> path.replace("_pane", "s")));
		}
		Block glassBlock = BuiltInRegistries.BLOCK.getValueOrThrow(glassKey);
		String[] split = paneKey.identifier().getPath().split("_");
		String woodSet = split[0];
		if (woodSet.equals("dark") || woodSet.equals("pale")) woodSet += "_" + split[1];
		String paneTop = "block/" + woodSet + "_pane_top";
		DefaultBlockModelProcessing.createGlassPane(generator, glassBlock, paneBlock, new Material(DelicateSip.createId(paneTop)));
	}
}
