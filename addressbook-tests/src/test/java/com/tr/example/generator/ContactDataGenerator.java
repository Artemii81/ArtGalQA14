package com.tr.example.generator;

import com.tr.example.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {
    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);
        List<ContactData> contacts = generateContacts(count);

        save(contacts, file);
    }

    private static void save(List<ContactData> contacts, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (ContactData contact : contacts){
            writer.write(String.format("%s;%s;%s\n",
                    contact.getName(),contact.getSecondName(),contact.getTelNamber()));
        }
        writer.close();
    }

    private static List<ContactData> generateContacts(int count) {
        List<ContactData> contacts = new ArrayList<ContactData>();

        for(int i=0; i<count; i++){
            contacts.add(new ContactData()
                    .withfName(String.format("name %s",i))
                    .withlName(String.format("lname %s",i))
                    .withTelNamber(String.format("888888 %s", i)));
        }

        return contacts;
    }
}
