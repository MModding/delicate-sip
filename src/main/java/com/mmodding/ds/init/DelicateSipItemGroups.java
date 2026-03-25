package com.mmodding.ds.init;

import com.mmodding.ds.DelicateSip;
import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;

import java.util.function.Predicate;

public class DelicateSipItemGroups {

	public static final ItemGroup METAL = DelicateSipItemGroups.createDelicateSipItemGroup("metal", "cast_iron_block", path -> path.contains("iron") || path.contains("gold"));
	public static final ItemGroup STONE = DelicateSipItemGroups.createDelicateSipItemGroup("stone", "chiseled_black_marble", path -> DelicateSip.WOOD_SETS.stream().filter(path::contains).toList().isEmpty() && !path.contains("iron") && !path.contains("gold"));
	public static final ItemGroup WOOD = DelicateSipItemGroups.createDelicateSipItemGroup("wood", "cherry_wainscoting", path -> !DelicateSip.WOOD_SETS.stream().filter(path::contains).toList().isEmpty());

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
			factory.register("metal", METAL);
			factory.register("stone", STONE);
			factory.register("wood", WOOD);
		});
	}
}
