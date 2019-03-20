package de.haeherfeder.Server.DeDepl;
import java.io.File;
import java.io.FileFilter;

public class JARFileFilter implements FileFilter {
	public boolean accept(File f){
		return f.getName().toLowerCase().endsWith(".jar");
  }
}
