package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.Set;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupsPage();
    if (app.group().all().size() == 0) {
      app.group().creat(new GroupData ().withName("diamind"));
    }
  }

  @Test
  public void tesrGroupDeletion() {
    Set<GroupData> before = app.group().all();
    GroupData deletedGroup = before.iterator().next();
    //int index = before.size() -1;
    app.group().delete(deletedGroup);
    Set <GroupData> after = app.group().all();
    Assert.assertEquals(after.size(),before.size() -1);

    before.remove(deletedGroup);
    Assert.assertEquals(before, after);
  }
}
