package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.ControllerLayer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserEntity.Doctor;
import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserService.DoctorService;

import java.util.List;

@Controller
@RequestMapping("/doctors")
public class DoctorController {

	@Autowired
    private DoctorService doctorService;

    
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
	    model.addAttribute("doctor", new Doctor());
	    return "register-doctor";
	}

	@PostMapping("/register")
	public String registerDoctor(@ModelAttribute Doctor doctor) {
	    doctorService.saveDoctor(doctor);
	    return "redirect:/doctors/list";
	}

    
    @GetMapping("/list")
    public String listDoctors(@RequestParam(value = "specialization", required = false) String specialization,
                              @RequestParam(value = "experience", required = false) Integer experience,
                              Model model) {
        List<Doctor> doctors;
        if (specialization != null) {
            doctors = doctorService.getDoctorsBySpecialization(specialization);
        } else if (experience != null) {
            doctors = doctorService.getDoctorsByExperience(experience);
        } else {
            doctors = doctorService.getAllDoctors();
        }
        model.addAttribute("doctors", doctors);
        return "list-doctors";
    }
}
