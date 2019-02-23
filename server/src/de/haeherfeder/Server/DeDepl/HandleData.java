package de.haeherfeder.Server.DeDepl;

import java.util.Properties;

import de.haeherfeder.deDePlPlugin.Multiplayer.Plugin.packets.*;

public class HandleData {
	Properties auth = new Properties();
	public HandleData(Object data, int id, Connection connection) {
		System.out.println("Class: "+data.getClass()+" from "+ id +" recived." );
		String h = ""+data.getClass();
		switch(h) {
		case "de.haeherfeder.deDePlPlugin.Multiplayer.Plugin.packets.AddPlayerPacket":
			System.out.println(h);
			break;
		}
		
		if(data instanceof AddPlayerPacket) {
			AddPlayerPacket player = (AddPlayerPacket)data;
			System.out.println("Player add packet recived. Name: "+player.name+" Id: "+player.id);
			new PlayerAuth(player,connection);
		}else if(data instanceof AuthPacket){
			AuthPacket authPa = (AuthPacket)data;
			new PlayerAuth(authPa,connection,auth,id);
		}else if("true"==auth.getProperty(""+id)){
			if(data instanceof PlayerInputData) {
				PlayerInputData input = (PlayerInputData)data;
				new PlayerInput(input,id,connection,"true"==auth.getProperty(""+id));
			}
		}
	}
}