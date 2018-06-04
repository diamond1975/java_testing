package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @Test
  public void tesrGroupDeletion() {
    app.getNavigationHelper().gotoGroupsPage();
    if (! app.getGroupHelper().isThereAggroup ()) {
      app.getGroupHelper().creatGroup(new GroupData("diamind", "Топаз", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList ();
    //int before = app.getGroupHelper().getGroupCount ();
    app.getGroupHelper().selectGroup(before.size() -1);
    app.getGroupHelper().deleteSelectGroups();
    app.getGroupHelper().returnToGroupPage();
    List <GroupData> after = app.getGroupHelper().getGroupList ();
    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }
  }
