import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.Date;

public class AppointmentServiceTest {

    private AppointmentService appointmentService;

    @Before
    public void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    public void testAddAppointment() {
        // Create a valid appointment
        Appointment appointment = new Appointment("00001", new Date(), "Appointment 1");
        appointmentService.addAppointment(appointment);

        // Try to add the same appointment again
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(appointment));

        // Try to add an appointment with a duplicate ID
        Appointment duplicateAppointment = new Appointment("A0001", new Date(), "Duplicate Appointment");
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(duplicateAppointment));
    }

    @Test
    public void testDeleteAppointment() {
        // Create an appointment and add it to the service
        Appointment appointment = new Appointment("00001", new Date(), "Appointment 1");
        appointmentService.addAppointment(appointment);

        // Try to delete the appointment
        appointmentService.deleteAppointment("00001");

        // Try to delete the appointment again
        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("A0001"));

        // Try to delete a non-existing appointment
        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("A0002"));
    }
}