package com.lauri.oliovko11;

public class Contact {
    private String firstName;
    private String lastName;
    private String number;
    private String contactGroup;
    private int Id;
    private static int runningId;

    public Contact(String firstName, String lastName, String number, String contactGroup) {
        Id = ++runningId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.number = number;
        this.contactGroup = contactGroup;
    }

    public int getId(){
        return Id;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getNumber() {
        return number;
    }

    public String getFullName(){
        return firstName + " " + lastName;
    }

    public String getContactGroup() {
        return contactGroup;
    }
}
