package com.tr.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion(){
        //methods openSite & login are located in parent class TestBase
        app.goToContactPage();
        int before = app.getContactCount();
        app.selectFirstContact();
        app.deletContact();
        int after = app.getContactCount();
        Assert.assertEquals(after,before-1);

    }

}
