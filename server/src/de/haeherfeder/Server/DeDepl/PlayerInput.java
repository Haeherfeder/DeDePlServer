package de.haeherfeder.Server.DeDepl;

import de.haeherfeder.deDePlPlugin.Multiplayer.Plugin.packets.PlayerInputData;

public class PlayerInput {
	@SuppressWarnings("unused")
	public PlayerInput(PlayerInputData inputP, int id) {
		String input = inputP.Input;
		String Position = inputP.Position;
		String Player = inputP.Player;
	}
}
