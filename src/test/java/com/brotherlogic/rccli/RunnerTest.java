package com.brotherlogic.rccli;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

public class RunnerTest {

  @Test
  public void testIOFailOnGetProperties() {
    Runner run = new Runner();
    Properties props = run.getProperties(new InputStream() {
      @Override
      public int read() throws IOException {
        throw new IOException("Expected Failure");
      }
    });

    Assert.assertNull(props);
  }

  @Test
  public void testNoSelection() {
    Runner run = new Runner();
    String res = run.process(new String[0]);
    Assert.assertTrue(res.startsWith("ERROR"));
  }
}
