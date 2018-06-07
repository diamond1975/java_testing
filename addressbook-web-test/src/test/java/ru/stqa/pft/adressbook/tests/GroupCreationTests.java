
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
    GroupData group = new GroupData().withName("diamind").withHeader1("тест33").withFooter("тест44");
    app.group().creat(group);
    assertThat(app.group().count(), equalTo(before.size()+1));
    Groups after = app.group().all();
    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((f) ->f.getId()).max().getAsInt()))));

  }
 @Test
  public void testGroupBadCreation() {
   app.goTo().groupsPage();
   Groups before = app.group().all();
   GroupData group = new GroupData().withName("diamind'").withHeader1("тест33").withFooter("тест44");
   app.group().creat(group);
   assertThat(app.group().count(), equalTo(before.size()));
   Groups after = app.group().all();
   assertThat(after, equalTo(before));

 }
}
