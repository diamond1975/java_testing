package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactModificationTest extends TestBase {

  @Test
  public void testContactModification () {
    app.getNavigationHelper().gotoContactPage();
    int before = app.getContactHelper().getContactCount ();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().creatContact ( new ContactData("Almaz", "Gabdullin", "new boss", "Moscow, prospect Mira, " +
              "d 16, rv 25", "89651249288", "89651249236", "89671245625",
              "diamond1976@yandex.ru", "diamond1977@yandex.ru", "diamond167@yandex.ru", "diamind"),true);
    }
    app.getContactHelper().selectContacts(before-1);
    app.getContactHelper().initContactModification ();
    app.getContactHelper().fillContactForm(
            new ContactData("Вагон", "Ivanov", "new boss", "Moscow, prospect Mira, " +
                    "d 16, rv 25", "89651249288", "89651249236", "89671245625",
                    "diamond1976@yandex.ru", "diamond1977@yandex.ru", "diamond167@yandex.ru", null),false);
    app.getContactHelper().submitContactModification ();
    app.getContactHelper().returnToContactPage();
    int after = app.getContactHelper().getContactCount ();
    Assert.assertEquals(after,before);
  }
}