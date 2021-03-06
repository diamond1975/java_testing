package ru.stqa.pft.adressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    //type(By.name("group_header"), groupData.getHeader1());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectGroups() {
    click(By.name("delete"));
  }

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value= '" + id + "']")).click();

  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupsCache = null;
    returnToGroupPage();
  }

  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupsCache = null;
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectGroups();
    groupsCache = null;
    returnToGroupPage();
  }
    private void selectGroupInTopList(GroupData groupData) {
      Select dropdown = new Select(wd.findElement(By.name("group")));
      dropdown.selectByVisibleText(groupData.getName());
    }
  private void selectContact() {
    wd.findElement(By.name("selected[]")).click();
  }
  private void deleteFromSelectedGroup() {
    click(By.name("remove"));
  }
  public void deleteFromGroup(GroupData group) {
    selectGroupInTopList(group);
    selectContact();
    deleteFromSelectedGroup();
  }
  public int count(){
    return wd.findElements(By.name("selected[]")).size();
  }

  private Groups groupsCache = null;

  public Groups all() {
    if (groupsCache !=null) {
      return new Groups(groupsCache);
  }

    groupsCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupsCache.add(new GroupData().withId(id).withName(name).withHeader("тест22").withFooter("тест44"));
    }
    return new Groups(groupsCache);
  }

}
/*
*  public void delete(int index) {
    selectGroup(index);
    deleteSelectGroups();
    returnToGroupPage();
  }

   public boolean isThereAggroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

   public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element: elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }
    public void selectGroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }
* */