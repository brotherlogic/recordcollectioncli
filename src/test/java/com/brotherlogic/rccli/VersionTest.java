package com.brotherlogic.rccli;

import org.junit.Assert;
import org.junit.Test;

public class VersionTest {

  @Test
  public void testVersionReturnsSomething() {
    Runner testRunner = new Runner();
    String[] cliString = new String[] {"--version"};
    String response = testRunner.process(cliString);

    Assert.assertTrue(response.length() > 0);
    Assert.assertFalse(response.startsWith("ERROR"));

    // There should be two lines of output
    Assert.assertEquals(2, response.split("\n").length);
  }

}
