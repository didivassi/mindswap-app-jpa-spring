package academy.mindswap.mindswapappjapspring.controllers;

import academy.mindswap.mindswapappjapspring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    private UserService service;

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", service.getUsers());
        return "users";
    }

    // localhost:8080/users/1
    @GetMapping("/users/{id}")
    public String getUserById(@PathVariable Long id, Model model) {
        model.addAttribute("user", service.getUserById(id));
        return "user";
    }

    // localhost:8080/user?name=Joaquim
    @GetMapping("/user")
    public String getUserByName(@RequestParam String name, Model model) {
        model.addAttribute("users", service.getUserByName(name));
        return "users";
    }

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }
}