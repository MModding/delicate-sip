package com.mmodding.ds.init;

import com.mmodding.ds.DelicateSip;
import com.mmodding.ds.block.RoundWindowBlock;
import com.mmodding.ds.block.RoundWindowPaneBlock;
import com.mmodding.library.block.api.wrapper.BlockHeap;
import com.mmodding.library.block.api.wrapper.BlockRelatives;
import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.util.DyeColor;

public class DelicateSipBlocks {

	public static final BlockHeap BEAMS = BlockHeap.create(DelicateSip.createId("beams"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD), DelicateSip.fromWood("beam")).withItem(new FabricItemSettings());
	public static final BlockHeap LATTICES = BlockHeap.create(DelicateSip.createId("lattices"), LadderBlock::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque(), DelicateSip.fromWood("lattice")).withItem(new FabricItemSettings());
	public static final BlockHeap NARROW_WINDOWS = BlockHeap.create(DelicateSip.createId("narrow_windows"), GlassBlock::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("narrow_windows")).withItem(new FabricItemSettings());
	public static final BlockHeap NARROW_WINDOWS_PANES = BlockHeap.create(DelicateSip.createId("narrow_windows_panes"), PaneBlock::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("narrow_windows_pane")).withItem(new FabricItemSettings());
	public static final BlockHeap PARQUETS = BlockHeap.create(DelicateSip.createId("parquets"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD), DelicateSip.fromWood("parquet")).withItem(new FabricItemSettings());
	public static final BlockHeap ROUND_WINDOWS = BlockHeap.create(DelicateSip.createId("round_windows"), RoundWindowBlock::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("round_window")).withItem(new FabricItemSettings());
	public static final BlockHeap ROUND_WINDOW_PANES = BlockHeap.create(DelicateSip.createId("round_window_panes"), RoundWindowPaneBlock::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("round_window_pane")).withItem(new FabricItemSettings());
	public static final BlockHeap TILES = BlockHeap.create(DelicateSip.createId("tiles"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD), DelicateSip.fromWood("tiles")).withItem(new FabricItemSettings());
	public static final BlockHeap WAINSCOTINGS = BlockHeap.create(DelicateSip.createId("wainscotings"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD), DelicateSip.fromWood("wainscoting")).withItem(new FabricItemSettings());
	public static final BlockHeap WINDOWS = BlockHeap.create(DelicateSip.createId("windows"), GlassBlock::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("window")).withItem(new FabricItemSettings());
	public static final BlockHeap WINDOW_PANES = BlockHeap.create(DelicateSip.createId("window_panes"), PaneBlock::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("window_pane")).withItem(new FabricItemSettings());
	public static final BlockHeap WINDOW_TILES = BlockHeap.create(DelicateSip.createId("window_tiles"), GlassBlock::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("window_tiles")).withItem(new FabricItemSettings());
	public static final BlockHeap WINDOW_TILE_PANES = BlockHeap.create(DelicateSip.createId("window_tile_panes"), PaneBlock::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("window_tile_pane")).withItem(new FabricItemSettings());
	public static final BlockHeap CUT_BLOCKS = BlockHeap.create(DelicateSip.createId("cut_blocks"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD), DelicateSip.fromWood("cut", "block")).withItem(new FabricItemSettings());
	public static final BlockHeap CLOSET_DOORS = BlockHeap.create(DelicateSip.createId("closet_doors"), (name, settings) -> new DoorBlock(settings, DelicateSip.getVanillaSet("closet", name, "door")), FabricBlockSettings.copyOf(Blocks.OAK_WOOD), DelicateSip.fromWood("closet", "door")).withItem(new FabricItemSettings());
	public static final BlockHeap PLAIN_DOORS = BlockHeap.create(DelicateSip.createId("plain_doors"), (name, settings) -> new DoorBlock(settings, DelicateSip.getVanillaSet("plain", name, "door")), FabricBlockSettings.copyOf(Blocks.OAK_WOOD), DelicateSip.fromWood("plain", "door")).withItem(new FabricItemSettings());
	public static final BlockHeap SPLIT_DOORS = BlockHeap.create(DelicateSip.createId("split_doors"), (name, settings) -> new DoorBlock(settings, DelicateSip.getVanillaSet("split", name, "door")), FabricBlockSettings.copyOf(Blocks.OAK_WOOD), DelicateSip.fromWood("split", "door")).withItem(new FabricItemSettings());

	public static final BlockRelatives BASALT_BRICKS = BlockRelatives.createStone(DelicateSip.createId("basalt_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CRACKED_BASALT_BRICKS = BlockRelatives.createStone(DelicateSip.createId("cracked_basalt_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives BASALT_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("basalt_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives BASALT_TILES = BlockRelatives.createStone(DelicateSip.createId("basalt_tile"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CHISELED_BASALT = BlockRelatives.createStone(DelicateSip.createId("chiseled_basalt"), settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives POLISHED_BASALT = BlockRelatives.createStone(DelicateSip.createId("polished_basalt"), settings -> settings.mapColor(DyeColor.BLACK), false, false);

	public static final BlockRelatives MIXED_BRICKS = BlockRelatives.createStone(DelicateSip.createId("mixed_brick"), true, settings -> settings.mapColor(DyeColor.WHITE), false, false);
	public static final BlockRelatives ALIGNED_MIXED_BRICKS = BlockRelatives.createStone(DelicateSip.createId("aligned_mixed_brick"), true, settings -> settings.mapColor(DyeColor.WHITE), false, false);
	public static final BlockRelatives ALIGNED_WARM_MIXED_BRICKS = BlockRelatives.createStone(DelicateSip.createId("aligned_warm_mixed_brick"), true, settings -> settings.mapColor(DyeColor.WHITE), false, false);

	public static final BlockRelatives DEEPSLATE_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("deepslate_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);

	public static final BlockRelatives BLACK_MARBLE = BlockRelatives.createStone(DelicateSip.createId("black_marble"), settings -> settings.mapColor(DyeColor.BLACK), true, false);
	public static final BlockRelatives SMOOTH_BLACK_MARBLE = BlockRelatives.createStone(DelicateSip.createId("smooth_black_marble"), settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives BLACK_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("black_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CRACKED_BLACK_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("cracked_black_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives BLACK_MARBLE_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("black_marble_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives BLACK_MARBLE_TILES = BlockRelatives.createStone(DelicateSip.createId("black_marble_tile"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CHISELED_BLACK_MARBLE = BlockRelatives.createStone(DelicateSip.createId("chiseled_black_marble"), settings -> settings.mapColor(DyeColor.BLACK), false, false);

	public static final BlockRelatives WHITE_MARBLE = BlockRelatives.createStone(DelicateSip.createId("white_marble"), settings -> settings.mapColor(DyeColor.WHITE), true, false);
	public static final BlockRelatives SMOOTH_WHITE_MARBLE = BlockRelatives.createStone(DelicateSip.createId("smooth_white_marble"), settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives WHITE_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("white_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CRACKED_WHITE_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("cracked_white_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives WHITE_MARBLE_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("white_marble_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives WHITE_MARBLE_TILES = BlockRelatives.createStone(DelicateSip.createId("white_marble_tile"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CHISELED_WHITE_MARBLE = BlockRelatives.createStone(DelicateSip.createId("chiseled_white_marble"), settings -> settings.mapColor(DyeColor.BLACK), false, false);

	public static final BlockRelatives VERDANT_MARBLE = BlockRelatives.createStone(DelicateSip.createId("verdant_marble"), settings -> settings.mapColor(DyeColor.GREEN), true, false);
	public static final BlockRelatives SMOOTH_VERDANT_MARBLE = BlockRelatives.createStone(DelicateSip.createId("smooth_verdant_marble"), settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives VERDANT_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("verdant_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CRACKED_VERDANT_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("cracked_verdant_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives VERDANT_MARBLE_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("verdant_marble_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives VERDANT_MARBLE_TILES = BlockRelatives.createStone(DelicateSip.createId("verdant_marble_tile"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CHISELED_VERDANT_MARBLE = BlockRelatives.createStone(DelicateSip.createId("chiseled_verdant_marble"), settings -> settings.mapColor(DyeColor.BLACK), false, false);

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
		PLAIN_DOORS.register(mod::createId);
		SPLIT_DOORS.register(mod::createId);
		BASALT_BRICKS.register();
		BASALT_FLAGSTONES.register();
		BASALT_TILES.register();
		CHISELED_BASALT.register();
		CRACKED_BASALT_BRICKS.register();
		POLISHED_BASALT.register();
		MIXED_BRICKS.register();
		ALIGNED_MIXED_BRICKS.register();
		ALIGNED_WARM_MIXED_BRICKS.register();
		DEEPSLATE_FLAGSTONES.register();
		BLACK_MARBLE.register();
		SMOOTH_BLACK_MARBLE.register();
		BLACK_MARBLE_BRICKS.register();
		CRACKED_BLACK_MARBLE_BRICKS.register();
		BLACK_MARBLE_FLAGSTONES.register();
		BLACK_MARBLE_TILES.register();
		CHISELED_BLACK_MARBLE.register();
		WHITE_MARBLE.register();
		SMOOTH_WHITE_MARBLE.register();
		WHITE_MARBLE_BRICKS.register();
		CRACKED_WHITE_MARBLE_BRICKS.register();
		WHITE_MARBLE_FLAGSTONES.register();
		WHITE_MARBLE_TILES.register();
		CHISELED_WHITE_MARBLE.register();
		VERDANT_MARBLE.register();
		SMOOTH_VERDANT_MARBLE.register();
		VERDANT_MARBLE_BRICKS.register();
		CRACKED_VERDANT_MARBLE_BRICKS.register();
		VERDANT_MARBLE_FLAGSTONES.register();
		VERDANT_MARBLE_TILES.register();
		CHISELED_VERDANT_MARBLE.register();
	}
}
