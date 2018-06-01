package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);

  }

  public void returnToContactPage() {
    click(By.linkText("home"));
  }

  public void submitContactCreation() {
    click(By.name("submit"));
  }

  public void fillContactForm(ContactData contactDate, boolean creation) {
    type(By.name("firstname"), contactDate.getName1());
    click(By.name("lastname"));
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactDate.getName2());
    type(By.name("nickname"), contactDate.getName3());
    type(By.name("address"), contactDate.getAddress());
    type(By.name("home"), contactDate.getMobileHome());
    type(By.name("mobile"), contactDate.getMobile());
    type(By.name("work"), contactDate.getMobileWork());
    type(By.name("email"), contactDate.getEmail1());
    type(By.name("email2"), contactDate.getEmail2());
    type(By.name("email3"), contactDate.getEmail3());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroup());
    }else{
      Assert.assertFalse(isElementPresent (By.name("new_group")));
    }
  }


  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void deleteSelectContacts() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void selectContacts(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initContactModification(int i) {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void creatContact(ContactData contact, boolean   b) {
    initContactCreation();
    fillContactForm(contact, b);
    submitContactCreation();
    returnToContactPage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return  wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List <WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
    for (WebElement element : elements) {
      String Lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String FirstName = element.findElement(By.xpath(".//td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      ContactData contact = new ContactData(id, FirstName, Lastname, null,null, null, null,null,
              null,null, null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}