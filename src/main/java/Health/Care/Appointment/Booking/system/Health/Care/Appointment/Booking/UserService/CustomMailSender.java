package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class CustomMailSender {

    @Autowired
    private JavaMailSender mailSender;

    public void sendemailsender(String toEmail, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("sethyjyotrimayeee67@gmail.com");
        message.setTo(toEmail);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
        System.out.println("Message sent successfully...");
    }
}

