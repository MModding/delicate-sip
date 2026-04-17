package com.mmodding.ds.init;

import com.mmodding.ds.DelicateSip;
import com.mmodding.ds.block.RockFoundryBlock;
import com.mmodding.ds.block.RoundWindowBlock;
import com.mmodding.ds.block.RoundWindowPaneBlock;
import com.mmodding.library.block.api.util.BlockFactory;
import com.mmodding.library.block.api.wrapper.BlockHeap;
import com.mmodding.library.block.api.wrapper.BlockRelatives;
import com.mmodding.library.core.api.AdvancedContainer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class DelicateSipBlocks {

	public static final Block ROCK_FOUNDRY = register("rock_foundry", RockFoundryBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.FURNACE)).registerItem();

	public static final BlockHeap BEAMS = BlockHeap.register(Block::new, wood -> wood + "_beam", DelicateSipBlocks::createWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap LATTICES = BlockHeap.register(LadderBlock::new, wood -> wood + "_lattice", DelicateSipBlocks::createNonOpaqueWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap NARROW_WINDOWS = BlockHeap.register(TransparentBlock::new, wood -> wood + "_narrow_windows", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap NARROW_WINDOWS_PANES = BlockHeap.register(IronBarsBlock::new, wood -> wood + "_narrow_windows_pane", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap PARQUETS = BlockHeap.register(Block::new, wood -> wood + "_parquet", DelicateSipBlocks::createWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap ROUND_WINDOWS = BlockHeap.register(RoundWindowBlock::new, wood -> wood + "_round_window", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap ROUND_WINDOW_PANES = BlockHeap.register(RoundWindowPaneBlock::new, wood -> wood + "_round_window_pane", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap TILES = BlockHeap.register(Block::new, wood -> wood + "_tiles", DelicateSipBlocks::createWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap WAINSCOTINGS = BlockHeap.register(Block::new, wood -> wood + "_wainscoting", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap WINDOWS = BlockHeap.register(TransparentBlock::new, wood -> wood + "_window", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap WINDOW_PANES = BlockHeap.register(IronBarsBlock::new, wood -> wood + "_window_pane", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap WINDOW_TILES = BlockHeap.register(TransparentBlock::new, wood -> wood + "_window_tiles", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap WINDOW_TILE_PANES = BlockHeap.register(IronBarsBlock::new, wood -> wood + "_window_tile_pane", DelicateSipBlocks::createTransparentWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap CUT_BLOCKS = BlockHeap.register(Block::new, wood -> "cut_" + wood + "_block", DelicateSipBlocks::createWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap CLOSET_DOORS = BlockHeap.register((wood, properties) -> new DoorBlock(DelicateSip.WOOD_SET_TYPES.get(wood), properties), wood -> "closet_" + wood + "_door", DelicateSipBlocks::createWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap CLOSET_TRAPDOORS = BlockHeap.register((wood, properties) -> new TrapDoorBlock(DelicateSip.WOOD_SET_TYPES.get(wood), properties), wood -> "closet_" + wood + "_trapdoor", DelicateSipBlocks::createWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap PLAIN_DOORS = BlockHeap.register((wood, properties) -> new DoorBlock(DelicateSip.WOOD_SET_TYPES.get(wood), properties), wood -> "plain_" + wood + "_door", DelicateSipBlocks::createWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap PLAIN_TRAPDOORS = BlockHeap.register((wood, properties) -> new TrapDoorBlock(DelicateSip.WOOD_SET_TYPES.get(wood), properties), wood -> "plain_" + wood + "_trapdoor", DelicateSipBlocks::createWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap SPLIT_DOORS = BlockHeap.register((wood, properties) -> new DoorBlock(DelicateSip.WOOD_SET_TYPES.get(wood), properties), wood -> "split_" + wood + "_door", DelicateSipBlocks::createWoodSettings, DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap WAXED_DOORS = BlockHeap.register((wood, properties) -> new DoorBlock(DelicateSip.WOOD_SET_TYPES.get(wood), properties), wood -> "waxed_" + wood + "_door", wood -> DelicateSipBlocks.createNonOpaqueWoodSettings(wood).sound(DelicateSipSoundTypes.WAXED_WOOD), DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();
	public static final BlockHeap WAXED_TRAPDOORS = BlockHeap.register((wood, properties) -> new TrapDoorBlock(DelicateSip.WOOD_SET_TYPES.get(wood), properties), wood -> "waxed_" + wood + "_trapdoor", wood -> DelicateSipBlocks.createNonOpaqueWoodSettings(wood).sound(DelicateSipSoundTypes.WAXED_WOOD), DelicateSip.namespace(), DelicateSip.WOOD_SETS).registerBlockItems();

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
	public static final Block CHISELED_GILDED_BLACKSTONE = register("chiseled_gilded_blackstone", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BLACK)).registerItem();

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

	public static final BlockRelatives BLOOMS_WALLPAPER = BlockRelatives.createStone(DelicateSip.createId("blooms_wallpaper"), settings -> settings.sound(SoundType.CHERRY_LEAVES), false, false);
	public static final BlockRelatives FEATHERS_WALLPAPER = BlockRelatives.createStone(DelicateSip.createId("feathers_wallpaper"), settings -> settings.sound(SoundType.CHERRY_LEAVES), false, false);
	public static final BlockRelatives LEAVES_WALLPAPER = BlockRelatives.createStone(DelicateSip.createId("leaves_wallpaper"), settings -> settings.sound(SoundType.CHERRY_LEAVES), false, false);

	public static final BlockRelatives BLACK_MARBLE = BlockRelatives.createStone(DelicateSip.createId("black_marble"), settings -> settings.mapColor(DyeColor.BLACK), true, false);
	public static final BlockRelatives SMOOTH_BLACK_MARBLE = BlockRelatives.createStone(DelicateSip.createId("smooth_black_marble"), settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives BLACK_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("black_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CRACKED_BLACK_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("cracked_black_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives BLACK_MARBLE_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("black_marble_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives BLACK_MARBLE_TILES = BlockRelatives.createStone(DelicateSip.createId("black_marble_tile"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final Block CHISELED_BLACK_MARBLE = register("chiseled_black_marble", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BLACK)).registerItem();

	public static final BlockRelatives WHITE_MARBLE = BlockRelatives.createStone(DelicateSip.createId("white_marble"), settings -> settings.mapColor(DyeColor.WHITE), true, false);
	public static final BlockRelatives SMOOTH_WHITE_MARBLE = BlockRelatives.createStone(DelicateSip.createId("smooth_white_marble"), settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives WHITE_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("white_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CRACKED_WHITE_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("cracked_white_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives WHITE_MARBLE_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("white_marble_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives WHITE_MARBLE_TILES = BlockRelatives.createStone(DelicateSip.createId("white_marble_tile"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final Block CHISELED_WHITE_MARBLE = register("chiseled_white_marble", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BLACK)).registerItem();

	public static final BlockRelatives VERDANT_MARBLE = BlockRelatives.createStone(DelicateSip.createId("verdant_marble"), settings -> settings.mapColor(DyeColor.GREEN), true, false);
	public static final BlockRelatives SMOOTH_VERDANT_MARBLE = BlockRelatives.createStone(DelicateSip.createId("smooth_verdant_marble"), settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives VERDANT_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("verdant_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives CRACKED_VERDANT_MARBLE_BRICKS = BlockRelatives.createStone(DelicateSip.createId("cracked_verdant_marble_brick"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives VERDANT_MARBLE_FLAGSTONES = BlockRelatives.createStone(DelicateSip.createId("verdant_marble_flagstone"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final BlockRelatives VERDANT_MARBLE_TILES = BlockRelatives.createStone(DelicateSip.createId("verdant_marble_tile"), true, settings -> settings.mapColor(DyeColor.BLACK), false, false);
	public static final Block CHISELED_VERDANT_MARBLE = register("chiseled_verdant_marble", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).mapColor(DyeColor.BLACK)).registerItem();

	public static BlockBehaviour.Properties createWoodSettings(String wood) {
		return switch (wood) {
			case "acacia" -> BlockBehaviour.Properties.ofFullCopy(Blocks.ACACIA_PLANKS);
			case "bamboo" -> BlockBehaviour.Properties.ofFullCopy(Blocks.BAMBOO_PLANKS);
			case "birch" -> BlockBehaviour.Properties.ofFullCopy(Blocks.BIRCH_PLANKS);
			case "cherry" -> BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS);
			case "dark_oak" -> BlockBehaviour.Properties.ofFullCopy(Blocks.DARK_OAK_PLANKS);
			case "mangrove" -> BlockBehaviour.Properties.ofFullCopy(Blocks.MANGROVE_PLANKS);
			case "oak" -> BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS);
			case "pale_oak" -> BlockBehaviour.Properties.ofFullCopy(Blocks.PALE_OAK_PLANKS);
			case "spruce" -> BlockBehaviour.Properties.ofFullCopy(Blocks.SPRUCE_PLANKS);
			default -> throw new IllegalStateException(wood + " is not a valid wood type");
		};
	}

	public static BlockBehaviour.Properties createNonOpaqueWoodSettings(String wood) {
		return DelicateSipBlocks.createWoodSettings(wood).noOcclusion();
	}

	public static BlockBehaviour.Properties createTransparentWoodSettings(String wood) {
		return DelicateSipBlocks.createNonOpaqueWoodSettings(wood).isValidSpawn(Blocks::never).forceSolidOff().isSuffocating(Blocks::never).isViewBlocking(Blocks::never);
	}

	private static Block register(String path, BlockBehaviour.Properties properties) {
		return register(path, Block::new, properties);
	}

	private static <T extends Block>Block register(String path, BlockFactory<T> factory, BlockBehaviour.Properties properties) {
		return Blocks.register(ResourceKey.create(Registries.BLOCK, DelicateSip.createId(path)), factory::make, properties);
	}

	public static void register(AdvancedContainer mod) {}
}
