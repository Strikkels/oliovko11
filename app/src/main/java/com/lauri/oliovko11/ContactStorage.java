package com.lauri.oliovko11;

import java.util.ArrayList;

public class ContactStorage {
    private ArrayList<Contact> contacts = new ArrayList<>();
    private static ContactStorage contactStorage = null;

    private ContactStorage(){
    }
    public static ContactStorage getInstance(){
        if(contactStorage == null){
            contactStorage = new ContactStorage();
        }
        return contactStorage;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
    public void addContact(Contact contact){
        contacts.add(contact);
    }

    public void removeContact(int contactId){
        int i = 0;
        for (Contact c : contacts) {
            if(c.getId() == (contactId)){
                break;
            }
            i++;
        }
        contacts.remove(i);
    }
}
