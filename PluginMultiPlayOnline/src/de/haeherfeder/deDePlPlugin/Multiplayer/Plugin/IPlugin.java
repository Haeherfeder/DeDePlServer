package de.haeherfeder.deDePlPlugin.Multiplayer.Plugin;

public interface IPlugin {
	boolean start();
	boolean stop();
	void setPluginMultiplayerManager(PluginMultiplayerManager manager);
	void connectedToServer(String server,int port);
	void getObject(Object packet);
}
