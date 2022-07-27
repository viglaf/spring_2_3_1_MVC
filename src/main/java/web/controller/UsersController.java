package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserServiceImpl userService;

    public UsersController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users/show";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model){
    model.addAttribute("user", userService.getById(id));
    return "users/show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user, Model model){
        return "user/new";
    }

}
