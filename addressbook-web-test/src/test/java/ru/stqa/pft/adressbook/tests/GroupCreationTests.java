
package ru.stqa.pft.adressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupsPage ();
    int before = app.getGroupHelper().getGroupCount ();
    app.getGroupHelper().creatGroup(new GroupData("diamind", "Топаз", "grom", "ret"));
    int after = app.getGroupHelper().getGroupCount ();
    Assert.assertEquals(after,before+1);
  }

}