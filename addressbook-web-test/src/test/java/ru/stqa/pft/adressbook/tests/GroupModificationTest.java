package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
    app.goTo().groupsPage();
    app.group().create(new GroupData().withName("diamind"));
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("diamind").withHeader("тест22").withFooter("тест44");
    app.goTo().groupsPage();
    app.group().modify(group);
    Groups after = app.db().groups();
    assertEquals(after.size(), before.size());
    assertThat(after,equalTo(before.without(modifiedGroup).withDistrict(group)));
    verifyGroupListInUI();
  }
}
