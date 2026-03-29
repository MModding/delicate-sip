package com.mmodding.ds.init;

import com.mmodding.ds.DelicateSip;
import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;

import java.util.function.Predicate;

public class DelicateSipItemGroups {

	public static final ItemGroup WOODWORK = DelicateSipItemGroups.createDelicateSipItemGroup("woodwork", "cherry_wainscoting", path -> !DelicateSip.WOOD_SETS.stream().filter(path::contains).toList().isEmpty());
	public static final ItemGroup STONEWORK = DelicateSipItemGroups.createDelicateSipItemGroup("stonework", "chiseled_black_marble", path -> DelicateSip.WOOD_SETS.stream().filter(path::contains).toList().isEmpty() && !path.contains("wallpaper") && !path.contains("screwdriver"));
	public static final ItemGroup FURNITURE = DelicateSipItemGroups.createDelicateSipItemGroup("furniture", "blooms_wallpaper", path -> path.contains("wallpaper"));
	public static final ItemGroup MISCELLANEOUS = DelicateSipItemGroups.createDelicateSipItemGroup("miscellaneous", "screwdriver", path -> path.contains("screwdriver"));

	private static ItemGroup createDelicateSipItemGroup(String category, String icon, Predicate<String> filter) {
		return FabricItemGroup.builder()
			.displayName(Text.translatable("itemGroup.delicate_sip." + category))
			.icon(() -> Registries.ITEM.get(DelicateSip.createId(icon)).getDefaultStack())
			.entries(
				(ctx, entries) -> Registries.ITEM.stream()
					.filter(
						item -> Registries.ITEM.getId(item)
							.getNamespace()
							.equals(DelicateSip.namespace())
					)
					.filter(
						item -> filter.test(Registries.ITEM.getId(item).getPath())
					)
					.forEachOrdered(entries::add)
			)
			.build();
	}

	public static void register(AdvancedContainer mod) {
		mod.register(Registries.ITEM_GROUP, factory -> {
			factory.register("woodwork", WOODWORK);
			factory.register("stonework", STONEWORK);
			factory.register("furniture", FURNITURE);
			factory.register("miscellaneous", MISCELLANEOUS);
		});
	}
}
