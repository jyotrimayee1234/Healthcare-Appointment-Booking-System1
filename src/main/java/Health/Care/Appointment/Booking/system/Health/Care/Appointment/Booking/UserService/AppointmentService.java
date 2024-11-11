package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.Repository.AppointmentRepository;
import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserEntity.Appointment;

@Service
	public class AppointmentService {
	    @Autowired
	    private AppointmentRepository appointmentRepository;

	    public Appointment bookAppointment(Appointment appointment) {
	        return appointmentRepository.save(appointment);
	    }

	    public List<Appointment> getUserAppointments(Long userId) {
	        return appointmentRepository.findByUserId(userId);
	    }

	    public void cancelAppointment(Long appointmentId) {
	        appointmentRepository.deleteById(appointmentId);
	    }
	    public void saveAppointment(Appointment appointment) {
	        appointmentRepository.save(appointment);
	    }

}
