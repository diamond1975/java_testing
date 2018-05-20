package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    if (text != null) {  //Используется сокращенная форма if/ Если тект не равно пустому значению,
      // то заполянем значенимем
      String existingText = wd.findElement(locator).getAttribute("value");       /* проверка, если в поле введено
       нужное значение, то в поле уже ничего делать не нужно. Оптимизация, т.к селеинум вводит поле посимвольно, поэтому
       для поей с размером более 1-5 т.символов, требуется оптимизация.*/
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }
  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}