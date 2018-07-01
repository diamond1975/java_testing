package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupsPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupData ().withName("diamind"));
    }
  }

  @Test
  public void tesrGroupDeletion() {
    Groups before = app.db().groups();
    GroupData deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.db().groups();
    assertEquals(after.size(),before.size() -1);
    assertThat(after, equalTo(before.without(deletedGroup)));
    verifyGroupListInUI();
  }
}
