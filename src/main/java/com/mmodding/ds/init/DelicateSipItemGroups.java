package com.mmodding.ds.init;

import com.mmodding.ds.DelicateSip;
import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Predicate;

public class DelicateSipItemGroups {

	public static final CreativeModeTab WOODWORK = DelicateSipItemGroups.createDelicateSipItemGroup("woodwork", "cherry_wainscoting", path -> !DelicateSip.WOOD_SETS.stream().filter(path::contains).toList().isEmpty());
	public static final CreativeModeTab STONEWORK = DelicateSipItemGroups.createDelicateSipItemGroup("stonework", "chiseled_black_marble", path -> DelicateSip.WOOD_SETS.stream().filter(path::contains).toList().isEmpty() && !path.contains("wallpaper") && !path.contains("screwdriver"));
	public static final CreativeModeTab FURNITURE = DelicateSipItemGroups.createDelicateSipItemGroup("furniture", "blooms_wallpaper", path -> path.contains("wallpaper"));
	public static final CreativeModeTab MISCELLANEOUS = DelicateSipItemGroups.createDelicateSipItemGroup("miscellaneous", "screwdriver", path -> path.contains("screwdriver"));

	private static CreativeModeTab createDelicateSipItemGroup(String category, String icon, Predicate<String> filter) {
		return FabricCreativeModeTab.builder()
			.title(Component.translatable("itemGroup.delicate_sip." + category))
			.icon(() -> BuiltInRegistries.ITEM.getValue(DelicateSip.createId(icon)).getDefaultInstance())
			.displayItems(
				(ctx, entries) -> BuiltInRegistries.ITEM.stream()
					.filter(
						item -> BuiltInRegistries.ITEM.getKey(item)
							.getNamespace()
							.equals(DelicateSip.namespace())
					)
					.filter(
						item -> filter.test(BuiltInRegistries.ITEM.getKey(item).getPath())
					)
					.forEachOrdered(entries::accept)
			)
			.build();
	}

	public static void register(AdvancedContainer mod) {
		mod.register(BuiltInRegistries.CREATIVE_MODE_TAB, factory -> {
			factory.register("woodwork", WOODWORK);
			factory.register("stonework", STONEWORK);
			factory.register("furniture", FURNITURE);
			factory.register("miscellaneous", MISCELLANEOUS);
		});
	}
}
