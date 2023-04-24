import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentTest {
    
    @Test
    public void testValidAppointment() {
        String appointmentID = "1234567890";
        Date appointmentDate = Calendar.getInstance().getTime();
        String description = "This is a valid appointment description.";
        
        Appointment appointment = new Appointment(appointmentID, appointmentDate, description);
        
        assertEquals(appointmentID, appointment.getAppointmentID());
        assertEquals(appointmentDate, appointment.getAppointmentDate());
        assertEquals(description, appointment.getDescription());
    }
    
    @Test
    public void testInvalidAppointmentID() {
        String appointmentID = "12345678901"; // More than 10 characters
        Date appointmentDate = Calendar.getInstance().getTime();
        String description = "This appointment ID is invalid.";
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentID, appointmentDate, description);
        });
    }
    
    @Test
    public void testNullAppointmentDate() {
        String appointmentID = "1234567890";
        Date appointmentDate = null;
        String description = "This appointment has a null appointment date.";
        
        assertThrows(NullPointerException.class, () -> {
            new Appointment(appointmentID, appointmentDate, description);
        });
    }
    
    @Test
    public void testPastAppointmentDate() {
        String appointmentID = "1234567890";
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        Date appointmentDate = calendar.getTime();
        String description = "This appointment has a past appointment date.";
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentID, appointmentDate, description);
        });
    }
    
    @Test
    public void testInvalidDescription() {
        String appointmentID = "1234567890";
        Date appointmentDate = Calendar.getInstance().getTime();
        String description = "This appointment description is definitely over 50 characters and should not pass the valid description.";
        
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(appointmentID, appointmentDate, description);
        });
    }
}