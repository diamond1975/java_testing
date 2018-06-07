package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTest extends TestBase{

  @Test
  public void testContactPhones ()  {
    app.goTo().contactPage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFormEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllPhones(), equalTo (mergePhones(contactInfoFormEditForm)));

    //assertThat(contact.getMobileHome(), equalTo (cleaned(contactInfoFormEditForm.getMobileHome())));
    //assertThat(contact.getMobile(), equalTo(cleaned(contactInfoFormEditForm.getMobile())));
    //assertThat(contact.getMobileWork(), equalTo(cleaned(contactInfoFormEditForm.getMobileWork())));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getMobileHome(),contact.getMobile(),contact.getMobileWork())
            .stream().filter((s)-> ! s.equals(""))
            .map(ContactPhoneTest::cleaned)
            .collect(Collectors.joining("\n"));
  }


  public static String cleaned (String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
