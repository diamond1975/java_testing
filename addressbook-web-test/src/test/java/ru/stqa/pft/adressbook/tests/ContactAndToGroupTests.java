package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static ru.stqa.pft.adressbook.tests.TestBase.app;

public class ContactAndToGroupTests {
  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupsPage();
      app.group().creat(new GroupData().withName("diamond").withFooter("тест 22").withHeader("тест 44"));
    }

    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().creat(new ContactData()
              .withName1("Almaz").withName2("Gabdullin").withMobileHome("55555").withMobile("8888")
              .withMobileWork("99999"),true);

    }
    app.goTo().contactPage();
  }


  @Test
  public void testContactAddToGroup() {
    Groups groups = app.db().groups();
    Contacts before = app.db().contacts();
    ContactData contactToAdd = before.iterator().next();
    ContactData contact = new ContactData().withId(contactToAdd.getId())
            .withName1(contactToAdd.getName1()).withName2(contactToAdd.getName2()).withName3(contactToAdd.getName3())
            .withMobileHome(contactToAdd.getMobileHome()).withMobile(contactToAdd.getMobile())
            .withMobileWork(contactToAdd.getMobileWork()).withEmail1(contactToAdd.getEmail1())
            .withEmail2(contactToAdd.getEmail2()).withEmail3(contactToAdd.getEmail3()).withAddress(contactToAdd.getAddress())
            .inGroups(groups.iterator().next());

    app.contact().add(contact);
    app.goTo().contactPage();
    Contacts after = app.db().contacts();

    assertThat(after, equalTo(before.without(contactToAdd).withAdded(groups.withAdded(groups))));
  }

}
