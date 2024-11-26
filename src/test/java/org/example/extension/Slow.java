package org.example.extension;

import java.time.Duration;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.BeforeTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class Slow implements BeforeTestExecutionCallback, AfterTestExecutionCallback {

   private static final Duration DURATION = Duration.ofMillis(500);

  @Override
  public void beforeTestExecution(ExtensionContext extensionContext) throws Exception {
    Thread.sleep(DURATION);
  }

  @Override
  public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
    Thread.sleep(DURATION);
  }
}
