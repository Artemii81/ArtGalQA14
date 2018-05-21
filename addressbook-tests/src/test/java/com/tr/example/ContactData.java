package com.tr.example;

public class ContactData {
    private final String name;
    private final String secondName;
    private final String telNamber;
    private final String mail;

    public ContactData(String name, String secondName, String telNamber, String mail) {
        this.name = name;
        this.secondName = secondName;
        this.telNamber = telNamber;
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getTelNamber() {
        return telNamber;
    }

    public String getMail() {
        return mail;
    }
}
