package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.ControllerLayer;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	

	    @ExceptionHandler(Exception.class)
	    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	    public String handleAllExceptions(Exception ex, Model model) {
	        // You can log the actual error here if needed
	        model.addAttribute("errorMessage", "Something went wrong");
	        return "error-page"; // The name of your error view
	    }
	}



