package com.mmodding.ds;

import com.mmodding.ds.block.RoundWindowBlock;
import com.mmodding.library.datagen.api.model.block.DefaultBlockModelProcessing;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

public class DelicateSipDataProcessors {

	static void registerDelicateSipRoundWindow(BlockStateModelGenerator generator, Block roundWindowBlock) {
		Identifier topLeft = Models.CUBE_ALL.upload(roundWindowBlock, "_top_left", TextureMap.all(TextureMap.getSubId(roundWindowBlock, "_top_left")), generator.modelCollector);
		Identifier topRight = Models.CUBE_ALL.upload(roundWindowBlock, "_top_right", TextureMap.all(TextureMap.getSubId(roundWindowBlock, "_top_right")), generator.modelCollector);
		Identifier bottomLeft = Models.CUBE_ALL.upload(roundWindowBlock, "_bottom_left", TextureMap.all(TextureMap.getSubId(roundWindowBlock, "_bottom_left")), generator.modelCollector);
		Identifier bottomRight = Models.CUBE_ALL.upload(roundWindowBlock, "_bottom_right", TextureMap.all(TextureMap.getSubId(roundWindowBlock, "_bottom_right")), generator.modelCollector);
		generator.registerParentedItemModel(roundWindowBlock, topLeft);
		generator.blockStateCollector.accept(
			VariantsBlockStateSupplier.create(roundWindowBlock).coordinate(
				BlockStateVariantMap.create(RoundWindowBlock.WINDOW_ROTATION)
					.register(
						RoundWindowBlock.Rotation.TOP_LEFT,
						BlockStateVariant.create()
							.put(VariantSettings.MODEL, topLeft)
					)
					.register(
						RoundWindowBlock.Rotation.TOP_RIGHT,
						BlockStateVariant.create()
							.put(VariantSettings.MODEL, topRight)
					)
					.register(
						RoundWindowBlock.Rotation.BOTTOM_LEFT,
						BlockStateVariant.create()
							.put(VariantSettings.MODEL, bottomLeft)
					)
					.register(
						RoundWindowBlock.Rotation.BOTTOM_RIGHT,
						BlockStateVariant.create()
							.put(VariantSettings.MODEL, bottomRight)
					)
			)
		);
	}

	private static void registerDelicateSipRoundWindowPaneSubModel(BlockStateModelGenerator generator, MultipartBlockStateSupplier supplier, Block roundWindowBlock, Block roundWindowPaneBlock, String paneTopPath, RoundWindowBlock.Rotation rotation) {
		TextureMap textures = new TextureMap();
		textures.put(TextureKey.PANE, TextureMap.getSubId(roundWindowBlock, "_" + rotation.asString())).put(TextureKey.EDGE, DelicateSip.createId(paneTopPath));
		Identifier panePost = Models.TEMPLATE_GLASS_PANE_POST.upload(roundWindowPaneBlock, "_" + rotation.asString(), textures, generator.modelCollector);
		Identifier paneSide = Models.TEMPLATE_GLASS_PANE_SIDE.upload(roundWindowPaneBlock, "_" + rotation.asString(), textures, generator.modelCollector);
		Identifier paneSideAlt = Models.TEMPLATE_GLASS_PANE_SIDE_ALT.upload(roundWindowPaneBlock, "_" + rotation.asString(), textures, generator.modelCollector);
		Identifier paneNoSide = Models.TEMPLATE_GLASS_PANE_NOSIDE.upload(roundWindowPaneBlock, "_" + rotation.asString(), textures, generator.modelCollector);
		Identifier paneNoSideAlt = Models.TEMPLATE_GLASS_PANE_NOSIDE_ALT.upload(roundWindowPaneBlock, "_" + rotation.asString(), textures, generator.modelCollector);
		supplier.with(
			When.create().set(RoundWindowBlock.WINDOW_ROTATION, rotation),
			BlockStateVariant.create()
				.put(VariantSettings.MODEL, panePost)
		)
		.with(
			When.create().set(RoundWindowBlock.WINDOW_ROTATION, rotation).set(Properties.NORTH, true),
			BlockStateVariant.create()
				.put(VariantSettings.MODEL, paneSide)
		)
		.with(
			When.create().set(RoundWindowBlock.WINDOW_ROTATION, rotation).set(Properties.EAST, true),
			BlockStateVariant.create()
				.put(VariantSettings.MODEL, paneSide)
				.put(VariantSettings.Y, VariantSettings.Rotation.R90)
		)
		.with(
			When.create().set(RoundWindowBlock.WINDOW_ROTATION, rotation).set(Properties.SOUTH, true),
			BlockStateVariant.create()
				.put(VariantSettings.MODEL, paneSideAlt)
		)
		.with(
			When.create().set(RoundWindowBlock.WINDOW_ROTATION, rotation).set(Properties.WEST, true),
			BlockStateVariant.create()
				.put(VariantSettings.MODEL, paneSideAlt)
				.put(VariantSettings.Y, VariantSettings.Rotation.R90)
		)
		.with(
			When.create().set(RoundWindowBlock.WINDOW_ROTATION, rotation).set(Properties.NORTH, false),
			BlockStateVariant.create()
				.put(VariantSettings.MODEL, paneNoSide)
		)
		.with(
			When.create().set(RoundWindowBlock.WINDOW_ROTATION, rotation).set(Properties.EAST, false),
			BlockStateVariant.create()
				.put(VariantSettings.MODEL, paneNoSideAlt)
		)
		.with(
			When.create().set(RoundWindowBlock.WINDOW_ROTATION, rotation).set(Properties.SOUTH, false),
			BlockStateVariant.create().put(VariantSettings.MODEL, paneNoSideAlt)
				.put(VariantSettings.Y, VariantSettings.Rotation.R90)
		)
		.with(
			When.create().set(RoundWindowBlock.WINDOW_ROTATION, rotation).set(Properties.WEST, false),
			BlockStateVariant.create().put(VariantSettings.MODEL, paneNoSide)
				.put(VariantSettings.Y, VariantSettings.Rotation.R270)
		);
	}

	static void registerDelicateSipRoundWindowPane(BlockStateModelGenerator generator, Block roundWindowPaneBlock) {
		RegistryKey<Block> roundWindowPaneKey = roundWindowPaneBlock.getRegistryEntry().getKey().orElseThrow();
		RegistryKey<Block> roundWindowKey = roundWindowPaneKey.mapValue(value -> value.withPath(path -> path.replace("_pane", "")));
		Block roundWindowBlock = Registries.BLOCK.get(roundWindowKey);
		Models.GENERATED.upload(ModelIds.getItemModelId(roundWindowPaneBlock.asItem()), TextureMap.layer0(TextureMap.getSubId(roundWindowBlock, "_top_left")), generator.modelCollector);
		String[] split = roundWindowPaneKey.getValue().getPath().split("_");
		String woodSet = split[0];
		if (woodSet.equals("dark") || woodSet.equals("pale")) woodSet += "_" + split[1];
		String paneTop = "block/" + woodSet + "_pane_top";
		MultipartBlockStateSupplier supplier = MultipartBlockStateSupplier.create(roundWindowPaneBlock);
		for (RoundWindowBlock.Rotation rotation : RoundWindowBlock.Rotation.values()) {
			DelicateSipDataProcessors.registerDelicateSipRoundWindowPaneSubModel(generator, supplier, roundWindowBlock, roundWindowPaneBlock, paneTop, rotation);
		}
		generator.blockStateCollector.accept(supplier);
	}

	static void registerDelicateSipWoodPane(BlockStateModelGenerator generator, Block paneBlock) {
		RegistryKey<Block> paneKey = paneBlock.getRegistryEntry().getKey().orElseThrow();
		RegistryKey<Block> glassKey = paneKey.mapValue(value -> value.withPath(path -> path.replace("_pane", "")));
		if (!Registries.BLOCK.contains(glassKey)) {
			glassKey = paneKey.mapValue(value -> value.withPath(path -> path.replace("_pane", "s")));
		}
		Block glassBlock = Registries.BLOCK.get(glassKey);
		String[] split = paneKey.getValue().getPath().split("_");
		String woodSet = split[0];
		if (woodSet.equals("dark") || woodSet.equals("pale")) woodSet += "_" + split[1];
		String paneTop = "block/" + woodSet + "_pane_top";
		DefaultBlockModelProcessing.pane(generator, glassBlock, paneBlock, DelicateSip.createId(paneTop));
	}
}
