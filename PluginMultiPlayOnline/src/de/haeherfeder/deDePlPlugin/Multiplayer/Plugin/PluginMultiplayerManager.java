package de.haeherfeder.deDePlPlugin.Multiplayer.Plugin;

public class PluginMultiplayerManager implements IPluginManager {
	
	public void showVisualMessage(String message) {
		System.out.println(message);
	}
/*	public void GameWindowStart(String Position) {
		
	}*/

	@Override
	public String getconf(String key) {
		return null;
	}

	@Override
	public String getRole(String key) {
		return null;
	}

	@Override
	public void setText(String WhichText, String Text) {
		
	}

	@Override
	public void setInt(String Which, int vel) {
		
	}

	@Override
	public void sendObject(Object packet) {
		
	}

	@Override
	public Object AnswerObjekt(Object packet) {
		// TODO Auto-generated method stub
		return null;
	}
}