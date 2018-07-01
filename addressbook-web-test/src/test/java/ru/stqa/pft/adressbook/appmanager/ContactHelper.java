package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
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
    //click(By.name("submit"));
    wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
  }

  public void fillContactForm(ContactData contactDate, boolean creation) {
    type(By.name("firstname"), contactDate.getName1());
    click(By.name("lastname"));
    wd.findElement(By.name("lastname")).clear();
    wd.findElement(By.name("lastname")).sendKeys(contactDate.getName2());
    type(By.name("nickname"), contactDate.getName3());
    //attach(By.name("photo"), contactDate.getPhoto());
    type(By.name("address"), contactDate.getAddress());
    type(By.name("home"), contactDate.getMobileHome());
    type(By.name("mobile"), contactDate.getMobile());
    type(By.name("work"), contactDate.getMobileWork());
    type(By.name("email"), contactDate.getEmail1());
    type(By.name("email2"), contactDate.getEmail2());
    type(By.name("email3"), contactDate.getEmail3());

    if (creation) {
      if (contactDate.getGroups().size() > 0) {
        Assert.assertTrue(contactDate.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactDate.getGroups().iterator().next().getName());
      } else {
        Assert.assertFalse(isElementPresent(By.name("new_group")));
      }
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

  public void submitContactModification() {
    click(By.name("update"));
    //click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void create(ContactData contact, boolean b) {
    initContactCreation();
    fillContactForm(contact, b);
    submitContactCreation();
    contactCache = null;
    returnToContactPage();
  }

  public void modify(ContactData contact) {
    selectContactsById(contact.getId());
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToContactPage();
  }

  public void delete(ContactData contact) {
    selectContactsById(contact.getId());
    deleteSelectContacts();
    contactCache = null;
    returnToContactPage();
  }
  public void selectGroupListAddTo(GroupData group) {
    new Select(wd.findElement(By.name("to_group"))).selectByVisibleText(group.getName());
  }

  public void selectedAddedContactById(int id) {
    wd.findElement(By.cssSelector("input[id='" + id + "']")).click();
  }

  public void addInGroupById(int id) {
    click(By.cssSelector("select[name='to_group']"));
    click(By.cssSelector(".right>select>option[value='" + id + "']"));
    click(By.name("add"));
  }

  public void addGroup() {
    wd.findElement(By.name("add")).click();
  }

  public void removeContactFromGroup(){
    click(By.cssSelector("input[name='remove']"));
  }
  public void findGroupById(int id) {
    click(By.cssSelector("#right"));
    click(By.cssSelector("#right>select>option[value='" + id + "']"));
  }

  public boolean isContactExist() {
    return isElementPresent(By.name("selected[]"));
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();

    List<WebElement> rows = wd.findElements(By.xpath("//table[@id='maintable']//tr[@name='entry']"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(row.findElement(By.tagName("input")).getAttribute("value"));
      String lastname = cells.get(1).getText();
      String firstname = cells.get(2).getText();
      String addrress = cells.get(3).getText();
      String allEmails = cells.get(4).getText();
      String allPhones = cells.get(5).getText();
      contactCache.add(new ContactData().withId(id).withName1(firstname).withName2(lastname).withAddress(addrress)
              .withAllPhones(allPhones).withAllEmails(allEmails));
    }
    return new Contacts(contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());

    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getText();
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    wd.navigate().back();
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName1(firstname).withName2(lastname).withMobileHome(home)
            .withMobile(mobile).withMobileWork(work).withAddress(address).withEmail1(email).withEmail2(email2).withEmail3(email3);
  }
  public void contactAddGroup(ContactData editedContact, GroupData group) {
    selectContactsById(editedContact.getId());
    selectGroupListAddTo(group);
    addGroup();
    System.out.println("added");
  }

  public GroupData groupForContact(ContactData contact, Groups groups) {
    for (GroupData g : groups) {
      if (!contact.getGroups().contains(g)) {
        return g;
      }

    }
    return null;
  }
  public void deleteFromGroup(ContactData contact, GroupData group) {
    selectGroupList(group);
    selectContactsById(contact.getId());
    removeFromGroup(group);
  }
  private void removeFromGroup(GroupData group) {
    Assert.assertEquals(wd.findElement(By.name("remove")).getAttribute("value"), "Remove from \"" + group.getName() + "\"");
    wd.findElement(By.name("remove")).click();
  }
  private void selectGroupList(GroupData group) {
    new Select(wd.findElement(By.name("group"))).selectByVisibleText(group.getName());
  }
  public void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }
  public GroupData groupAndContactDeletion(Contacts contacts, Groups groups) {
    for (GroupData g : groups) {
      for (ContactData c : contacts) {
        if (c.getGroups().contains(g)) {
          return g;
        }
      }
    }
    return null;
  }

  public ContactData searchContactForGroup(Contacts contacts, Groups groups) {
    for (ContactData contact : contacts) {
      if (contact.getGroups().size() < groups.size())
        return contact;
    }
    return null;
  }

  public ContactData contactAndDeletion(Contacts contacts, GroupData group) {
    for (ContactData c : contacts) {
      if (c.getGroups().contains(group))
        return c;
    }
    return null;
  }

}

  //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
  /*//WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
    //WebElement row = checkbox.findElement(By.xpath("./../.."));
    //List <WebElement> cells = row.findElements(By.tagName("td"));
    //cells.get(7).findElement((By.tagName("a")).click();
    //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
    //click(By.cssSelector(String.format("a[href^='edit.php?id=%s']", id)));
    //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    //wd.findElement(By.xpath("//a[@href='edit.php?id="+ index +"']/img[@title='Edit']")).click();
    //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img");
    //wd.findElement(By.xpath("//a[@href='edit.php?id="+ index +"']/img[@title='Edit']")).click();
    //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
    //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
    //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

      /*public void initContactModification (int index){

      wd.findElement(By.xpath("//a[@href='edit.php?id=" + index + "']/img[@title='Edit']")).click();
    }*/

