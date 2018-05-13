package ru.stqa.pft.adressbook;


import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.initGroupCreation();
    app.fillGroupForm(new GroupData("diamind", "тест33", "тест33", "тест44"));
    app.submitGroupCreation();
    app.returnToGroupPage();
  }

}