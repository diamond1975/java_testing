package ru.stqa.pft.adressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.adressbook.TestBase1;

public class ContactDeletionTests extends TestBase1 {

    @Test
    public void testsContactDeletion() {

        gotoContactPage();
        selectContacts();
        deleteSelectContacts();
        returnToContactPage();

    }

}
