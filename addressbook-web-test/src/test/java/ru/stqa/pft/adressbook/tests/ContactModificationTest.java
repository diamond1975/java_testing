package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification () {
    app.getNavigationHelper().gotoContactPage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().creatContact ( new ContactData("Almaz", "Gabdullin", "new boss", "Moscow, prospect Mira, " +
              "d 16, rv 25", "89651249288", "89651249236", "89671245625",
              "diamond1976@yandex.ru", "diamond1977@yandex.ru", "diamond167@yandex.ru", "diamind"),true);
    }
    List<ContactData> before = app.getContactHelper().getContactList ();
    //int before = app.getContactHelper().getContactCount ();
    app.getContactHelper().selectContacts(before.size()-1);
    app.getContactHelper().initContactModification ();
    ContactData contact = new ContactData(before.get(before.size()-1).getId(),"Almaz", "Gabdullin", "new boss", "Moscow, prospect Mira, " +
            "d 16, rv 25", "89651249288", "89651249236", "89671245625",
            "diamond1976@yandex.ru", "diamond1977@yandex.ru", "diamond167@yandex.ru", null);
    app.getContactHelper().fillContactForm(contact,false);
    app.getContactHelper().submitContactModification ();
    app.getContactHelper().returnToContactPage();
    List <ContactData> after = app.getContactHelper().getContactList ();
    //int after = app.getContactHelper().getContactCount ();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }
  }
