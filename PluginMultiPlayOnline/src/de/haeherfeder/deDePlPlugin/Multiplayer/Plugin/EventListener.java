package de.haeherfeder.deDePlPlugin.Multiplayer.Plugin;

import java.io.IOException;

//package com.arcxesgames.main;

import de.haeherfeder.deDePlPlugin.Multiplayer.Plugin.packets.*;

public class EventListener {
	Plugin pl;
	@SuppressWarnings("unused")
	public void received(Object p) {
		try {
			pl = new Plugin();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pl.recivedObject(p);
		if(p instanceof AddPlayerPacket) {
			AddPlayerPacket packet = (AddPlayerPacket)p;
			System.out.println(packet.name + " has joined the game");
		}else if(p instanceof RemovePlayerPacket) {
			RemovePlayerPacket packet = (RemovePlayerPacket)p;
			System.out.println(packet.id + " has left the game");
			//PlayerHandler.players.remove(packet.id);
		}else if(p instanceof FramePacket) {
			FramePacket packet = (FramePacket)p;
			int id = packet.id;
			String tf = packet.tf1Text;
		}else if(p instanceof ServerClose) {
			new Client().close();
			System.out.println("Server closed");
			return;
		}
	}
}