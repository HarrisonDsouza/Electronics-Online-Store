package ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.Controller;

import ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.beans.User;
import ca.sheridancollege.dsouzhar.personalprojectharrisondsouza.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new User()); // Add an empty User object to the model
        return "register";
    }

    @GetMapping("/permission-denied")
    public String permissionDenied() {
        return "permission-denied";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        // Debugging output
        System.out.println("Registering user with email: " + user.getEmail());

        // Save user with password encoding
        userService.save(user);
        return "redirect:/login";
    }
}
