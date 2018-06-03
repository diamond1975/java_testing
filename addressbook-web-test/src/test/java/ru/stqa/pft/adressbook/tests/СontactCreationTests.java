package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class СontactCreationTests extends TestBase {

  @Test
  public void testСontactCreation() {
    app.goTo().contactPage();
    List <ContactData> before = app.contact().list();
    ContactData contact = new ContactData().withName1("Almaz1975").withName2("Gabdullin").withName3(null).withAddress("Moscow, prospect Mira, " +
            "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288").withMobileWork("89651249236")
            .withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru").withEmail3("diamond167@yandex.ru")
            .withGroup("diamind").withGroup("diamind");
    app.contact().creat(contact,true);
    List <ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(),before.size()+1);

    //contact.setId (after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    before.add(contact);
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before,after);

  }

}