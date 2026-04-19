package com.mmodding.ds.client;

import com.mmodding.ds.DelicateSip;
import com.mmodding.library.rendering.api.sprite.TextureAliases;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.resources.Identifier;

@Environment(EnvType.CLIENT)
public class DelicateSipClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		TextureAliases.create(DelicateSip.createId("block/rock_foundry_bottom"), Identifier.withDefaultNamespace("block/bricks"));
	}
}
