
package ru.stqa.pft.adressbook.tests;


import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.goTo().groupsPage();
    Groups before = app.group().all();
    GroupData group = new GroupData().withName("diamind888").withHeader1("тест33").withFooter("тест44");
    app.group().creat(group);
    Groups after = app.group().all();
    assertThat(after.size(), equalTo(before.size()+1));

    group.withId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) ->group.getId()).max().getAsInt()))));

  }
}
