package de.haeherfeder.Server.DeDepl;

public class Serverst implements Runnable {
	Server server;
	public Serverst(Server server) {
		this.server = server;
	}
	public void run() {
		// TODO Auto-generated method stub
		server.start();
		System.out.println("Server run.");
		server.run();
	}
	public void stop() {
		server.setrunning(false);
	}

}
