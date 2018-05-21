package com.tr.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        //methods openSite & login are located in parent class TestBase
        app.goToContactPage();
        int before=app.getContactCount();
        app.initContactCreation();
        app.fillContactForms(new ContactData("Serg", "Goreli", "555 55 55", "serg@mail.com"));
        app.submitContactCreation();
        int after=app.getContactCount();
        Assert.assertEquals(after,before+1);
    }
}
