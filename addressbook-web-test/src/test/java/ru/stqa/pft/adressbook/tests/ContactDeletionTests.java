package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletionTests extends TestBase1 {

    @Test
    public void testsContactDeletion() {

        app.gotoContactPage();
        app.selectContacts();
        app.deleteSelectContacts();
        app.returnToContactPage();

    }

}
