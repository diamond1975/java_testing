
package ru.stqa.pft.adressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;

import java.util.Comparator;
import java.util.Set;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupsPage();
    Set<GroupData> before = app.group().all();
    GroupData group = new GroupData().withName("diamind888").withHeader1("тест33").withFooter("тест44");
    app.group().creat(group);
    Set <GroupData> after = app.group().all();
    Assert.assertEquals(after.size(), before.size()+1);

    group.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());

    group.withId(after.stream().mapToInt((g) ->group.getId()).max().getAsInt());
    before.add(group);
    Assert.assertEquals(before, after);

    //Comparator<? super GroupData> byId =(g1, g2) -> Integer.compare(g1.getId(),g2.getId());
    //Assert.assertEquals(before,after);
  }
}
