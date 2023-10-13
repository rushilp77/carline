package carline;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Properties;
import java.util.StringTokenizer;

public class properties
{
  private static Properties commProps = new Properties();
  private static String propFilename = null;
  
  static
  {
    try
    {
      if ((propFilename = findPropFile("javax.comm.properties")) != null) {
        commProps.load(new BufferedInputStream(new FileInputStream(new File(propFilename))));
      } else {
        System.err.println("javax.comm:  Can't find javax.comm.properties!");
      }
    }
    catch (Exception e)
    {
      System.err.println("javax.comm:  Error loading javax.comm.properties!");
      
      System.err.println(e.getMessage());
    }
  }
  
  public static String getProperty(String propName)
  {
    return commProps.getProperty(propName);
  }
  
  public static String getPropFilename()
  {
    return propFilename;
  }
  
  private static String findPropFile(String filename)
  {
    if (new File(filename).exists()) {
      return filename;
    }
    StringTokenizer st = new StringTokenizer(System.getProperty("java.class.path"), File.pathSeparator);
    while (st.hasMoreTokens())
    {
      File p = null;
      File f = new File(st.nextToken());
      if (f.exists()) {
        if (f.isDirectory()) {
          p = new File(f.getPath() + File.separator + filename);
        } else if (f.getParent() != null) {
          p = new File(f.getParent() + File.separator + filename);
        }
      }
      if (p.exists()) {
        return p.getPath();
      }
    }
    String defaultPath = System.getProperty("java.home") + File.separator + "lib" + File.separator + filename;
    if (new File(defaultPath).exists()) {
      return defaultPath;
    }
    defaultPath = System.getProperty("java.home") + File.separator + "jre" + File.separator + "lib" + File.separator + filename;
    if (new File(defaultPath).exists()) {
      return defaultPath;
    }
    return null;
  }
}