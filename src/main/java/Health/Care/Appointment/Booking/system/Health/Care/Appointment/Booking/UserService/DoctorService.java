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

    
    public Doctor saveDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }


    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

   
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return doctorRepository.findBySpecialization(specialization);
    }

    
    public List<Doctor> getDoctorsByExperience(int experience) {
        return doctorRepository.findByExperienceGreaterThanEqual(experience);
    }
}

