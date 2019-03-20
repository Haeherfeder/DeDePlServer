package de.haeherfeder.Server.DeDepl;

public interface IPlugin {
	boolean start();
	boolean stop();
	void setPluginManager(PluginManager manager);
	void ServerInput(String Input);
	void GameStart();
	void recivedObject(Object data,int id,Connection connection);
}
