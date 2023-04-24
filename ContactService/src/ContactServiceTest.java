import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {
	@Test
    public void testAddContact() throws Exception {
        ContactService contactService = new ContactService();

        Contact contact1 = new Contact("9876", "Hutch", "Ellis", "9876543210", "321 Broad St");
        contactService.addContact(contact1);

        Contact contact2 = new Contact("5678", "John", "Doe", "0123456789", "123 Sue Dr");
        contactService.addContact(contact2);

        assertEquals(2, contactService.getContacts().size());
    }

    @Test
    public void testDeleteContact() throws Exception {
        ContactService contactService = new ContactService();

        Contact contact1 = new Contact("9876", "Hutch", "Ellis", "9876543210", "321 Broad St");
        contactService.addContact(contact1);

        Contact contact2 = new Contact("5678", "John", "Doe", "0123456789", "123 Sue Dr");
        contactService.addContact(contact2);

        contactService.deleteContact("9876");

        assertEquals(1, contactService.getContacts().size());
        assertNull(contactService.getContacts().stream().filter(c -> c.getContactID().equals("9876")).findFirst().orElse(null));
    }

    @Test
    public void testUpdateFirstName() throws Exception {
        ContactService contactService = new ContactService();

        Contact contact1 = new Contact("9876", "Hutch", "Ellis", "9876543210", "321 Broad St");
        contactService.addContact(contact1);

        contactService.updateFirstName("9876", "John");

        assertEquals("John", contactService.getContacts().get(0).getFirstName());
    }

    @Test
    public void testUpdateLastName() throws Exception {
        ContactService contactService = new ContactService();

        Contact contact1 = new Contact("9876", "Hutch", "Ellis", "9876543210", "321 Broad St");
        contactService.addContact(contact1);

        contactService.updateLastName("9876", "Doe");

        assertEquals("Doe", contactService.getContacts().get(0).getLastName());
    }

    @Test
    public void testUpdatePhone() throws Exception {
        ContactService contactService = new ContactService();

        Contact contact1 = new Contact("9876", "Hutch", "Ellis", "9876543210", "321 Broad St");
        contactService.addContact(contact1);

        contactService.updatePhone("9876", "0123456789");

        assertEquals("0123456789", contactService.getContacts().get(0).getPhone());
    }

    @Test
    public void testUpdateAddress() throws Exception {
        ContactService contactService = new ContactService();

        Contact contact1 = new Contact("9876", "Hutch", "Ellis", "9876543210", "321 Broad St");
        contactService.addContact(contact1);

        contactService.updateAddress("9876", "123 Sue Dr");

        assertEquals("123 Sue Dr", contactService.getContacts().get(0).getAddress());
    }

}
