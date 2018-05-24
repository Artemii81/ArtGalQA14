package com.tr.example.tests;

import com.tr.example.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

    @Test
    public void testContactCreation() {
        //methods openSite & login are located in parent class TestBase
        app.getNavigationHelper().goToContactPage();
        int before= app.getContactHelper().getContactCount();


        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForms(new ContactData()
                .whithfName("Serg")
                .whithlName("Goreli")
                .whithTelNamber("555 55 55")
                .whithMail("serg@mail.com")
                .whithAdress("TA"))
        ;
        app.getContactHelper().submitContactCreation();
        int after= app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before+1);
    }
}
