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
import static ru.stqa.pft.adressbook.tests.TestBase.app;

public class IncreaseContactToGroupTests extends TestBase {
  @BeforeMethod
  public void ensurePreconditions() {
    Groups groups = app.db().groups();

    if (app.db().groups().size() == 0) {
      app.goTo().groupsPage();
      app.group().creat(new GroupData().withName("diamind").withHeader("тест 22").withFooter("тест 44"));
      groups = app.db().groups();
    }

    app.goTo().contactPage();
    if (app.db().contacts().size() == 0) {
      app.contact().creat(new ContactData().withName1("Almaz1").withName2("Gabdullin").withName3("Almazon")
              .withAddress("Moscow, prospect Mira, " + "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288")
              .withMobileWork("89651249236").withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru")
              .withEmail3("diamond167@yandex.ru").inGroups(groups.iterator().next()).withPhoto(new java.io.File("photo")), true);
    }
  }


  @Test
  public void testIncreaseAddedToGroup() {

    Groups groupsInTheBeginning = app.db().groups();
    Contacts contactInTheBeginning = app.db().contacts();

    ContactData selectedContact = contactInTheBeginning.iterator().next();
    Groups groupSelectedContact = (Groups) selectedContact.getGroups();

    GroupData selectedGroup;
    Iterator<ContactData> iteratorContacts = contactInTheBeginning.iterator();

    while (iteratorContacts.hasNext()) {
      if (groupSelectedContact.equals(groupsInTheBeginning)) {
        selectedContact = iteratorContacts.next();
        groupSelectedContact = (Groups) selectedContact.getGroups();
      } else {
        break;
      }
    }
    if (groupSelectedContact.equals(groupsInTheBeginning)) {
      app.goTo().groupsPage();
      app.group().creat(new GroupData().withName("testName"));
    }
    groupsInTheBeginning = app.db().groups();
    groupSelectedContact = (Groups) selectedContact.getGroups();
    groupsInTheBeginning.removeAll(groupSelectedContact);

    if (groupsInTheBeginning.size() > 0) {
      selectedGroup = groupsInTheBeginning.iterator().next();
    } else {
      throw new RuntimeException("no groups");
    }

    app.goTo().contactPage();
    app.contact().selectContactsById(selectedContact.getId());
    app.contact().addInGroupById(selectedGroup.getId());
    app.goTo().selectGroupPage(selectedGroup.getId());

    ContactData contactAfter = app.db().selectedcontactById(selectedContact.getId()).iterator().next();
    Groups groupsContactAfter = (Groups) contactAfter.getGroups();

    assertThat(groupsContactAfter, equalTo(groupSelectedContact.withAdded(selectedGroup)));

  }
}

