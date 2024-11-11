package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.Repository.DoctorRepository;
import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserEntity.Doctor;

import java.util.List;

@Service
public class DoctorService {
	@Autowired
    private DoctorRepository doctorRepository;

    // Save new doctor
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    // Fetch all doctors
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    // Fetch doctors by specialization
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    // Fetch doctors by experience
    public List<Doctor> getDoctorsByExperience(int experience) {
        return doctorRepository.findByExperienceGreaterThanEqual(experience);
    }
}

