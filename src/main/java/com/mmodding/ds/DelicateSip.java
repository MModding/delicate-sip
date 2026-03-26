package com.mmodding.ds;

import com.mmodding.ds.init.DelicateSipBlocks;
import com.mmodding.ds.init.DelicateSipItemGroups;
import com.mmodding.ds.init.DelicateSipItems;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.core.api.ExtendedModInitializer;
import com.mmodding.library.core.api.management.ElementsManager;
import net.minecraft.block.BlockSetType;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Set;

public class DelicateSip implements ExtendedModInitializer {

	public static final Set<String> WOOD_SETS = Set.of("acacia", "bamboo", "birch", "cherry", "dark_oak", "mangrove", "oak", /* "pale_oak", */ "spruce");

	@Override
	public void setupManager(ElementsManager manager) {
		manager.content(DelicateSipBlocks::register);
		manager.content(DelicateSipItems::register);
		manager.content(DelicateSipItemGroups::register);
	}

	@Override
	public void onInitialize(AdvancedContainer mod) {
		mod.logger().info("Shaping the world with a Delicate Sip of your imagination!");
	}

	public static List<String> fromWood(String suffix) {
		return DelicateSip.WOOD_SETS.stream().map(name -> name + "_" + suffix).toList();
	}

	public static List<String> fromWood(String prefix, String suffix) {
		return DelicateSip.WOOD_SETS.stream().map(name -> prefix + "_" + name + "_" + suffix).toList();
	}

	public static BlockSetType getVanillaSet(String name, String suffixToRemove) {
		return BlockSetType.stream()
			.filter(type -> type.name().equals(name.replace("_" + suffixToRemove, "")))
			.findFirst()
			.orElseThrow();
	}

	public static BlockSetType getVanillaSet(String prefixToRemove, String name, String suffixToRemove) {
		return BlockSetType.stream()
			.filter(type -> type.name().equals(name.replace(prefixToRemove + "_", "").replace("_" + suffixToRemove, "")))
			.findFirst()
			.orElseThrow();
	}

	public static Identifier createId(String path) {
		return Identifier.of(DelicateSip.namespace(), path);
	}

	public static String namespace() {
		return "delicate_sip";
	}
}
