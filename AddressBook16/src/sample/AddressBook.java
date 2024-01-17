package sample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBook {

	    private List<Contact> contacts = new ArrayList<>();

	    public void addContact(Contact contact) {
	        contacts.add(contact);
	    }

	    public void editContact(String firstName, String lastName, Contact updatedContact) {
	        contacts.removeIf(contact -> contact.getFirstName().equals(firstName) &&
	                contact.getLastName().equals(lastName));
	        contacts.add(updatedContact);
	    }

	    public void deleteContact(String firstName, String lastName) {
	        contacts.removeIf(contact -> contact.getFirstName().equals(firstName) &&
	                contact.getLastName().equals(lastName));
	    }

	    public List<Contact> searchByCity(String city) {
	        return contacts.stream()
	                .filter(contact -> contact.getCity().equalsIgnoreCase(city))
	                .collect(Collectors.toList());
	    }

	    public List<Contact> searchByState(String state) {
	        return contacts.stream()
	                .filter(contact -> contact.getState().equalsIgnoreCase(state))
	                .collect(Collectors.toList());
	    }

	    public void sortByFirstName() {
	        contacts.sort(Comparator.comparing(Contact::getFirstName));
	    }

	    public void sortByCity() {
	        contacts.sort(Comparator.comparing(Contact::getCity));
	    }

	    public void sortByState() {
	        contacts.sort(Comparator.comparing(Contact::getState));
	    }


	    public List<Contact> getContacts() {
	        return contacts;
	    }
	    public void sortByZip() {
	        contacts.sort(Comparator.comparing(Contact::getZip));
	    }


		public void editEmail(Object firstName, Object lastName, String newEmail) {
			   for (Contact contact : contacts) {
		            if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
		                contact.setEmail(newEmail);
		            }
		        }
			
		}

}