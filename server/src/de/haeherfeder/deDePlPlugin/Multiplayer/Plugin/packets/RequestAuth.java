package de.haeherfeder.deDePlPlugin.Multiplayer.Plugin.packets;

import java.io.Serializable;

public class RequestAuth implements Serializable{
	
	private static final long serialVersionUID = 1L;
	public String Salt;
	public String PubKey;
	public int uuid;
}
