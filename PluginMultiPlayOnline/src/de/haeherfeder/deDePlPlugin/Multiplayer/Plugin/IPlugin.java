package de.haeherfeder.deDePlPlugin.Multiplayer.Plugin;

public interface IPlugin {
	boolean MultiStart();
	boolean MultiStop();
	void setPluginMultiplayerManager(PluginMultiplayerManager manager);
	void connectedToServer(String server,int port);
	void recivedObject(Object packet);
}
