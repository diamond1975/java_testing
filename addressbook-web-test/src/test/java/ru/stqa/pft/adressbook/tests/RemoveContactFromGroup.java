package ru.stqa.pft.adressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import java.util.Iterator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RemoveContactFromGroup extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    Groups groups = app.db().groups();

    if (app.db().groups().size() == 0) {
      app.goTo().groupsPage();
      app.group().create(new GroupData().withName("diamind").withHeader("тест 22").withFooter("тест 44"));
      groups = app.db().groups();
    }
    app.goTo().contactPage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withName1("Almaz1").withName2("Gabdullin").withName3("Almazon")
              .withAddress("Moscow, prospect Mira, " + "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288")
              .withMobileWork("89651249236").withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru")
              .withEmail3("diamond167@yandex.ru").inGroups(groups.iterator().next()).withPhoto(new java.io.File("photo")), true);
    }
  }

  @Test
  public void testContactRemoveFromGroup() {
    Contacts contacts = app.db().contacts();
    Iterator<ContactData> iteratorContacts = contacts.iterator();
    ContactData contact = iteratorContacts.next();
    GroupData group = contact.getGroups().iterator().next();
    app.goTo().contactPage();

    while (iteratorContacts.hasNext()) {
      if (contact.getGroups().size() > 0) {
        group = contact.getGroups().iterator().next();
        app.contact().findGroupById(group.getId());
        break;
      } else {
        contact = iteratorContacts.next();
      }
    }
    app.contact().selectContactsById(contact.getId());
    app.contact().removeContactFromGroup();
    app.goTo().selectGroupPage(group.getId());
    Groups groupsContactsAfter = app.db().contactById(contact.getId()).iterator().next().getGroups();
    assertThat(groupsContactsAfter, equalTo(contact.getGroups().without(group)));

        }
}


