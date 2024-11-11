package Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserService;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.Repository.UserRepository;
import Health.Care.Appointment.Booking.system.Health.Care.Appointment.Booking.UserEntity.User;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

   

    public User registerUser(User user) {
        user.setPassword(user.getPassword());
        return userRepository.save(user);
    }
 
    public List<User> getAllUsers() {
        return userRepository.findAll();  
    }

    
    public User getCurrentUser(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }
    private User registeredUser; 

    public void registeredUser(User user) {
        
        this.registeredUser = user;  
    }

    
    public boolean authenticate(String name, String password) {
       
        return registeredUser != null
                && registeredUser.getName().equals(name)
                && registeredUser.getPassword().equals(password);
    }

    
    public User getRegisteredUser() {
        return this.registeredUser;
    }

    public void updateProfile(User updatedUser) {
        if (registeredUser != null) {
            registeredUser.setName(updatedUser.getName());
            registeredUser.setEmail(updatedUser.getEmail());
            registeredUser.setPhoneNumber(updatedUser.getPhoneNumber());
        }
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void save(User user) {
        userRepository.save(user);
    }
   
 
    public void updateUserProfile(Long userId, String name, String email, String phoneNumber) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        
        // Only update name, email, and phone number
        user.setName(name);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);

        userRepository.save(user); // Save without changing the password field
    }
	
}