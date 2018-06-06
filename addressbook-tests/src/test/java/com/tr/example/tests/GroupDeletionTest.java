package com.tr.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDeletionTest extends TestBase {


    @Test
    public void testGropDeletion() {
        //methods openSite & login are located in parent class TestBase
        app.getNavigationHelper().goToGroupPage();

        if (!app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().createGroup();
        }
        int before = app.getGroupHelper().getGroupCount();

        app.getGroupHelper().selectFirstGroup();

        app.getGroupHelper().deleteGroup();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        Assert.assertEquals(after, before - 1);

    }

}
