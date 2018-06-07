package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase{

  @Test
  public void testContactPhones ()  {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFormEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getMobileHome(), equalTo (cleaned(contactInfoFormEditForm.getMobileHome())));
    assertThat(contact.getMobile(), equalTo(cleaned(contactInfoFormEditForm.getMobile())));
    assertThat(contact.getMobileWork(), equalTo(cleaned(contactInfoFormEditForm.getMobileWork())));
  }
  public String cleaned (String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
