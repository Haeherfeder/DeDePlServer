package de.haeherfeder.Server.DeDepl;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

public class PluginLoader {

  public static List<IPlugin> loadPlugins(File plugDir) throws IOException {

    File[] plugJars = plugDir.listFiles(new JARFileFilter());
    ClassLoader cl = new URLClassLoader(PluginLoader.fileArrayToURLArray(plugJars));
    List<Class<IPlugin>> plugClasses = PluginLoader.extractClassesFromJARs(plugJars, cl);
    return PluginLoader.createIPluginObjects(plugClasses);
  }

  private static URL[] fileArrayToURLArray(File[] files) throws MalformedURLException {

    URL[] urls = new URL[files.length];
    for (int i = 0; i < files.length; i++) {
      urls[i] = files[i].toURI().toURL();
    }
    return urls;
  }

  private static List<Class<IPlugin>> extractClassesFromJARs(File[] jars, ClassLoader cl) throws IOException {

    List<Class<IPlugin>> classes = new ArrayList<Class<IPlugin>>();
    for (File jar : jars) {
      classes.addAll(PluginLoader.extractClassesFromJAR(jar, cl));
    }
    return classes;
  }

  @SuppressWarnings("unchecked")
  private static List<Class<IPlugin>> extractClassesFromJAR(File jar, ClassLoader cl) throws IOException {

    List<Class<IPlugin>> classes = new ArrayList<Class<IPlugin>>();
    JarInputStream jaris = new JarInputStream(new FileInputStream(jar));
    JarEntry ent = null;
    while ((ent = jaris.getNextJarEntry()) != null) {
      if (ent.getName().toLowerCase().endsWith(".class")) {
        try {
          Class<?> cls = cl.loadClass(ent.getName().substring(0, ent.getName().length() - 6).replace('/', '.'));
          if (PluginLoader.isIPluginClass(cls)) {
            classes.add((Class<IPlugin>)cls);
          }
        }
        catch (ClassNotFoundException e) {
          System.err.println("Can't load Class " + ent.getName());
          e.printStackTrace();
        }
      }
    }
    jaris.close();
    return classes;
  }

  private static boolean isIPluginClass(Class<?> cls) {

    for (Class<?> i : cls.getInterfaces()) {
      if (i.equals(IPlugin.class)) {
        return true;
      }
    }
    return false;
  }

  private static List<IPlugin> createIPluginObjects(List<Class<IPlugin>> IPlugins) {

    List<IPlugin> plugs = new ArrayList<IPlugin>(IPlugins.size());
    for (Class<IPlugin> plug : IPlugins) {
      try {
        plugs.add(plug.newInstance());
      }
      catch (InstantiationException e) {
        System.err.println("Can't instantiate plugin: " + plug.getName());
        e.printStackTrace();
      }
      catch (IllegalAccessException e) {
        System.err.println("IllegalAccess for plugin: " + plug.getName());
        e.printStackTrace();
      }
    }
    return plugs;
  }
}