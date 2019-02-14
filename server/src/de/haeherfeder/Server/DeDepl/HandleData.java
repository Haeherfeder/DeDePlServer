package de.haeherfeder.Server.DeDepl;

import de.haeherfeder.deDePlPlugin.Multiplayer.Plugin.packets.*;

public class HandleData {
	public HandleData(Object data, int id) {
		System.out.println("Class: "+data.getClass()+" from "+ id +" recived." );
		if(data instanceof AddPlayerPacket) {
			AddPlayerPacket player = (AddPlayerPacket)data;
			System.out.println("Player add packet recived. Name: "+player.name+" Id: "+player.id);
		}else if(data instanceof PlayerInputData) {
			PlayerInputData input = (PlayerInputData)data;
			new PlayerInput(input,id);
		}
	}
}