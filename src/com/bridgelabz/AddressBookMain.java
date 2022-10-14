package com.bridgelabz;

import java.util.*;
import java.util.stream.Collectors;

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


        AddressBook addressBookObj = new AddressBook();
        Contact person1 = new Contact("pallavi", "pqr", "1234561234", "pallavi@gmail.com", "jsp", "maharashtra", 416101);
        Contact person2 = new Contact("girish", "abc", "3456543452", "girish@gmail.com", "kolhapur", "maharashtra", 416111);
        Contact person3 = new Contact("onkar", "xyz", "9876785674", "onkar@gmail.com", "sangli", "maharashtra", 416117);
        Contact person4 = new Contact("snowbell", "suv", "7896785678", "snowbell@gmail.com", "ichalkarnji", "maharashtra", 416118);
        Contact person5 = new Contact("jimmya", "jvm", "9876785674", "jimmya@gmail.com", "karad", "maharashtra", 416119);
        Contact person6 = new Contact("soham", "ssv", "9860252503", "sohamssv@gmail.com", "vadgaon", "maharastra", 416302);
    /*
    Adding contacts to different address books by using addContact method means every single addressbook
    has multiple contacts
    */
        AddressBook addressBook = new AddressBook();
        addressBook.addContact(person1);
        addressBook.addContact(person2);
        addressBook.addContact(person3);
        addressBook.addContact(person4);
        addressBook.addContact(person6);
        addressBook.addContact(person5);
        Contact contact = getInput();
        addressBook.addContact(contact);

    /*
    Taking a new list of type Contact named as sortedByName,sortedByCity,sortedByZipCode and sortedByState .
    In this we are sorting the contacts using their name,city zipcode and state in alphabetically manner
    using Comparator and comparing.
    */

        List<Contact> sortedByCity = addressBook.getAddressbook().stream().sorted(Comparator.comparing(Contact::getCity)).collect(Collectors.toList());

        List<Contact> sortedByZipCode = addressBook.getAddressbook().stream().sorted(Comparator.comparing(Contact::getZipCode)).collect(Collectors.toList());

        List<Contact> sortedByState = addressBook.getAddressbook().stream().sorted(Comparator.comparing(Contact::getState)).collect(Collectors.toList());

    /*
    Printing the different sorted list one by one
    */
        System.out.println("Contacts sorted by City are : ");
        sortedByCity.forEach(System.out::println);
        System.out.println();
        System.out.println("Contacts sorted by State are : ");
        sortedByState.forEach(System.out::println);
        System.out.println();
        System.out.println("Contacts sorted by ZipCode are : ");
        sortedByZipCode.forEach(System.out::println);
        System.out.println();
        System.out.println();

    /*
    Multiple sorting is done by using thenComparing keyword in this we are sorting by city and state
    both simultaneously
    */

        List<Contact> sortedByCityAndState = addressBook.getAddressbook().stream().sorted(Comparator.comparing(Contact::getCity).thenComparing(Contact::getState)).collect(Collectors.toList());


    /*
    Printed the sorted list by city and state both
     */
        System.out.println("Contacts which are sorted by city and state : ");
        sortedByCityAndState.forEach(System.out::println);
        System.out.println();

    /*
    Another way to do multiple sorting by using multiple fields
    */
        Comparator<Contact> compareByCity = Comparator.comparing(Contact::getCity);
        Comparator<Contact> compareByState = Comparator.comparing(Contact::getState);
        Comparator<Contact> compareByZipCode = Comparator.comparing(Contact::getZipCode);


        // sorting on multiple fields (3-level) using Method Reference

        List<Contact> sortedByCityStateAndZipCode = addressBook.getAddressbook().stream().sorted(compareByZipCode.thenComparing(compareByState).thenComparing(compareByCity)).collect(Collectors.toList());

    /*
    Printing the Multiple fields sorted Contact list using for-each loop
    */
        System.out.println("Contacts which are sorted by city,state and zipcode are : ");
        sortedByCityStateAndZipCode.forEach(System.out::println);


    }}

