package de.haeherfeder.Server.DeDepl;

public interface IPluginManager {
	void showConsoleMessage(String message);
	String getconf(String key);
	void sendObject(Object obj, Connection con);
}