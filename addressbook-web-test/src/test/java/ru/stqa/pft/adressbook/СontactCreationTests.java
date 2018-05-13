package ru.stqa.pft.adressbook;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.tests.ContactData;

public class СontactCreationTests extends TestBase1 {

  @Test
  public void testСontactCreation() {

    gotoContactPage ();
    initContactCreation();
    fillContactForm(
            new ContactData("Almaz", "Gabdullin", "new boss", "Moscow, prospect Mira, " +
                    "d 16, rv 25", "89651249288", "89651249236", "89671245625",
                    "diamond1976@yandex.ru", "diamond1977@yandex.ru", "diamond167@yandex.ru"));
    submitContactCreation();
    returnToContactPage();
  }

}
