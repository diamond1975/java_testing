package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class СontactCreationTests extends TestBase {

  @Test
  public void testСontactCreation() {
    app.getNavigationHelper().gotoContactPage();
    List <ContactData> before = app.getContactHelper().getContactList ();
    //int before = app.getContactHelper().getContactCount ();
    ContactData contact = new ContactData("Almaz1975", "Gabdullin", null, "Moscow, prospect Mira, " +
            "d 16, rv 25", "89651249288", "89651249236", "89671245625",
            "diamond1976@yandex.ru", "diamond1977@yandex.ru", "diamond167@yandex.ru", "diamind");
    app.getContactHelper().creatContact(contact,true);
    List <ContactData> after = app.getContactHelper().getContactList ();
    //int after = app.getContactHelper().getContactCount ();
    Assert.assertEquals(after.size(),before.size()+1);

    //int max =0;
    //for (ContactData g : after) {
    //  if (g.getId() > max) {
    //   max = g.getId();
    //  }
    //}
    //Comparator<? super ContactData> byId = (Comparator<ContactData>) (o1, o2) -> Integer.compare(o1.getId(), o2.getId());
    //int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId();
    contact.setId (after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
  }

}