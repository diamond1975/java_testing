package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void tesrGroupDeletion() {
    app.getNavigationHelper().gotoGroupsPage();
    int before = app.getGroupHelper().getGroupCount ();
    if (! app.getGroupHelper().isThereAggroup ()) {
      app.getGroupHelper().creatGroup(new GroupData("diamind", "Топаз", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectGroups();
    app.getGroupHelper().returnToGroupPage();
    int after = app.getGroupHelper().getGroupCount ();
    Assert.assertEquals(after,before - 1);

  }

}