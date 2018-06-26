package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.model.ContactData;
import ru.stqa.pft.adressbook.model.GroupData;
import ru.stqa.pft.adressbook.model.Groups;

import java.util.Arrays;
import java.util.stream.Collectors;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneAdressEmailTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        Groups groups = app.db().groups();
        if (app.db().groups().size() == 0) {
            app.goTo().groupsPage();
            app.group().creat(new GroupData().withName("diamond").withFooter("тест 22").withHeader("тест 44"));
            groups = app.db().groups();
        }
      app.goTo().contactPage();
      if (app.db().contacts().size() == 0) {
        app.contact().creat(new ContactData().withName1("Almaz").withName2("Gabdullin")
                .withMobileHome("55555").withMobile("8888").withMobileWork("99999").inGroups(groups.iterator().next()), true);
      }
    }
    @Test
    public void testContactPhones() {
        app.goTo().contactPage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFormEditForm = app.contact().infoFromEditForm(contact);
        assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFormEditForm)));
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
