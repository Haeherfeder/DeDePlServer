package de.haeherfeder.deDePlPlugin.Multiplayer.Plugin;

import java.io.IOException;

import de.haeherfeder.DeDePlEngine.all.IPlugin;
import de.haeherfeder.DeDePlEngine.all.PluginManager;

public class Main implements IPlugin{
	PluginManager manager;
	Plugin pl;
	String EngineVersion;
	@Override
	public void GameStart() {
		try {
			pl = new Plugin();
			pl.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void GameWindowStart(String arg0) {
		manager.showVisualMessage("Online enabled");
		manager.setStartPosition("Ende");
		System.out.println("Position set to Ende");
		manager.DisableGameWindow();
//		manager.setPosition(Position);
		manager.SinglePosition("Pl_Server"+"Server");
	}
	
	@Override
	public void PlayerInput(String arg0, String arg1) {
		System.out.println(arg1);
		String test;
		if(arg1.startsWith("Pl_Server")) {
			test = arg1.replace("Pl_Server", "");
		}else {return;}
		switch(test) {
		case "Server":
			manager.showVisualMessage("Server Fenster erkannt.");
			new ConnectServer(arg0);
			manager.showVisualMessage("New ConnectServer fineshed");
			break;
		default:
			
			break;
		}
	}

	@Override
	public void sendPosition(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean setEngineVersion(String arg0) {
		this.EngineVersion = arg0;
		return false;
	}

	@Override
	public void setPluginManager(PluginManager manager) {
		// TODO Auto-generated method stub
		this.manager = manager;
	}

	@Override
	public boolean start() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean stop() {
		// TODO Auto-generated method stub
		return false;
	}		
}