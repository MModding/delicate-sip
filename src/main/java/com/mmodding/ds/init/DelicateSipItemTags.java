package com.mmodding.ds.init;

import com.mmodding.ds.DelicateSip;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class DelicateSipItemTags {

	public static final TagKey<Item> ROCK_FOUNDRY_AFFECTED = create("rock_foundry_affected");

	private static TagKey<Item> create(String path) {
		return new TagKey<>(Registries.ITEM, DelicateSip.createId(path));
	};
}
