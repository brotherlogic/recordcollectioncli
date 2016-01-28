package com.brotherlogic.rccli;

import org.junit.Assert;
import org.junit.Test;

public class FoldersTest {
  @Test
  public void testViewFoldersReturnsSomething() {
    Runner testRunner = new Runner();
    String[] cliString = new String[] {"--view_folders"};
    String response = testRunner.process(cliString);

    Assert.assertTrue(response.length() > 0);
    Assert.assertFalse(response.startsWith("ERROR"));
  }
}
