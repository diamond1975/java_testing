package ru.stqa.pft.adressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("diamind", "тест33", "тест33", "тест44"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}