package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class ApplicationManager {
  private final Properties properties;
  WebDriver wd;
  private SessionHelper sessionHelper;
  private NavigationHelper navigationHelper;
  private GroupHelper groupHelper;
  private ContactHelper contactHelper;
  private String browser;
  private DbHelper dbHelper;

  public ApplicationManager(String browser) {
    this.browser = browser;
    properties = new Properties();
  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties",target))));

    dbHelper = new DbHelper();

    if (browser.equals(BrowserType.FIREFOX)) { //замена оператора сравнения == на quals. Т.к == правильно только для числел.
      wd = new FirefoxDriver(new FirefoxOptions().setLegacy(true).setBinary("C:/Program Files/Mozilla FirefoxESR/firefox.exe"));
    } else if (browser.equals(BrowserType.CHROME)) {     //String browser = BrowserType.FIREFOX; Локальная переменная уже не неужна, т.к в базовом классе TestBase уже определена конструктор
      wd = new ChromeDriver();
    }else if (browser.equals(BrowserType.IE)){
    wd = new InternetExplorerDriver();
  }
    wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));
    groupHelper = new GroupHelper(wd);
    contactHelper = new ContactHelper(wd);
    navigationHelper = new NavigationHelper(wd);
    sessionHelper = new SessionHelper(wd);
    sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

  }
  public void stop() {
    wd.quit();
  }

  public ContactHelper contact() {
    return contactHelper;
  }

  public GroupHelper group() {
    return groupHelper;
  }

  public NavigationHelper goTo() {
    return navigationHelper;
  }

  public DbHelper db(){
    return dbHelper;
  }
}