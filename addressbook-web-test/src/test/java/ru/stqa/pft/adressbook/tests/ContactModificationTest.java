package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
      app.goTo().contactPage();
        if (app.db().contacts().size() == 0) { //Условие, если  n=0
                app.contact().creat(new ContactData().withName1("Almaz1988").withName2("Gabdullin").withName3("Almazon")
                        .withPhoto(new java.io.File("photo")).withAddress("Moscow, prospect Mira, " +
                        "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288").withMobileWork("89651249236")
                        .withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru")
                        .withEmail3("diamond167@yandex.ru"),true);

        }
    }

    @Test
    public void testContactModification() {
      app.goTo().contactPage();
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId()).withName1("Almaz1888").withName2("Gabdullin").withName3("Almazod").withAddress("Moscow, prospect Mira, " +
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
