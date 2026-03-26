package com.mmodding.ds.init;

import com.mmodding.ds.item.ScrewdriverItem;
import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;

public class DelicateSipItems {

	public static final ScrewdriverItem WOODEN_SCREWDRIVER = new ScrewdriverItem(ToolMaterials.WOOD, new FabricItemSettings().maxCount(1));
	public static final ScrewdriverItem STONE_SCREWDRIVER = new ScrewdriverItem(ToolMaterials.STONE, new FabricItemSettings().maxCount(1));
	// public static final ScrewdriverItem COPPER_SCREWDRIVER = new ScrewdriverItem(ToolMaterials.COPPER, new FabricItemSettings().maxCount(1));
	public static final ScrewdriverItem SCREWDRIVER = new ScrewdriverItem(ToolMaterials.IRON, new FabricItemSettings().maxCount(1));
	public static final ScrewdriverItem DIAMOND_SCREWDRIVER = new ScrewdriverItem(ToolMaterials.DIAMOND, new FabricItemSettings().maxCount(1));
	public static final ScrewdriverItem NETHERITE_SCREWDRIVER = new ScrewdriverItem(ToolMaterials.NETHERITE, new FabricItemSettings().maxCount(1));

	public static void register(AdvancedContainer mod) {
		mod.register(Registries.ITEM, factory -> {
			factory.register("wooden_screwdriver", WOODEN_SCREWDRIVER);
			factory.register("stone_screwdriver", STONE_SCREWDRIVER);
			factory.register("screwdriver", SCREWDRIVER);
			factory.register("diamond_screwdriver", DIAMOND_SCREWDRIVER);
			factory.register("netherite_screwdriver", NETHERITE_SCREWDRIVER);
		});
	}
}
