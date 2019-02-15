package de.haeherfeder.deDePlPlugin.Multiplayer.Plugin;

import java.io.IOException;
import java.util.Scanner;

import de.haeherfeder.deDePlPlugin.Multiplayer.Plugin.packets.*;

public class ConnectServer {
	Plugin pl;
	public ConnectServer(String arg0) {
		try {
			pl = new Plugin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(arg0);
		String[] parts = arg0.split(":");
		String host = parts[0];
		String portS = parts[1];
		int port = Integer.parseInt(portS);
		System.out.println("Host:"+host+":"+port);
		Client client = new Client(host,port);
		client.connect();
		pl.connectedToServer(host,port);
		client.sendObject(AddPlayerPacket());
//		client.sendObject("");
		client.run();
	}
	public AddPlayerPacket AddPlayerPacket(){
		AddPlayerPacket packet = new AddPlayerPacket();
		Scanner user_input = new Scanner(System.in);
		int id = Integer.parseInt(user_input.next());
		packet.id = id;
		String name = user_input.next();
		packet.name = name;
		user_input.close();
		return packet;
	}
}