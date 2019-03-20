package de.haeherfeder.Server.DeDepl;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
	private boolean run = true;
	Plugin pl;
	
	public Main(String[] args) {
		System.out.println("System startet.");
		Server server = new Server(Integer.parseInt(args[0]));
		System.out.println(Integer.parseInt(args[0]));
		Serverst ServerC;
		new Thread(ServerC = new Serverst(server)).start();
		System.out.println("Server input.");
		Scanner user_input = new Scanner(System.in);
		String input = null;
		while(run) {
			input = user_input.next();
			HandleInput(input);
		}
		user_input.close();
		System.out.println("Server Shutdown.");
		ServerC.stop();
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	public static void main(String[] args) {
		new Main(args);
	}

	private void HandleInput(String input) {
		switch(input) {
		case "Stop":
		case "stop":
			run = false;
			break;
		default:
			pl.ServerInput(input);
			System.out.println("Unknown Input.");
			break;
		}
	}
}