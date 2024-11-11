package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserEntity;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
@Data
@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Doctor doctor;

    @ManyToOne
    private User user;

    private LocalDateTime appointmentDate;
    private String status;  // e.g., "Scheduled", "Canceled"

    // Getters and Setters
}
