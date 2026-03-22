package com.mmodding.ds.init;

import com.mmodding.ds.DelicateSip;
import com.mmodding.library.block.api.wrapper.BlockHeap;
import com.mmodding.library.block.api.wrapper.BlockRelatives;
import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LadderBlock;
import net.minecraft.util.DyeColor;

public class DelicateSipBlocks {

	public static final BlockHeap<Block> BEAMS = BlockHeap.create(DelicateSip.createId("beams"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD), DelicateSip.fromWood("beam")).withItem(new FabricItemSettings());
	public static final BlockHeap<LadderBlock> LATTICES = BlockHeap.create(DelicateSip.createId("lattices"), LadderBlock::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque(), DelicateSip.fromWood("lattice")).withItem(new FabricItemSettings());
	public static final BlockHeap<Block> NARROW_WINDOWS = BlockHeap.create(DelicateSip.createId("narrow_windows"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("narrow_windows")).withItem(new FabricItemSettings());
	public static final BlockHeap<Block> PARQUETS = BlockHeap.create(DelicateSip.createId("parquets"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD), DelicateSip.fromWood("parquet")).withItem(new FabricItemSettings());
	public static final BlockHeap<Block> ROUND_WINDOWS_BOTTOM_LEFT = BlockHeap.create(DelicateSip.createId("round_windows_bottom_left"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("round_window_bottom_left")).withItem(new FabricItemSettings());
	public static final BlockHeap<Block> ROUND_WINDOWS_BOTTOM_RIGHT = BlockHeap.create(DelicateSip.createId("round_windows_bottom_right"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("round_window_bottom_right")).withItem(new FabricItemSettings());
	public static final BlockHeap<Block> ROUND_WINDOWS_TOP_LEFT = BlockHeap.create(DelicateSip.createId("round_windows_top_left"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("round_window_top_left")).withItem(new FabricItemSettings());
	public static final BlockHeap<Block> ROUND_WINDOWS_TOP_RIGHT = BlockHeap.create(DelicateSip.createId("round_windows_top_right"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("round_window_top_right")).withItem(new FabricItemSettings());
	public static final BlockHeap<Block> TILES = BlockHeap.create(DelicateSip.createId("tiles"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD), DelicateSip.fromWood("tiles")).withItem(new FabricItemSettings());
	public static final BlockHeap<Block> WAINSCOTINGS = BlockHeap.create(DelicateSip.createId("wainscotings"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD), DelicateSip.fromWood("wainscoting")).withItem(new FabricItemSettings());
	public static final BlockHeap<Block> WINDOWS = BlockHeap.create(DelicateSip.createId("windows"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("window")).withItem(new FabricItemSettings());
	public static final BlockHeap<Block> WINDOW_TILES = BlockHeap.create(DelicateSip.createId("window_tiles"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD).nonOpaque().allowsSpawning(Blocks::never).solidBlock(Blocks::never).suffocates(Blocks::never).blockVision(Blocks::never), DelicateSip.fromWood("window_tiles")).withItem(new FabricItemSettings());
	public static final BlockHeap<Block> CUT_BLOCKS = BlockHeap.create(DelicateSip.createId("cut_blocks"), Block::new, FabricBlockSettings.copyOf(Blocks.OAK_WOOD), DelicateSip.fromWood("cut", "block")).withItem(new FabricItemSettings());

	public static final BlockRelatives BLACK_MARBLE = BlockRelatives.createStone(DelicateSip.createId("black_marble"), settings -> settings.mapColor(DyeColor.BLACK), true);
	public static final BlockRelatives WHITE_MARBLE = BlockRelatives.createStone(DelicateSip.createId("white_marble"), settings -> settings.mapColor(DyeColor.WHITE), true);
	public static final BlockRelatives VERDANT_MARBLE = BlockRelatives.createStone(DelicateSip.createId("verdant_marble"), settings -> settings.mapColor(DyeColor.GREEN), true);

	public static void register(AdvancedContainer mod) {
		BEAMS.register(mod::createId);
		LATTICES.register(mod::createId);
		NARROW_WINDOWS.register(mod::createId);
		PARQUETS.register(mod::createId);
		ROUND_WINDOWS_BOTTOM_LEFT.register(mod::createId);
		ROUND_WINDOWS_BOTTOM_RIGHT.register(mod::createId);
		ROUND_WINDOWS_TOP_LEFT.register(mod::createId);
		ROUND_WINDOWS_TOP_RIGHT.register(mod::createId);
		TILES.register(mod::createId);
		WAINSCOTINGS.register(mod::createId);
		WINDOWS.register(mod::createId);
		WINDOW_TILES.register(mod::createId);
		CUT_BLOCKS.register(mod::createId);
		BLACK_MARBLE.register();
		WHITE_MARBLE.register();
		VERDANT_MARBLE.register();
	}
}
