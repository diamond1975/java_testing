package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getNavigationHelper().gotoGroupsPage();
    if (!app.getGroupHelper().isThereAggroup()) {
      app.getGroupHelper().creatGroup(new GroupData("almaz", "Топаз", null, null));
    }
  }

  @Test
  public void tesrGroupDeletion() {
    List<GroupData> before = app.getGroupHelper().getGroupList ();
    app.getGroupHelper().selectGroup(before.size() -1);
    app.getGroupHelper().deleteSelectGroups();
    app.getGroupHelper().returnToGroupPage();
    List <GroupData> after = app.getGroupHelper().getGroupList ();
    Assert.assertEquals(after.size(),before.size()-1);

    before.remove(before.size()-1);
    Assert.assertEquals(before, after);
  }
  }
