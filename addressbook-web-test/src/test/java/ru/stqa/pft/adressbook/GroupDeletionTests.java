package ru.stqa.pft.adressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

    @Test
    public void tesrGroupDeletion() {

        app.selectGroup();
        app.deleteSelectGroups();
        app.returnToGroupPage();

    }

}
