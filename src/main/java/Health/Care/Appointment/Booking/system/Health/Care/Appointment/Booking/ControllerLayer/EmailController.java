package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.ControllerLayer;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserService.CustomMailSender;

@Controller
public class EmailController {

    @Autowired
    private CustomMailSender CustomMailSender;

    @EventListener(ApplicationReadyEvent.class)
    public void sendEmail() {
    	CustomMailSender.sendemailsender("sethijyotrimayee517@gmail.com", "This is the subject of the email", "This is the body of the email");
    }
}

	

