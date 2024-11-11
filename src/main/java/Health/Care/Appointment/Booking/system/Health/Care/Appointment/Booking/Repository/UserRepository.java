package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserEntity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    @Modifying
    @Transactional
    @Query("UPDATE User u SET u.name = :name, u.email = :email, u.phoneNumber = :phoneNumber WHERE u.id = :id")
    void updateUserProfile(@Param("id") Long id,
                           @Param("name") String name,
                           @Param("email") String email,
                           @Param("phoneNumber") String phoneNumber);

}

