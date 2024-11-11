package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.ControllerLayer;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserEntity.User;
import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserService.UserService;

@Controller

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/signup")
    public String showSignupForm(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }
    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, Model model , RedirectAttributes redirectAttributes) {
        userService.registerUser(user);
        redirectAttributes.addFlashAttribute("successMessage", "Signup successful! Please login.");
        return "redirect:/login";
    }
    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());  
        return "login";
    }

  
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
    	
        System.out.println("Login attempt: " + user.getName() + ", " + user.getPassword());
        
        
        boolean isAuthenticated = userService.authenticate(user.getName(), user.getPassword());

        if (isAuthenticated) 
            model.addAttribute("welcomeMessage", "Login successful! Welcome, " + user.getName());
            return "profile";  
    
        }
    
    @PostMapping("/profile")
    public String updateProfile(@RequestParam Long id,
                                @RequestParam String name,
                                @RequestParam String email,
                                @RequestParam String phoneNumber,
                                Model model) {
        try {
            userService.updateUserProfile(id, name, email, phoneNumber);
            model.addAttribute("successMessage", "Profile updated successfully!");
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Something went wrong while updating the profile.");
        }
        return "profile"; // Redirect to the profile page after update
    }
    

}

  

