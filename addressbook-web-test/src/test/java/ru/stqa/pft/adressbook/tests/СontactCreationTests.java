package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

public class СontactCreationTests extends TestBase {

  @Test
  public void testСontactCreation() {

    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().creatContact(new ContactData("Almaz", "Gabdullin", null, "Moscow, prospect Mira, " +
            "d 16, rv 25", "89651249288", "89651249236", "89671245625",
            "diamond1976@yandex.ru", "diamond1977@yandex.ru", "diamond167@yandex.ru", "almaz"),true);
  }

}