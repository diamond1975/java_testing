package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class СontactCreationTests extends TestBase {

  @Test
  public void testСontactCreation() {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.JPG");
    ContactData contact = new ContactData().withName1("Almaz1975").withName2("Gabdullin").withName3(null).withPhoto(photo).withAddress("Moscow, prospect Mira, " +
            "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288").withMobileWork("89651249236")
            .withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru").withEmail3("diamond167@yandex.ru")
            .withGroup("diamind").withGroup("diamind");
    app.contact().creat(contact,true);
    Contacts after = app.contact().all();
    assertThat(app.contact().count(),equalTo(before.size()+1));
    assertThat(after,equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g)-> g.getId()).max().getAsInt()))));
  }
  @Test
  public void testBadContactCreation() {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.JPG");
    ContactData contact = new ContactData().withName1("Almaz1975'").withName2("Gabdullin").withName3(null).withPhoto(photo).withAddress("Moscow, prospect Mira, " +
            "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288").withMobileWork("89651249236")
            .withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru").withEmail3("diamond167@yandex.ru")
            .withGroup("diamind").withGroup("diamind");
    app.contact().creat(contact,true);
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after,equalTo(before));
  }
}

