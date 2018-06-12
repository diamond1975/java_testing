package ru.stqa.pft.adressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class СontactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object []> validContact () throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line !=null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xStream = new XStream();
    xStream.processAnnotations(ContactData.class);
    List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
    return contacts.stream().map((g)-> new Object [] {g}).collect(Collectors.toList()).iterator();
  }

  @Test (dataProvider = "validContact")
  public void testСontactContact(ContactData contact) {
    app.goTo().contactPage();
    Contacts before = app.contact().all();
    //File photo = new File("src/test/resources/stru.JPG");
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

