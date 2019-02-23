package de.haeherfeder.Server.DeDepl;

import java.util.Properties;

import de.haeherfeder.deDePlPlugin.Multiplayer.Plugin.packets.*;

public class PlayerAuth {
	String PubKey;
	String Salt = ""+Math.random();
	String name;
	int id;
	int uuid;
	
	@SuppressWarnings("unused")
	public PlayerAuth(AddPlayerPacket data, Connection connection) {
		id = data.id;
		name = data.name;
		RequestAuth auth = new RequestAuth();
		auth.Salt = Salt;
		auth.PubKey = PubKey;
		auth.uuid = uuid;
		connection.sendObject(auth);
	}
	@SuppressWarnings("unused")
	public PlayerAuth(AuthPacket authPacket,Connection connection, Properties auth, int id2) {
		name = authPacket.Name;
		id = getId(name);
			if(id == authPacket.PlayerId) {
				byte[] encry = authPacket.Passwd;
				String passwd = new EncryptConf().decrypt(encry);
				if(passwd.startsWith(Salt)) {
					System.out.println("Salt is correct from "+name);
				 	String password = passwd.substring(Salt.length());
				 	if(isCorrect(password)) {
				 		auth.setProperty(""+id2, "true");
				 		
				 	}
				}else {
					System.out.println("Salt incorrect");
				}
			}
	}
	private boolean isCorrect(String password) {
		return "correct"==password;
	}
	int getId(String name){
		return 1;
	}
	boolean setId(String Name, int id) {
		if(-1== getId(Name)) {
			return true;
		}else{
			return false;
		}
	}
}