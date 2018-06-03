package ru.stqa.pft.adressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions () {
    app.goTo().contactPage();
    if (app.contact().all().size() == 0) {
      app.contact().creat(new ContactData().withName1("Almaz1975").withName2("Gabdullin").withName3(null).withAddress("Moscow, prospect Mira, " +
              "d 16, rv 25").withMobileHome("89651249288").withMobile("89651249288").withMobileWork("89651249236")
              .withEmail1("diamond1976@yandex.ru").withEmail2("diamond1977@yandex.ru").withEmail3("diamond167@yandex.ru")
              .withGroup("diamind").withGroup("diamind"),true);
    }
  }

  @Test
  public void testsContactDeletion() {
    Set<ContactData> before = app.contact().all();
    ContactData deleteContact = before.iterator().next();
    //int index = before.size() - 1;
    app.contact().delete(deleteContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deleteContact);
    Assert.assertEquals(before, after);
    }
}

