package com.tr.example.model;

import java.io.File;

public class ContactData {
    private  String fName;
    private  String lName;
    private  String telNamber;
    private  String mail;
    private String adress;
    private String group;
    private File photo;

    public String getGroup() {
        return group;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

     public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }



    public ContactData withfName(String fName) {
        this.fName = fName;
        return this;
    }

    public ContactData withlName(String lName) {
        this.lName = lName;
        return this;
    }

    public String getAdress() {
        return adress;
    }

    public ContactData withAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public ContactData withTelNamber(String telNamber) {
        this.telNamber = telNamber;
        return this;
    }

    public ContactData withMail(String mail) {
        this.mail = mail;
        return this;
    }


    public String getName() {
        return fName;
    }

    public String getSecondName() {
        return lName;
    }

    public String getTelNamber() {
        return telNamber;
    }

    public String getMail() {
        return mail;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", telNamber='" + telNamber + '\'' +
                '}';
    }
}
