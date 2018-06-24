package ru.stqa.pft.adressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.slf4j.LoggerFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.Contacts;
import ru.stqa.pft.adressbook.model.Groups;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {
  //org.slf4j.Logger logger = LoggerFactory.getLogger(ContactCreationTests.class);

  @DataProvider
  public Iterator<Object[]> validContactFromXml() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")))) {
      String xml = "";
      String line = reader.readLine();
      while (line != null) {
        xml += line;
        line = reader.readLine();
      }
      XStream xStream = new XStream();
      xStream.processAnnotations(ContactData.class);
      List<ContactData> contacts = (List<ContactData>) xStream.fromXML(xml);
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @DataProvider
  public Iterator<Object[]> validContactFromJson() throws IOException {
    try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")))) {
      String json = "";
      String line = reader.readLine();
      while (line != null) {
        json += line;
        line = reader.readLine();
      }
      Gson gson = new Gson();
      List<ContactData> contacts = gson.fromJson(json, new TypeToken<List<ContactData>>() {
      }.getType());// List <ContactData>.class
      return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }
  }

  @Test(dataProvider = "validContactFromJson")
  public void testСontactContact(ContactData contact) {
    //logger.info("Start test testСontactContact");
    Groups groups = app.db().groups();
    app.goTo().contactPage();
    Contacts before = app.db().contacts();
    //File photo = new File("src/test/resources/stru.JPG");
    app.contact().initContactCreation();
    app.contact().creat(contact.withGroup("diamind"), true);
    Contacts after = app.db().contacts();
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }

  @Test
  public void testBadContactCreation() {
    //logger.info("Start test testBadContactCreation");
    app.goTo().contactPage();
    Contacts before = app.db().contacts();
    //File photo = new File("src/test/resources/stru.JPG");
    ContactData contact = new ContactData().withName1("Almaz1975'").withName2("Gabdullin").withName3("Almazon").withAddress("Moscow, prospect Mira, " +
            "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288").withMobileWork("89651249236")
            .withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru").withEmail3("diamond167@yandex.ru").withGroup("diamind");
    app.contact().creat(contact, true);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before));
    //logger.info("Stop test testBadContactCreation");
  }
}

