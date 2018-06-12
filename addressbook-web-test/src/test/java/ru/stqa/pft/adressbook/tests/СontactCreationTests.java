package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.GroupData;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class СontactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object []> validContact () {
    List<Object []> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/stru.JPG");
    list.add(new Object[] {new ContactData().withName1("name1").withName2 ("name2").withPhoto(photo).withAddress("address")
    .withEmail1("email1").withEmail2("email2").withEmail3("email3").withMobileHome("MobileHome")
    .withMobile("Mobile").withMobileWork("MobileWork").withGroup("diamind")});
    list.add(new Object[] {new ContactData().withName1("first name3").withName2 ("last name 3").withPhoto(photo).withAddress("address 3")
            .withEmail1("test1@yandex.ru").withEmail2("test2@yandex.ru").withEmail3("test3@yandex.ru").withMobileHome("MobileHome 2")
            .withMobile("Mobile 2").withMobileWork("MobileWork 2").withGroup("diamind")});
    list.add(new Object[] {new ContactData().withName1("first name 3").withName2 ("last name 3").withPhoto(photo).withAddress("address 3")
            .withEmail1("test1@yandex.ru").withEmail2("test2@yandex.ru").withEmail3("test3@yandex.ru").withMobileHome("MobileHome 3")
            .withMobile("Mobile 3").withMobileWork("MobileWork").withGroup("diamind")});
    return list.iterator();
  }

  @Test (dataProvider = "validContact")
  public void testСontactContact(ContactData contact) {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
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


  /*ContactData contact = new ContactData().withName1("Almaz1975").withName2("Gabdullin").withName3(null).withPhoto(photo).withAddress("Moscow, prospect Mira, " +
          "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288").withMobileWork("89651249236")
          .withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru").withEmail3("diamond167@yandex.ru")
          .withGroup("diamind").withGroup("diamind");*/
}

