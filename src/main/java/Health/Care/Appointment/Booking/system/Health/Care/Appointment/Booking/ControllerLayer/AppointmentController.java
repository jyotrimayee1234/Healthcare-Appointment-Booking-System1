package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.ControllerLayer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserEntity.Appointment;
import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserService.AppointmentService;
import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserService.DoctorService;
import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserService.UserService;

@Controller
	@RequestMapping("/appointments")
	public class AppointmentController {
	    @Autowired
	    private AppointmentService appointmentService;
	    @Autowired
	    private DoctorService doctorService;

	    @Autowired
	    private UserService userService;

	    @GetMapping
	    public String viewAppointments(Model model) {
	        List<Appointment> appointments = appointmentService.getUserAppointments(1L);  
	        model.addAttribute("appointments", appointments);
	        return "appointments";
	    }
	    @GetMapping("/book")
	    public String showBookingForm(Model model) {
	        model.addAttribute("appointment", new Appointment());
	        model.addAttribute("doctors", doctorService.getAllDoctors()); 
	        
	        return "book-appointment";
	    }
	    @PostMapping("/book")
	    public String bookAppointment(@ModelAttribute("appointment") Appointment appointment) {
	        appointmentService.saveAppointment(appointment);
	        return "redirect:/appointments"; 
	    }

	   

	    @PostMapping("/{id}/cancel")
	    public String cancelAppointment(@PathVariable Long id) {
	        appointmentService.cancelAppointment(id);
	        return "redirect:/appointments"; 
	    }
}
