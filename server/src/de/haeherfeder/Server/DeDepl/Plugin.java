package de.haeherfeder.Server.DeDepl;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class Plugin {
	List<IPlugin> plugins = PluginLoader.loadPlugins(new File("./plugin"));
    PluginManager manager;
	public  Plugin() throws IOException {
		manager = new PluginManager();
	    for (IPlugin p : plugins) {
	      p.setPluginManager(manager);
	    }
	    for (IPlugin p : plugins) {
	      p.start();
	    }
	}
	public Plugin(String string)throws IOException{
		manager = new PluginManager();
		for (IPlugin p : plugins) {
			p.setPluginManager(manager);
		}
	}
    public void  ServerInput(String Input) {
    	for (IPlugin p : plugins) {
    		p. ServerInput(Input);
    	}
    }
    public void stop() {
    	for (IPlugin p : plugins) {
    		p.stop();
    	}
    }
	public void recivedObjekt(Object data,int id,Connection connection) {
		for (IPlugin p : plugins) {
    		p.recivedObject(data, id, connection);
    	}
	}
}