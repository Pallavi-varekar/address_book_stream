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


       /*
      Adding contacts to different address books by using addContact method means every single addressbook
      has multiple contacts
      */
        AddressBook addressBook1 = new AddressBook();
        addressBook1.addContact(person1);
        addressBook1.addContact(person2);
        AddressBook addressBook2 = new AddressBook();
        addressBook2.addContact(person3);
        addressBook2.addContact(person4);
        AddressBook addressBook3 = new AddressBook();
        addressBook3.addContact(person5);
        addressBook3.addContact(person3);
        AddressBook addressBook4 = new AddressBook();
        addressBook4.addContact(getInput());

    /*
    Creating hashmap of keys String type and value of addressbook
    */

        Map<String, AddressBook> map = new HashMap<>();
    /*
    putting different address books in the map. Map has two parts first one is key
    and Second one is value
    */

        map.put("addressBook1", addressBook1);
        map.put("addressBook2", addressBook2);
        map.put("addressBook3", addressBook3);
        map.put("addressBook4", addressBook4);
        String city = "jsp";
        String state = "Maharastra";


     /*
    Taking a new list of type Contact named as sortedaddressbook. In this we are sorting the contacts
    using their first name in alphabetically manner using Comparator and comparing by getting first name.
     */
        List<Contact> sortedaddressbook = addressBook.getAddressbook().stream().sorted(Comparator.comparing(Contact::getFirstName)).collect(Collectors.toList());

        sortedaddressbook.forEach(System.out::println);
    }    }
