package de.haeherfeder.deDePlPlugin.Multiplayer.Plugin;

import de.haeherfeder.DeDePlEngine.all.IPlugin;
import de.haeherfeder.DeDePlEngine.all.PluginManager;

public class Main implements IPlugin{
	PluginManager manager;
	@Override
	public void GameStart() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void GameWindowStart(String arg0) {
		// TODO Auto-generated method stub
		manager.showVisualMessage("Online enabled");
		manager.setStartPosition("Ende");
		manager.DisableGameWindow();
		manager.SinglePosition("Server");
	}

	@Override
	public void PlayerInput(String arg0, String arg1) {
		// TODO Auto-generated method stub
		switch(arg1) {
		case "Server":
			manager.showVisualMessage("Server Fenster erkannt.");
			new ConnectServer(arg0);
			manager.showVisualMessage("New ConnectServer fineshed");
			break;
		case "":
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
		// TODO Auto-generated method stub
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