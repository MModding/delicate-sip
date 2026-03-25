package com.mmodding.ds;

import com.mmodding.ds.init.DelicateSipBlocks;
import com.mmodding.library.core.api.AdvancedContainer;
import com.mmodding.library.core.api.ExtendedModInitializer;
import com.mmodding.library.core.api.management.ElementsManager;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.BlockSetType;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Set;

public class DelicateSip implements ExtendedModInitializer {

	public static final Set<String> WOOD_SETS = Set.of("acacia", "bamboo", "birch", "cherry", "dark_oak", "mangrove", "oak", /* "pale_oak", */ "spruce");

	public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.displayName(Text.of("Delicate Sip"))
			.icon(() -> Registries.ITEM.get(Identifier.of("delicate_sip", "acacia_lattice")).getDefaultStack())
			.entries((ctx, entries) -> Registries.ITEM.stream().filter(item -> Registries.ITEM.getId(item).getNamespace().equals(DelicateSip.namespace())).forEachOrdered(entries::add))
			.build();

	@Override
	public void setupManager(ElementsManager manager) {
		manager.content(DelicateSipBlocks::register);
	}

	@Override
	public void onInitialize(AdvancedContainer mod) {
		mod.logger().info("Shaping the world with a Delicate Sip of your imagination!");

		Registry.register(Registries.ITEM_GROUP, Identifier.of("delicate_sip", "item_group"), DelicateSip.ITEM_GROUP);
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
