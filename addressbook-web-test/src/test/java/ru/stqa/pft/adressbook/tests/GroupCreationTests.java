
package ru.stqa.pft.adressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.List;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupsPage ();
    List <GroupData> before = app.getGroupHelper().getGroupList ();
    //int before = app.getGroupHelper().getGroupCount ();
    app.getGroupHelper().creatGroup(new GroupData("diamind", "Топаз", "grom", "ret"));
    List <GroupData> after = app.getGroupHelper().getGroupList ();
    //int after = app.getGroupHelper().getGroupCount ();
    Assert.assertEquals(after.size(), before.size()+1);
  }

}