/**package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAddGroupTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditionsGroup() {
    Groups groups = app.db().groups();

    if (app.db().groups().size() == 0) {
      app.goTo().groupsPage();
      app.group().create(new GroupData().withName("diamind").withHeader("тест 22").withFooter("тест 44"));
      groups = app.db().groups();
    }
  }
  @BeforeMethod
  public void ensurePreconditionsContact() {
    if (app.db().contacts().size() == 0) {
      app.goTo().contactPage();
      app.contact().create (new ContactData()
              .withName1("Almaz1").withName2("Gabdullin").withName3("Almazon")
                      .withAddress("Moscow, prospect Mira, " + "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288")
                      .withMobileWork("89651249236").withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru")
                      .withEmail3("diamond167@yandex.ru"), true);
      app.goTo().contactPage();
    }
  }

  @Test(enabled = true)
  public void testContactAddGroup() {
    Contacts contacts = app.db().contacts();
    Groups groups = app.db().groups();
    ContactData editedContact = app.contact().searchContactForGroup(contacts, groups);
    GroupData group = app.contact().groupForContact(editedContact, groups);
    ContactData contactBefore = app.db().contact(editedContact.getId());
    app.goTo().contactPage();
    app.contact().contactAddGroup(editedContact, group);
    ContactData contactAfter = app.db().contact(editedContact.getId());
    assertThat(contactBefore.getGroups(), equalTo(contactAfter.getGroups().without(group)));
  }
}**/