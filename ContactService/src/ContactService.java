import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class ContactService {
	private Map<String, Contact> contacts = new HashMap<>();
	public List<Contact> getContacts() {
		  return new ArrayList<>(contacts.values());
	}

    public void addContact(Contact contact) throws Exception {
        if (contacts.containsKey(contact.getContactID())) {
            throw new Exception("Contact ID already exists");
        }

        contacts.put(contact.getContactID(), contact);
    }

    public void deleteContact(String contactID) {
        contacts.remove(contactID);
    }

    public void updateFirstName(String contactID, String firstName) throws Exception {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new Exception("Contact not found");
        }

        contact = new Contact(contact.getContactID(), firstName, contact.getLastName(), contact.getPhone(), contact.getAddress());
        contacts.put(contactID, contact);
    }

    public void updateLastName(String contactID, String lastName) throws Exception {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new Exception("Contact not found");
        }

        contact = new Contact(contact.getContactID(), contact.getFirstName(), lastName, contact.getPhone(), contact.getAddress());
        contacts.put(contactID, contact);
    }

    public void updatePhone(String contactID, String phone) throws Exception {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new Exception("Contact not found");
        }

        contact = new Contact(contact.getContactID(), contact.getFirstName(), contact.getLastName(), phone, contact.getAddress());
        contacts.put(contactID, contact);
    }

    public void updateAddress(String contactID, String address) throws Exception {
        Contact contact = contacts.get(contactID);
        if (contact == null) {
            throw new Exception("Contact not found");
        }

        contact = new Contact(contact.getContactID(), contact.getFirstName(), contact.getLastName(), contact.getPhone(), address);
        contacts.put(contactID, contact);
    }
}
