package com.brotherlogic.rccli;

import com.brotherlogic.recordcollection.MainSystem;
import com.brotherlogic.recordcollection.RcSystem;

import joptsimple.OptionSet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Runner {

  RcSystem collection = new MainSystem();

  protected Properties getProperties(InputStream stream) {
    try {
      Properties props = new Properties();
      props.load(stream);
      return props;
    } catch (IOException e) {
      return null;
    }
  }

  protected String process(String[] args) {
    CliOptionParser parser = new CliOptionParser();
    OptionSet options = parser.parse(args);

    if (options.has("version")) {
      Properties props = getProperties(Runner.class.getResourceAsStream("properties.txt"));
      return "CLI Version: " + props.getProperty("version") + "\nRC Version:  "
          + collection.getVersion();
    }

    return "ERROR: no option selected";
  }

  /**
   * Main method.
   * 
   * @param args command line arguments
   */
  public static void main(String[] args) {
    Runner mine = new Runner();
    String output = mine.process(args);
    System.out.println(output);
  }

}
