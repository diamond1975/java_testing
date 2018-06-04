package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class СontactCreationTests extends TestBase {

  @Test
  public void testСontactCreation() {
    app.getNavigationHelper().gotoContactPage();
    List <ContactData> before = app.getContactHelper().getContactList ();
    ContactData contact = new ContactData("Almaz1975", "Gabdullin", null, "Moscow, prospect Mira, " +
            "d 16, rv 25", "89651249288", "89651249236", "89671245625",
            "diamond1976@yandex.ru", "diamond1977@yandex.ru", "diamond167@yandex.ru", "diamind");
    app.getContactHelper().creatContact(contact,true);
    List <ContactData> after = app.getContactHelper().getContactList ();

    Assert.assertEquals(after.size(),before.size()+1);

    contact.setId (after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);
  }

}