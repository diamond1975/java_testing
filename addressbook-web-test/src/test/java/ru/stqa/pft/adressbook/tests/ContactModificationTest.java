package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class ContactModificationTest extends TestBase1 {

  @Test
  public void testContactModification () {
    app.getNavigationHelper1().gotoContactPage();
    app.getContactHelper().selectContacts();
    app.getContactHelper().initContactModification ();
    app.getContactHelper().fillContactForm(
            new ContactData("Almaz", "Gabdullin", "new boss", "Moscow, prospect Mira, " +
                    "d 16, rv 25", "89651249288", "89651249236", "89671245625",
                    "diamond1976@yandex.ru", "diamond1977@yandex.ru", "diamond167@yandex.ru"));
    app.getContactHelper().submitContactModification ();
    app.getContactHelper().returnToContactPage();

  }
}
