package de.haeherfeder.deDePlPlugin.Multiplayer.Plugin;

public interface IPluginManager {
	void showVisualMessage(String message);
	public String getconf(String key);
	public String getRole(String key);
	public void setText(String WhichText,String Text);
	public void setInt(String Which, int vel);
	public void sendObject(Object packet);
	public Object AnswerObjekt(Object packet);
}