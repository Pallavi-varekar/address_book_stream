package com.bridgelabz;

import java.util.ArrayList;

public class AddressBook {
    ArrayList<Contact> addressbook = new ArrayList<Contact>();

    public ArrayList<Contact> addContact(Contact contact) {
        this.addressbook.add(contact);
        return this.addressbook;
    }

    public ArrayList<Contact> getAddressbook() {
        return addressbook;
    }

    public void setAddressbook(ArrayList<Contact> addressbook) {
        this.addressbook = addressbook;
    }
}
