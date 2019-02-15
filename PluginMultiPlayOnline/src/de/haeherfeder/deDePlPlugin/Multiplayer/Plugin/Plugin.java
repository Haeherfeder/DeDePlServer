package de.haeherfeder.deDePlPlugin.Multiplayer.Plugin;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Plugin {
	List<IPlugin> plugins = PluginLoader.loadPlugins(new File("./plugin"));
	PluginMultiplayerManager manager = new PluginMultiplayerManager();
	public  Plugin() throws IOException {
	    
	}
	public void start() {
		for (IPlugin p : plugins) {
		      p.setPluginMultiplayerManager(manager);
		    }
		    for (IPlugin p : plugins) {
		      p.MultiStart();
		    }
	}
    public void connectedToServer(String server,int port) {
    	for (IPlugin p : plugins) {
    		p.connectedToServer(server,port);
    	}
    }
    public void recivedObject(Object packet) {
    	for (IPlugin p : plugins) {
    		p.recivedObject(packet);
    	}
    }
    public void stop() {
    	for (IPlugin p : plugins) {
    		p.MultiStop();
    	}
    }
}