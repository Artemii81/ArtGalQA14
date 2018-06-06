package com.tr.example.tests;

import com.tr.example.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ContactCreationTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> validContacts() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader
                (new FileReader(new File("src/test/resources/contacts.csv")));
        String line = reader.readLine();
        while(line!=null){
            String[] split = line.split(";");
            list.add(new Object[]{new ContactData()
                    .withfName(split[0])
                    .withlName(split[1])
                    .withTelNamber(split[2])});
            line = reader.readLine();
        }
        return list.iterator();
    }


    @Test (dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
        //methods openSite & login are located in parent class TestBase
        app.getNavigationHelper().goToContactPage();
        int before= app.getContactHelper().getContactCount();


        app.getContactHelper().initContactCreation();

        File photo = new File("src/test/resources/HappyPassover.jpg");
        System.out.println(photo.exists());
        app.getContactHelper().fillContactForms(new ContactData()
                .withfName(contact.getName())
                .withlName(contact.getSecondName())
                .withTelNamber(contact.getTelNamber())
                .withMail("serg@mail.com")
                .withAdress("TA")
                .withPhoto(photo)
                .withGroup("test 0"));
        ;
                app.getContactHelper().submitContactCreation();
        int after= app.getContactHelper().getContactCount();
       Assert.assertEquals(after,before+1);
    }
}
