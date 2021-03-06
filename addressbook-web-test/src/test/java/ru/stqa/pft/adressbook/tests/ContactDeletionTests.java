package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    Groups groups = app.db().groups();

    if (app.db().groups().size() == 0) {
      app.goTo().groupsPage();
      app.group().create(new GroupData().withName("diamind").withFooter("тест 22").withHeader("тест 44"));
      groups = app.db().groups();
    }

    app.goTo().contactPage();
    if (app.db().contacts().size() == 0) {
      app.contact().create(new ContactData().withName1("Almaz1975").withName2("Gabdullin").withName3(null).withAddress("Moscow, prospect Mira, " +
              "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288").withMobileWork("89651249236")
              .withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru").withEmail3("diamond167@yandex.ru")
              .inGroups(groups.iterator().next()).withPhoto(new java.io.File("photo")),true);
    }
  }

  @Test
  public void testsContactDeletion() {
    Contacts before = app.db().contacts();
    ContactData deleteContact = before.iterator().next();
    app.contact().delete(deleteContact);
    //assertThat(app.contact(),equalTo(before.size()-1));
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deleteContact)));
    verifyContactListtInUI();
  }
}

