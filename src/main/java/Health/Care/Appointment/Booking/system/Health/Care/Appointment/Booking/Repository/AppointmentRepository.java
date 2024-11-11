package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserEntity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long>{
	List<Appointment> findByUserId(Long userId);
}
