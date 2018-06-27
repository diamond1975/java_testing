package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {

      Groups groups = app.db().groups();

      if (app.db().groups().size() == 0) {
        app.goTo().groupsPage();
        app.group().creat(new GroupData().withName("diamind").withHeader("тест 22").withFooter("тест 44"));
        groups = app.db().groups();
      }

      app.goTo().contactPage();
      if ((app.db().contacts().size() == 0)) {
        app.contact().creat(new ContactData().withName1("Almaz1888").withName2("Gabdullin").withName3("Almazod").withAddress("Moscow, prospect Mira, " +
                        "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288").withMobileWork("89651249236")
                .withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru").withEmail3("diamond167@yandex.ru")
                .inGroups(groups.iterator().next()).withPhoto(new java.io.File("photo")),true);
      }
    }
    @Test (enabled = true)
    public void testContactModification() {
      app.goTo().contactPage();
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withName1("Almaz1889").withName2("Gabdullin").withName3("Almazod").withAddress("Moscow, prospect Mira, " +
                        "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288").withMobileWork("89651249236")
                .withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru").withEmail3("diamond167@yandex.ru");
        app.contact().modify(contact);
        //assertThat(app.contact(),equalTo(before.size()));Contacts after = app.db().contacts();Contacts after = app.db().contacts();
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
        verifyContactListtInUI();
    }
}
