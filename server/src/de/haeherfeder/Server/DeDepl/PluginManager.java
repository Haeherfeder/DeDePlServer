package de.haeherfeder.Server.DeDepl;

public class PluginManager implements IPluginManager {	
	public PluginManager() {
		
	}
	
	public void showConsoleMessage(String message) {
		System.out.println(message);
	}
/*	public void GameWindowStart(String Position) {
		
	}*/

	@Override
	public String getconf(String key) {
		return null;
	}

	@Override
	public void sendObject(Object obj,Connection con) {
		
	}
}