package sample;

import java.util.List;
import java.util.stream.Collectors;

public class AddressBookMain {
    public static void main(String[] args) {
  
        AddressBook addressBook = new AddressBook();

        Contact newContact = new Contact("Savita", "Teakle", "Bhokar", "Nanded", "CA", "12345",
                "7890654390", "savitatekale1234@gmail.com");
        addressBook.addContact(newContact);

        Contact anotherContact = new Contact("yogesh", "gunde", "Pune", "Maharastra", "NY", "67890",
                "9087654389", "yogesh8800@gmail.com");
        addressBook.addContact(anotherContact);

        Contact updatedContact = new Contact("Savita", "Tekale", "456 New St", "Cityville", "CA", "12345",
                "5550894321", "savitatekale1234@gmail.com");
        addressBook.editContact("Savita", "Tekale", updatedContact);

        addressBook.deleteContact("yogesh", "gunde");

        List<Contact> uniqueContacts = addressBook.getContacts().stream()
                .distinct()
                .collect(Collectors.toList());

      
        System.out.println("All Contacts in the Address Book:");
        for (Contact contact : uniqueContacts) {
            System.out.println(contact);
        }

        System.out.println("\nContacts in Cityville:");
        List<Contact> cityContacts = addressBook.searchByCity("Cityville");
        cityContacts.forEach(System.out::println);

        System.out.println("\nContacts in California:");
        List<Contact> stateContacts = addressBook.searchByState("CA");
        stateContacts.forEach(System.out::println);

        long cityCount = cityContacts.size();
        long stateCount = stateContacts.size();
        System.out.println("\nNumber of contacts in Cityville: " + cityCount);
        System.out.println("Number of contacts in California: " + stateCount);

        addressBook.sortByFirstName();
        System.out.println("\nContacts sorted by first name:");
        addressBook.getContacts().forEach(System.out::println);

        addressBook.sortByCity();
        System.out.println("\nContacts sorted by city:");
        addressBook.getContacts().forEach(System.out::println);
       
        addressBook.sortByState();
        System.out.println("\nContacts sorted by state:");
        addressBook.getContacts().forEach(System.out::println);
        
        addressBook.sortByZip();
        System.out.println("\nContacts sorted by Zip:");
        addressBook.getContacts().forEach(System.out::println);
        
        addressBook.editEmail(stateCount, stateCount, null);
        System.out.println("\nContacts sorted by Email:");
        addressBook.getContacts().forEach(System.out::println);
         

    }
}

