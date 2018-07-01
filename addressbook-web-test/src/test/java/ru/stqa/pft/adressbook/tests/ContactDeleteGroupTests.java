/**package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeleteGroupTests extends TestBase {

 @BeforeMethod
  public void ensurePreconditionsGroup() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupsPage();
      app.group().create(new GroupData().withName("diamind").withHeader("тест 22").withFooter("тест 44"));
    }
  }
  @BeforeMethod
  public void ensurePreconditionsContact() {
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      Groups groups = app.db().groups();
    app.contact().create(new ContactData().withName1("Almaz1").withName2("Gabdullin").withName3("Almazon")
            .withAddress("Moscow, prospect Mira, " + "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288")
            .withMobileWork("89651249236").withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru")
            .withEmail3("diamond167@yandex.ru").inGroups(groups.iterator().next()).withPhoto(new java.io.File("photo")), true);
      app.goTo().contactPage();
  }
}
  @BeforeMethod
  public void beforeMethodContactWithGroup() {
    app.goTo().contactPage();
    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();
    int i = 0;
    for (ContactData contact : contacts) {
      if (contact.getGroups().size() == 0)
        i++;
    }
    if (i == contacts.size()) {
      app.goTo().contactPage();
      app.contact().create(new ContactData()
              .withName1("Almaz1").withName2("Gabdullin").withName3("Almazon")
                      .withAddress("Moscow, prospect Mira, " + "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288")
                      .withMobileWork("89651249236").withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru")
                      .withEmail3("diamond167@yandex.ru").inGroups(groups.iterator().next()).withPhoto(new java.io.File("photo")), true);
      app.goTo().contactPage();
    }
  }

  @Test
  public void testContactDelGroup() {
    app.goTo().contactPage();
    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();
    GroupData group = app.contact().groupAndContactDeletion(contacts, groups);
    ContactData contact = app.contact().contactAndDeletion(contacts, group);
    ContactData contactBefore = app.db().contact(contact.getId());
    app.contact().deleteFromGroup(contact, group);
    ContactData contactAfter = app.db().contact(contact.getId());
    assertThat(contactBefore.getGroups(), equalTo( contactAfter.getGroups().withDistrict(group)));
  }
}
**/