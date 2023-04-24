import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AppointmentService {
	private Map<String, Appointment> appointments;

    public AppointmentService() {
        appointments = new HashMap<>();
    }

    public void addAppointment(Appointment appointment) {
        String appointmentID = appointment.getAppointmentID();
        if (appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }
        appointments.put(appointmentID, appointment);
    }

    public void deleteAppointment(String appointmentID) {
        if (!appointments.containsKey(appointmentID)) {
            throw new IllegalArgumentException("Appointment ID not found");
        }
        appointments.remove(appointmentID);
    }

    public List<Appointment> getAppointments() {
        return new ArrayList<>(appointments.values());
    }
}