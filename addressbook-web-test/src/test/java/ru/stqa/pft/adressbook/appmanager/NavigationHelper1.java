package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationHelper1 extends HelperBase1{
 // private FirefoxDriver wd;

  public NavigationHelper1(FirefoxDriver wd) {
    super(wd);

  }

  public void gotoContactPage() {
    click(By.linkText("home"));
  }
}
