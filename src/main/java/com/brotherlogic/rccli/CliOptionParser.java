package com.brotherlogic.rccli;

import joptsimple.OptionParser;

public class CliOptionParser extends OptionParser {
  public CliOptionParser() {
    accepts("version");
  }
}
