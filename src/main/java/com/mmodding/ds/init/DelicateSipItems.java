package com.mmodding.ds.init;

import com.mmodding.ds.DelicateSip;
import com.mmodding.ds.item.ScrewdriverItem;
import com.mmodding.library.core.api.AdvancedContainer;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ToolMaterial;

import java.util.function.Function;

public class DelicateSipItems {

	public static final Item WOODEN_SCREWDRIVER = register("wooden_screwdriver", ScrewdriverItem::new, new Item.Properties().stacksTo(1).durability(ToolMaterial.WOOD.durability()));
	public static final Item STONE_SCREWDRIVER = register("stone_screwdriver", ScrewdriverItem::new, new Item.Properties().stacksTo(1).durability(ToolMaterial.STONE.durability()));
	public static final Item COPPER_SCREWDRIVER = register("copper_screwdriver", ScrewdriverItem::new, new Item.Properties().stacksTo(1).durability(ToolMaterial.COPPER.durability()));
	public static final Item SCREWDRIVER = register("screwdriver", ScrewdriverItem::new, new Item.Properties().stacksTo(1).durability(ToolMaterial.IRON.durability()));
	public static final Item DIAMOND_SCREWDRIVER = register("diamond_screwdriver", ScrewdriverItem::new, new Item.Properties().stacksTo(1).durability(ToolMaterial.DIAMOND.durability()));
	public static final Item NETHERITE_SCREWDRIVER = register("netherite_screwdriver", ScrewdriverItem::new, new Item.Properties().stacksTo(1).durability(ToolMaterial.NETHERITE.durability()));

	private static Item register(String path, Item.Properties properties) {
		return register(path, Item::new, properties);
	}

	private static Item register(String path, Function<Item.Properties, Item> factory, Item.Properties properties) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, DelicateSip.createId(path));
		return Items.registerItem(key, factory, properties);
	}

	public static void register(AdvancedContainer mod) {}
}
