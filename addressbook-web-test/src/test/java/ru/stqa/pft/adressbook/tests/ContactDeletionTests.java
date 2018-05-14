package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase1 {

    @Test
    public void testsContactDeletion() {

        app.getNavigationHelper1().gotoContactPage();
        app.getContactHelper().selectContacts();
        app.getContactHelper().deleteSelectContacts();
        app.getContactHelper().returnToContactPage();

    }

}