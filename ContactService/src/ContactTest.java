import org.junit.Test;
import static org.junit.Assert.*;

public class ContactTest {
	@Test
    public void testGetters() {
        Contact contact = new Contact("9876", "Hutch", "Ellis", "9876543210", "123 Broad St");

        assertEquals("9876", contact.getContactID());
        assertEquals("Hutch", contact.getFirstName());
        assertEquals("Ellis", contact.getLastName());
        assertEquals("9876543210", contact.getPhone());
        assertEquals("321 Broad St", contact.getAddress());
    }
}
