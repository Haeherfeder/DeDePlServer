package de.haeherfeder.Server.DeDepl;
//package com.arcxesgames.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable{
	
	private int port;
	private ServerSocket serverSocket;
	private boolean running = false;
	private int i=0;
	
	public Server(int port) {
		this.port = port;
		
		try {
			serverSocket = new ServerSocket(this.port);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		running = true;
		
		while(running) {
			try {
				Socket socket = serverSocket.accept();
				initSocket(socket);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		shutdown();
	}
	
	private void initSocket(Socket socket) {
		i++;
		Connection connection = new Connection(socket,i);
		new Thread(connection).start();
	}
	
	public void shutdown() {
		running = false;
		try {
			serverSocket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void setrunning(boolean bool) {
		running = bool;
	}
}