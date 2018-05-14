package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupModificationTest extends TestBase{

  @Test
  public void testGroupModification () {
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupForm(new GroupData("diamind", "тест33", "тест33", "тест44"));
    app.getGroupHelper().submitGroupModification ();
    app.getGroupHelper().returnToGroupPage();
  }
}
