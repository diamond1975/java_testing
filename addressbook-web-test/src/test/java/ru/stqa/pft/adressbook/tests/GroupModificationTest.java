package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTest extends TestBase {

  @Test
  public void testGroupModification() {
    app.getNavigationHelper().gotoGroupsPage();
    if (!app.getGroupHelper().isThereAggroup()) {
      app.getGroupHelper().creatGroup(new GroupData("almaz", "Топаз", null, null));
    }
    List<GroupData> before = app.getGroupHelper().getGroupList ();
    app.getGroupHelper().selectGroup(before.size()-1);
    app.getGroupHelper().initGroupModification();
    GroupData group = new GroupData(before.get(before.size()-1).getId(),"diamind", "тест33", "тест33", "тест44");
    app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    List <GroupData> after = app.getGroupHelper().getGroupList ();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(group);
    Comparator<? super GroupData> byId =  (g1, g2)-> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
}
