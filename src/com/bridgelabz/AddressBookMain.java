package com.bridgelabz;

import java.util.Scanner;

public class AddressBookMain {
    public static Contact getInput() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Add details of a person you want to edit");

        System.out.println("Please provide first name");
        String firstName = scanner.next();

        System.out.println("Please provide Last name");
        String lastName = scanner.next();

        System.out.println("Please provide address");
        String address = scanner.next();

        System.out.println("Please provide city");
        String city = scanner.next();

        System.out.println("Please provide state");
        String state = scanner.next();

        System.out.println("Please provide zip");
        int zipCode = scanner.nextInt();

        System.out.println("Please provide phone number");
        String mobileNumber = scanner.next();

        System.out.println("Please provide email");
        String email = scanner.next();

        Contact contact = new Contact(firstName, lastName, mobileNumber, email, city, state, zipCode);
        return contact;
    }


    public static void main(String[] args) {

        AddressBook addressBook = new AddressBook();
        Contact contact = getInput();
     /*
    Adding Contacts details using Constructor of person class
    */
        Contact person1 = new Contact("pallavi", "pqr", "1234561234", "pallavi@gmail.com", "jsp", "maharashtra", 416101);
        Contact person2 = new Contact("girish", "abc", "3456543452", "girish@gmail.com", "kolhapur", "maharashtra", 416111);
        Contact person3 = new Contact("onkar", "xyz", "9876785674", "onkar@gmail.com", "sangli", "maharashtra", 416117);
        Contact person4 = new Contact("snowbell", "suv", "7896785678", "snowbell@gmail.com", "ichalkarnji", "maharashtra", 416118);
        Contact person5 = new Contact("jimmya", "jvm", "9876785674", "jimmya@gmail.com", "karad", "maharashtra", 416119);


        addressBook.addContact(person1);
        addressBook.addContact(person2);
        addressBook.addContact(person3);
        addressBook.addContact(person4);
        addressBook.addContact(person5);
    /*
    Java Stream to check duplicate entry and add a contact if contact is not present by filtering the contact
    with firstname and last name of the address book which is declared in equals and hashcode method
    in Contact class.
     */


        addressBook.getAddressbook().stream().filter(a -> a.equals(contact)).findAny().orElseGet(() -> {
            addressBook.getAddressbook().add(contact);
            return contact;
        });
    /*
    Printing all the contacts using for-each loop
    */
        addressBook.getAddressbook().stream().forEach(x -> System.out.println(x));

    }

}
