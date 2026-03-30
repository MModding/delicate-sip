package com.mmodding.ds.init;

import com.mmodding.ds.DelicateSip;
import com.mmodding.ds.block.RoundWindowBlock;
import com.mmodding.ds.block.RoundWindowPaneBlock;
import com.mmodding.library.block.api.wrapper.BlockHeap;
import com.mmodding.library.block.api.wrapper.BlockRelatives;
import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;

public class DelicateSipBlocks {

	public static final BlockHeap BEAMS = BlockHeap.create(Block::new, wood -> wood + "_beam", DelicateSipBlocks::createWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap LATTICES = BlockHeap.create(LadderBlock::new, wood -> wood + "_lattice", DelicateSipBlocks::createNonOpaqueWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap NARROW_WINDOWS = BlockHeap.create(GlassBlock::new, wood -> wood + "_narrow_windows", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap NARROW_WINDOWS_PANES = BlockHeap.create(PaneBlock::new, wood -> wood + "_narrow_windows_pane", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap PARQUETS = BlockHeap.create(Block::new, wood -> wood + "_parquet", DelicateSipBlocks::createWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap ROUND_WINDOWS = BlockHeap.create(RoundWindowBlock::new, wood -> wood + "_round_window", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap ROUND_WINDOW_PANES = BlockHeap.create(RoundWindowPaneBlock::new, wood -> wood + "_round_window_pane", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap TILES = BlockHeap.create(Block::new, wood -> wood + "_tiles", DelicateSipBlocks::createWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap WAINSCOTINGS = BlockHeap.create(Block::new, wood -> wood + "_wainscoting", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap WINDOWS = BlockHeap.create(GlassBlock::new, wood -> wood + "_window", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap WINDOW_PANES = BlockHeap.create(PaneBlock::new, wood -> wood + "_window_pane", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap WINDOW_TILES = BlockHeap.create(GlassBlock::new, wood -> wood + "_window_tiles", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap WINDOW_TILE_PANES = BlockHeap.create(PaneBlock::new, wood -> wood + "_window_tile_pane", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap CUT_BLOCKS = BlockHeap.create(Block::new, wood -> "cut_" + wood + "_block", DelicateSipBlocks::createWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap CLOSET_DOORS = BlockHeap.create((wood, settings) -> new DoorBlock(settings, DelicateSip.WOOD_SET_TYPES.get(wood)), wood -> "closet_" + wood + "_door", DelicateSipBlocks::createWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap CLOSET_TRAPDOORS = BlockHeap.create((wood, settings) -> new TrapdoorBlock(settings, DelicateSip.WOOD_SET_TYPES.get(wood)), wood -> "closet_" + wood + "_trapdoor", DelicateSipBlocks::createWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap PLAIN_DOORS = BlockHeap.create((wood, settings) -> new DoorBlock(settings, DelicateSip.WOOD_SET_TYPES.get(wood)), wood -> "plain_" + wood + "_door", DelicateSipBlocks::createWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap PLAIN_TRAPDOORS = BlockHeap.create((wood, settings) -> new TrapdoorBlock(settings, DelicateSip.WOOD_SET_TYPES.get(wood)), wood -> "plain_" + wood + "_trapdoor", DelicateSipBlocks::createWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap SPLIT_DOORS = BlockHeap.create((wood, settings) -> new DoorBlock(settings, DelicateSip.WOOD_SET_TYPES.get(wood)), wood -> "split_" + wood + "_door", DelicateSipBlocks::createWoodSettings, DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap WAXED_DOORS = BlockHeap.create((wood, settings) -> new DoorBlock(settings, DelicateSip.WOOD_SET_TYPES.get(wood)), wood -> "waxed_" + wood + "_door", wood -> DelicateSipBlocks.createNonOpaqueWoodSettings(wood).sounds(DelicateSipBlockSoundGroups.WAXED_WOOD), DelicateSip.WOOD_SETS).withItem();
	public static final BlockHeap WAXED_TRAPDOORS = BlockHeap.create((wood, settings) -> new TrapdoorBlock(settings, DelicateSip.WOOD_SET_TYPES.get(wood)), wood -> "waxed_" + wood + "_trapdoor", wood -> DelicateSipBlocks.createNonOpaqueWoodSettings(wood).sounds(DelicateSipBlockSoundGroups.WAXED_WOOD), DelicateSip.WOOD_SETS).withItem();

	public static final BlockRelatives POLISHED_STONE = BlockRelatives.createStone(DelicateSip.createId("polished_stone"), false, settings -> settings.mapColor(DyeColor.GRAY), false, false);

	public static final BlockRelatives DEEPSLATE_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("deepslate_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);

	public static final BlockRelatives BASALT_BRICKS = BlockRelatives.createStone(DelicateSip.createId("basalt_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CRACKED_BASALT_BRICKS = BlockRelatives.createStone(DelicateSip.createId("cracked_basalt_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives BASALT_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("basalt_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives BASALT_TILES = BlockRelatives.createStone(DelicateSip.createId("basalt_tile"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CHISELED_BASALT = BlockRelatives.createStone(DelicateSip.createId("chiseled_basalt"), settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives POLISHED_BASALT = BlockRelatives.createStone(DelicateSip.createId("polished_basalt"), settings -> settings.mapColor(DyeColor.BLACK), false, false);

	public static final BlockRelatives POLISHED_BLACKSTONE_TILES = BlockRelatives.createStone(DelicateSip.createId("polished_blackstone_tile"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives POLISHED_BLACKSTONE_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("polished_blackstone_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);

	public static final BlockRelatives POLISHED_GILDED_BLACKSTONE = BlockRelatives.createStone(DelicateSip.createId("polished_gilded_blackstone"), false, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives POLISHED_GILDED_BLACKSTONE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("polished_gilded_blackstone_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CRACKED_POLISHED_GILDED_BLACKSTONE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("cracked_polished_gilded_blackstone_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives POLISHED_GILDED_BLACKSTONE_TILES = BlockRelatives.createStone(DelicateSip.createId("polished_gilded_blackstone_tile"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives POLISHED_GILDED_BLACKSTONE_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("polished_gilded_blackstone_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final Block CHISELED_GILDED_BLACKSTONE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(DyeColor.BLACK)).withItem();

	public static final BlockRelatives PAVEMENT = BlockRelatives.createStone(DelicateSip.createId("pavement"), settings -> settings.mapColor(DyeColor.GRAY), false, false);
	public static final BlockRelatives WARM_PAVEMENT = BlockRelatives.createStone(DelicateSip.createId("warm_pavement"), settings -> settings.mapColor(DyeColor.GRAY), false, false);

	public static final BlockRelatives ORNATE_PAVEMENT = BlockRelatives.createStone(DelicateSip.createId("ornate_pavement"), settings -> settings.mapColor(DyeColor.GRAY), false, false);
	public static final BlockRelatives WARM_ORNATE_PAVEMENT = BlockRelatives.createStone(DelicateSip.createId("warm_ornate_pavement"), settings -> settings.mapColor(DyeColor.GRAY), false, false);

	public static final BlockRelatives MOSSY_PAVEMENT = BlockRelatives.createStone(DelicateSip.createId("mossy_pavement"), settings -> settings.mapColor(DyeColor.GRAY), false, false);
	public static final BlockRelatives MOSSY_WARM_PAVEMENT = BlockRelatives.createStone(DelicateSip.createId("mossy_warm_pavement"), settings -> settings.mapColor(DyeColor.GRAY), false, false);

	public static final BlockRelatives MOSSY_ORNATE_PAVEMENT = BlockRelatives.createStone(DelicateSip.createId("mossy_ornate_pavement"), settings -> settings.mapColor(DyeColor.GRAY), false, false);
	public static final BlockRelatives MOSSY_WARM_ORNATE_PAVEMENT = BlockRelatives.createStone(DelicateSip.createId("mossy_warm_ornate_pavement"), settings -> settings.mapColor(DyeColor.GRAY), false, false);

	public static final BlockRelatives MIXED_BRICKS = BlockRelatives.createStone(DelicateSip.createId("mixed_brick"), true, settings -> settings.mapColor(DyeColor.GRAY), false, false);
	public static final BlockRelatives ALIGNED_MIXED_BRICKS = BlockRelatives.createStone(DelicateSip.createId("aligned_mixed_brick"), true, settings -> settings.mapColor(DyeColor.GRAY), false, false);
	public static final BlockRelatives ALIGNED_WARM_MIXED_BRICKS = BlockRelatives.createStone(DelicateSip.createId("aligned_warm_mixed_brick"), true, settings -> settings.mapColor(DyeColor.GRAY), false, false);

	public static final BlockRelatives CORK = BlockRelatives.createStone(DelicateSip.createId("cork"), false, settings -> settings.mapColor(DyeColor.YELLOW), false, false);

	public static final BlockRelatives BLOOMS_WALLPAPER = BlockRelatives.createStone(DelicateSip.createId("blooms_wallpaper"), settings -> settings.sounds(BlockSoundGroup.CHERRY_LEAVES), false, false);
	public static final BlockRelatives FEATHERS_WALLPAPER = BlockRelatives.createStone(DelicateSip.createId("feathers_wallpaper"), settings -> settings.sounds(BlockSoundGroup.CHERRY_LEAVES), false, false);
	public static final BlockRelatives LEAVES_WALLPAPER = BlockRelatives.createStone(DelicateSip.createId("leaves_wallpaper"), settings -> settings.sounds(BlockSoundGroup.CHERRY_LEAVES), false, false);

	public static final BlockRelatives BLACK_MARBLE = BlockRelatives.createStone(DelicateSip.createId("black_marble"), settings -> settings.mapColor(DyeColor.BLACK), true, false);
	public static final BlockRelatives SMOOTH_BLACK_MARBLE = BlockRelatives.createStone(DelicateSip.createId("smooth_black_marble"), settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives BLACK_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("black_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CRACKED_BLACK_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("cracked_black_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives BLACK_MARBLE_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("black_marble_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives BLACK_MARBLE_TILES = BlockRelatives.createStone(DelicateSip.createId("black_marble_tile"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final Block CHISELED_BLACK_MARBLE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(DyeColor.BLACK)).withItem();

	public static final BlockRelatives WHITE_MARBLE = BlockRelatives.createStone(DelicateSip.createId("white_marble"), settings -> settings.mapColor(DyeColor.WHITE), true, false);
	public static final BlockRelatives SMOOTH_WHITE_MARBLE = BlockRelatives.createStone(DelicateSip.createId("smooth_white_marble"), settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives WHITE_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("white_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CRACKED_WHITE_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("cracked_white_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives WHITE_MARBLE_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("white_marble_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives WHITE_MARBLE_TILES = BlockRelatives.createStone(DelicateSip.createId("white_marble_tile"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final Block CHISELED_WHITE_MARBLE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(DyeColor.BLACK)).withItem();

	public static final BlockRelatives VERDANT_MARBLE = BlockRelatives.createStone(DelicateSip.createId("verdant_marble"), settings -> settings.mapColor(DyeColor.GREEN), true, false);
	public static final BlockRelatives SMOOTH_VERDANT_MARBLE = BlockRelatives.createStone(DelicateSip.createId("smooth_verdant_marble"), settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives VERDANT_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("verdant_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CRACKED_VERDANT_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("cracked_verdant_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives VERDANT_MARBLE_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("verdant_marble_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives VERDANT_MARBLE_TILES = BlockRelatives.createStone(DelicateSip.createId("verdant_marble_tile"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final Block CHISELED_VERDANT_MARBLE = new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(DyeColor.BLACK)).withItem();

	public static FabricBlockSettings createWoodSettings(String wood) {
		return switch (wood) {
			case "acacia" -> FabricBlockSettings.copyOf(Blocks.ACACIA_PLANKS);
			case "bamboo" -> FabricBlockSettings.copyOf(Blocks.BAMBOO_PLANKS);
			case "birch" -> FabricBlockSettings.copyOf(Blocks.BIRCH_PLANKS);
			case "cherry" -> FabricBlockSettings.copyOf(Blocks.CHERRY_PLANKS);
			case "dark_oak" -> FabricBlockSettings.copyOf(Blocks.DARK_OAK_PLANKS);
			case "mangrove" -> FabricBlockSettings.copyOf(Blocks.MANGROVE_PLANKS);
			case "oak" -> FabricBlockSettings.copyOf(Blocks.OAK_PLANKS);
			// case "pale_oak" -> FabricBlockSettings.copyOf(Blocks.PALE_OAK_PLANKS);
			case "spruce" -> FabricBlockSettings.copyOf(Blocks.SPRUCE_PLANKS);
			default -> throw new IllegalStateException(wood + " is not a valid wood type");
		};
	}

	public static FabricBlockSettings createNonOpaqueWoodSettings(String wood) {
		return DelicateSipBlocks.createWoodSettings(wood).nonOpaque();
	}

	public static FabricBlockSettings createTransparentWoodSettings(String wood) {
		return DelicateSipBlocks.createNonOpaqueWoodSettings(wood).allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never);
	}

	public static void register(AdvancedContainer mod) {
		BEAMS.register(mod::createId);
		LATTICES.register(mod::createId);
		NARROW_WINDOWS.register(mod::createId);
		NARROW_WINDOWS_PANES.register(mod::createId);
		PARQUETS.register(mod::createId);
		ROUND_WINDOWS.register(mod::createId);
		ROUND_WINDOW_PANES.register(mod::createId);
		TILES.register(mod::createId);
		WAINSCOTINGS.register(mod::createId);
		WINDOWS.register(mod::createId);
		WINDOW_PANES.register(mod::createId);
		WINDOW_TILES.register(mod::createId);
		WINDOW_TILE_PANES.register(mod::createId);
		CUT_BLOCKS.register(mod::createId);
		CLOSET_DOORS.register(mod::createId);
		CLOSET_TRAPDOORS.register(mod::createId);
		PLAIN_DOORS.register(mod::createId);
		PLAIN_TRAPDOORS.register(mod::createId);
		SPLIT_DOORS.register(mod::createId);
		WAXED_DOORS.register(mod::createId);
		WAXED_TRAPDOORS.register(mod::createId);
		BASALT_BRICKS.register();
		BASALT_FLAGSTONES.register();
		BASALT_TILES.register();
		POLISHED_STONE.register();
		DEEPSLATE_FLAGSTONES.register();
		CHISELED_BASALT.register();
		CRACKED_BASALT_BRICKS.register();
		POLISHED_BASALT.register();
		POLISHED_BLACKSTONE_TILES.register();
		POLISHED_BLACKSTONE_FLAGSTONES.register();
		POLISHED_GILDED_BLACKSTONE.register();
		POLISHED_GILDED_BLACKSTONE_BRICKS.register();
		CRACKED_POLISHED_GILDED_BLACKSTONE_BRICKS.register();
		POLISHED_GILDED_BLACKSTONE_TILES.register();
		POLISHED_GILDED_BLACKSTONE_FLAGSTONES.register();
		mod.register(Registries.BLOCK, "chiseled_gilded_blackstone", CHISELED_GILDED_BLACKSTONE);
		mod.register(Registries.ITEM, "chiseled_gilded_blackstone", CHISELED_GILDED_BLACKSTONE.asItem());
		PAVEMENT.register();
		WARM_PAVEMENT.register();
		ORNATE_PAVEMENT.register();
		WARM_ORNATE_PAVEMENT.register();
		MOSSY_PAVEMENT.register();
		MOSSY_WARM_PAVEMENT.register();
		MOSSY_ORNATE_PAVEMENT.register();
		MOSSY_WARM_ORNATE_PAVEMENT.register();
		MIXED_BRICKS.register();
		ALIGNED_MIXED_BRICKS.register();
		ALIGNED_WARM_MIXED_BRICKS.register();
		CORK.register();
		BLOOMS_WALLPAPER.register();
		FEATHERS_WALLPAPER.register();
		LEAVES_WALLPAPER.register();
		BLACK_MARBLE.register();
		SMOOTH_BLACK_MARBLE.register();
		BLACK_MARBLE_BRICKS.register();
		CRACKED_BLACK_MARBLE_BRICKS.register();
		BLACK_MARBLE_FLAGSTONES.register();
		BLACK_MARBLE_TILES.register();
		mod.register(Registries.BLOCK, "chiseled_black_marble", CHISELED_BLACK_MARBLE);
		mod.register(Registries.ITEM, "chiseled_black_marble", CHISELED_BLACK_MARBLE.asItem());
		WHITE_MARBLE.register();
		SMOOTH_WHITE_MARBLE.register();
		WHITE_MARBLE_BRICKS.register();
		CRACKED_WHITE_MARBLE_BRICKS.register();
		WHITE_MARBLE_FLAGSTONES.register();
		WHITE_MARBLE_TILES.register();
		mod.register(Registries.BLOCK, "chiseled_white_marble", CHISELED_WHITE_MARBLE);
		mod.register(Registries.ITEM, "chiseled_white_marble", CHISELED_WHITE_MARBLE.asItem());
		VERDANT_MARBLE.register();
		SMOOTH_VERDANT_MARBLE.register();
		VERDANT_MARBLE_BRICKS.register();
		CRACKED_VERDANT_MARBLE_BRICKS.register();
		VERDANT_MARBLE_FLAGSTONES.register();
		VERDANT_MARBLE_TILES.register();
		mod.register(Registries.BLOCK, "chiseled_verdant_marble", CHISELED_VERDANT_MARBLE);
		mod.register(Registries.ITEM, "chiseled_verdant_marble", CHISELED_VERDANT_MARBLE.asItem());
	}
}
