package ru.stqa.pft.adressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.stqa.pft.adressbook.appmanager.ApplicationManager;

import java.io.IOException;

import static org.openqa.selenium.remote.BrowserType.*;

public class TestBase {

  protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", CHROME));

  // = new ApplicationManager(BrowserType.CHROME);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }
  @AfterSuite
  public void tearDown() {
    app.stop();
  }
    public ApplicationManager getApp() {
      return app;
  }

}
