package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneAdressEmailTest extends TestBase {

    @Test
    public void testContactPhones() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFormEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFormEditForm)));

        //assertThat(contact.getMobileHome(), equalTo (cleaned(contactInfoFormEditForm.getMobileHome())));
        //assertThat(contact.getMobile(), equalTo(cleaned(contactInfoFormEditForm.getMobile())));
        //assertThat(contact.getMobileWork(), equalTo(cleaned(contactInfoFormEditForm.getMobileWork())));
    }
    @Test
    public void testContactEmailAddress() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFormEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAddress(), equalTo(contactInfoFormEditForm.getAddress()));
        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFormEditForm)));
    }
    public String mergePhones(ContactData contact) {
        return Arrays.asList(contact.getMobileHome(), contact.getMobile(), contact.getMobileWork())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneAdressEmailTest::cleaned)
                .collect(Collectors.joining("\n"));
    }
    public String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail1(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> !s.equals(""))
                .map(ContactPhoneAdressEmailTest::cleaned)
                .collect(Collectors.joining("\n"));
    }


    public static String cleaned(String PhoneEmail) {
        return PhoneEmail.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}
