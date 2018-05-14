package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class ApplicationManager1 {
  FirefoxDriver wd;

  private SessionHelper1 sessionHelper1;
  private  NavigationHelper1 navigationHelper1;
  private ContactHelper contactHelper;

  public void init() {
    wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files/Mozilla FirefoxESR/firefox.exe"));
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    wd.get("http://localhost/addressbook/");
    contactHelper = new ContactHelper(wd);
    navigationHelper1 = new NavigationHelper1(wd);
    sessionHelper1= new SessionHelper1(wd);
    sessionHelper1.login("admin", "secret");
  }


  public void stop() {
    wd.quit();
  }

  public ContactHelper getContactHelper() {
    return contactHelper;
  }

  public NavigationHelper1 getNavigationHelper1() {
    return navigationHelper1;
  }
}