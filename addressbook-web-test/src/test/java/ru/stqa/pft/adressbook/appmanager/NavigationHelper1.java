package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper1 {
  private FirefoxDriver wd;

  public NavigationHelper1(FirefoxDriver wd) {
    this.wd =wd;

  }

  public void gotoContactPage() {
    wd.findElement(By.linkText("home")).click();
  }
}
