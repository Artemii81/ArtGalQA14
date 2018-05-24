package com.tr.example.model;

public class ContactData {
    private  String fName;
    private  String lName;
    private  String telNamber;
    private  String mail;
    private String adress;

    public ContactData whithfName(String fName) {
        this.fName = fName;
        return this;
    }

    public ContactData whithlName(String lName) {
        this.lName = lName;
        return this;
    }

    public String getAdress() {
        return adress;
    }

    public ContactData whithAdress(String adress) {
        this.adress = adress;
        return this;
    }

    public ContactData whithTelNamber(String telNamber) {
        this.telNamber = telNamber;
        return this;
    }

    public ContactData whithMail(String mail) {
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
}
