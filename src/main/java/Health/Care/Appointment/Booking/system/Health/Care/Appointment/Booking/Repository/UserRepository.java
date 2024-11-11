package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserEntity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

