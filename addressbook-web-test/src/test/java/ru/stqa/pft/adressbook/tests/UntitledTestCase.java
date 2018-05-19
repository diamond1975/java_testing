package ru.stqa.pft.adressbook.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UntitledTestCase {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://www.katalon.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUntitledTestCase() throws Exception {
    driver.get("https://www.yandex.ru/");
    driver.findElement(By.linkText("Маркет")).click();
    driver.findElement(By.linkText("Электроника")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Телевизоры')])[2]")).click();
    driver.findElement(By.id("glpricefrom")).click();
    driver.findElement(By.id("glpricefrom")).clear();
    driver.findElement(By.id("glpricefrom")).sendKeys("25000");
    driver.findElement(By.id("glpricefrom")).click();
    driver.findElement(By.xpath("//div[2]/div/div[6]")).click();
    driver.findElement(By.xpath("//div[@id='search-prepack']/div/div/div[2]/div/div/div[4]/fieldset/ul/li[3]/div/a/label/div")).click();
    driver.findElement(By.xpath("//div[@id='search-prepack']/div/div/div[2]/div/div/div[4]/fieldset/ul/li[6]/div/a/label/div")).click();
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    driver.findElement(By.xpath("//div[@id='uniq15266687711391']/span")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
