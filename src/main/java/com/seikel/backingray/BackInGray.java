package com.seikel.backingray;
import net.minecraft.network.chat.Component;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class BackInGray implements ModInitializer {
	public static final String MOD_ID = "back-in-gray";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	private boolean mensaje = false;

	@Override
	public void onInitialize() {
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			if(!mensaje && !server.getPlayerList().getPlayers().isEmpty()){
				ServerPlayer jugador = server.getPlayerList().getPlayers().get(0);

				jugador.sendSystemMessage(
					Component.literal("Está funcionandooooooooo")
				);

				mensaje = true;
			}
		});

		LOGGER.info("Hello Fabric world!");
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}
}
