
package ru.stqa.pft.adressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupsPage ();
    app.getGroupHelper().creatGroup(new GroupData("almaz", "Топаз", null, null));
  }

}