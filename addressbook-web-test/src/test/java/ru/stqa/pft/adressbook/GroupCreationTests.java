package ru.stqa.pft.adressbook;


import org.testng.annotations.Test;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    initGroupCreation();
    fillGroupForm(new GroupData("diamind", "тест33", "тест33", "тест44"));
    submitGroupCreation();
    returnToGroupPage();
  }

}