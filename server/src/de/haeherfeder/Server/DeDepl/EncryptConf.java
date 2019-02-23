package de.haeherfeder.Server.DeDepl;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class EncryptConf {
	PublicKey PubKey;
	private PrivateKey Key;
	KeyPairGenerator rsaKPG = null;
	private Cipher cipher;
	public EncryptConf() {
		
	}
	public void keyGen() {
		try {
			rsaKPG = KeyPairGenerator.getInstance("RSA");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		rsaKPG.initialize(4096);
		KeyPair kp = rsaKPG.genKeyPair();
		PubKey = kp.getPublic();
		Key = kp.getPrivate();
	}
	public void start() {
		keyGen();
		try {
			cipher = Cipher.getInstance("RSA");
			cipher.init(Cipher.DECRYPT_MODE, Key);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		}
	}
	public String decrypt(byte[] encr) {
		String dec = "";
		try {
			byte[] enc = cipher.doFinal(encr);
			dec = new String(enc);			
		} catch (IllegalBlockSizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dec;
	}
	public PublicKey PubKey() {
		return PubKey;
	}
}