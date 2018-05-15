package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testsContactDeletion() {

        app.getNavigationHelper().gotoContactPage();
        app.getContactHelper().selectContacts();
        app.getContactHelper().deleteSelectContacts();
        app.getContactHelper().returnToContactPage();

    }

}