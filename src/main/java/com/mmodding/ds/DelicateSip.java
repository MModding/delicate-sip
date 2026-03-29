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
import java.util.Map;

public class DelicateSip implements ExtendedModInitializer {

	public static final List<String> WOOD_SETS = List.of("acacia", "bamboo", "birch", "cherry", "dark_oak", "mangrove", "oak", /* "pale_oak", */ "spruce");
	public static final Map<String, BlockSetType> WOOD_SET_TYPES = Map.of("acacia", BlockSetType.ACACIA, "bamboo", BlockSetType.BAMBOO, "birch", BlockSetType.BIRCH, "cherry", BlockSetType.CHERRY, "dark_oak", BlockSetType.DARK_OAK, "mangrove", BlockSetType.MANGROVE, "oak", BlockSetType.OAK, /* "pale_oak", BlockSetType.PALE_OAK, */ "spruce", BlockSetType.SPRUCE);

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

	public static Identifier createId(String path) {
		return Identifier.of(DelicateSip.namespace(), path);
	}

	public static String namespace() {
		return "delicate_sip";
	}
}
