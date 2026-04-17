package com.mmodding.ds.init;

import com.mmodding.ds.block.entity.RockFoundryBlockEntity;
import com.mmodding.library.core.api.AdvancedContainer;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class DelicateSipBlockEntities {

	public static final BlockEntityType<RockFoundryBlockEntity> ROCK_FOUNDRY = FabricBlockEntityTypeBuilder.create(RockFoundryBlockEntity::new, DelicateSipBlocks.ROCK_FOUNDRY).build();

	public static void register(AdvancedContainer mod) {
		mod.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, "rock_foundry", ROCK_FOUNDRY);
	}
}
