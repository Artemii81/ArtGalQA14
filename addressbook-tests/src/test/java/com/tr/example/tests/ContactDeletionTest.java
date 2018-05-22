package com.tr.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        //methods openSite & login are located in parent class TestBase
        app.getNavigationHelper().goToContactPage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().selectFirstContact();
        app.getContactHelper().deletContact();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before-1);

    }

}
