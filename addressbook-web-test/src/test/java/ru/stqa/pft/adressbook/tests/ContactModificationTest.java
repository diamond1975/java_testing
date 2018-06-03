package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.*;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    app.getNavigationHelper().gotoContactPage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().creatContact ( new ContactData("Almaz", "Gabdullin", "new boss", "Moscow, prospect Mira, " +
              "d 16, rv 25", "89651249288", "89651249236", "89671245625",
              "diamond1976@yandex.ru", "diamond1977@yandex.ru", "diamond167@yandex.ru", "diamind"),true);
    }
  }

  @Test
  public void testContactModification () {
    List<ContactData> before = app.getContactHelper().getContactList ();
    int index = before.size()-1;
    ContactData contact = new ContactData(before.get(index).getId(),"Almaz", "Gabdullin", "new boss", "Moscow, prospect Mira, " +
            "d 16, rv 25", "89651249288", "89651249236", "89671245625",
            "diamond1976@yandex.ru", "diamond1977@yandex.ru", "diamond167@yandex.ru", null);
    app.getContactHelper().modifyContact(index, contact);
    List <ContactData> after = app.getContactHelper().getContactList ();
    Assert.assertEquals(after.size(),before.size());

    before.remove(index);
    before.add(contact);

    Comparator<? super ContactData> byId = (g1,g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }
}
