package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserEntity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
	 List<Doctor> findBySpecialization(String specialization);
	    List<Doctor> findByExperienceGreaterThanEqual(int experience);

}
