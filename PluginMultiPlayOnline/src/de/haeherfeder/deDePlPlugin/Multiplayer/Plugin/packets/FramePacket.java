package de.haeherfeder.deDePlPlugin.Multiplayer.Plugin.packets;

import java.io.Serializable;

public class FramePacket implements Serializable{
private static final long serialVersionUID = 2L;
	
	public int id;
	public String tf1Text,tf2Text,tf3Text;
}
