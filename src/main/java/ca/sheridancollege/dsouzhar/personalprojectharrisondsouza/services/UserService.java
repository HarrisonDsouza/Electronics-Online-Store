package ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.services;

import ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.beans.User;
import ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.database.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void save(User user) {
        user.setEncryptedPassword(passwordEncoder.encode(user.getEncryptedPassword())); // Ensure to use user.getPassword() here
        user.setEnabled(true); // default to enabled
        user.setRole("ROLE_USER"); // default role
        userRepository.save(user);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public boolean emailExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
