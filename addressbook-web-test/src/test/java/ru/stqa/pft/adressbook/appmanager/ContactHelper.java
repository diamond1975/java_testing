package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.Groups;

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
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void deleteSelectContacts() {
    click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    wd.switchTo().alert().accept();
  }

  public void selectContactsById(int id) {
    wd.findElement(By.cssSelector("input[value= '" + id + "']")).click();
  }

  public void initContactModificationById(int id) {
    //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img");
    wd.findElement(By.xpath("//*[@href='edit.php?id="+id+"']")).click();
    //wd.findElement(By.xpath("//a[@href='edit.php?id="+ index +"']/img[@title='Edit']")).click();
  }

  public void submitContactModification() {
    click(By.name("update"));
  }

  public void creat(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact, b);
    submitContactCreation();
    contactsCache=null;
    returnToContactPage();
  }

  public void modify(ContactData contact) {
    selectContactsById(contact.getId());
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactsCache=null;
    returnToContactPage();
  }

  public void delete(ContactData contact) {
    selectContactsById(contact.getId());
    deleteSelectContacts();
    contactsCache=null;
    returnToContactPage();
  }
  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return  wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactsCache = null;

  public Contacts all() {
    if (contactsCache !=null) {
      return new Contacts(contactsCache);
    }

    contactsCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
    for (WebElement element : elements) {
      String Lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String FirstName = element.findElement(By.xpath(".//td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactsCache.add(new ContactData().withId(id).withName1(FirstName).withName2(Lastname));
    }
    return new Contacts(contactsCache);
  }
}

/*
*   public void delete(int index) {
    selectContacts(index);
    deleteSelectContacts();
    returnToContactPage();
  }

    public void selectContacts(int index) {
  wd.findElements(By.name("selected[]")).get(index).click();
  }

    public List<ContactData> list() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
    for (WebElement element : elements) {
      String Lastname = element.findElement(By.xpath(".//td[2]")).getText();
      String FirstName = element.findElement(By.xpath(".//td[3]")).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contacts.add(new ContactData().withId(id).withName1("Almaz1975").withName2("Gabdullin"));
    }
    return contacts;
  }
  */