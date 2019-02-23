package de.haeherfeder.Server.DeDepl;
//package com.arcxesgames.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import de.haeherfeder.deDePlPlugin.Multiplayer.Plugin.packets.*;

public class Connection implements Runnable{
	
	private Socket socket;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private int id;
	
	public Connection(Socket socket,int id) {
		this.socket = socket;
		this.id = id;
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			in = new ObjectInputStream(socket.getInputStream());
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			System.out.println("object reciving startet.");
			while(socket.isConnected()) {
				try {
					Object data = in.readObject();
					System.out.println("object recived");
					new HandleData(data,id,this);
				}catch(ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			sendObject(new ServerClose());
			in.close();
			out.close();
			socket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendObject(Object packet) {
		try {
			out.writeObject(packet);
			out.flush();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	/*public Object getObjekt(){
		in.
		return "";
	}*/
}