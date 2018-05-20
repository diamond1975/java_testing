package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

public class GroupDeletionTests extends TestBase {

  @Test
  public void tesrGroupDeletion() {
    app.getNavigationHelper().gotoGroupsPage();
    if (! app.getGroupHelper().isThereAggroup ()) {
      app.getGroupHelper().creatGroup(new GroupData("almaz", "Топаз", null, null));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectGroups();
    app.getGroupHelper().returnToGroupPage();

  }

}