package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.models.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "/")
    public String index(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "all-users";
    }

    @GetMapping("/{id}")
    public String show (@PathVariable("id") int id, Model model){
    model.addAttribute("user", userService.getById(id));
    return "show";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user, Model model){
        return "new";
    }
    @PostMapping
    public String create(@ModelAttribute("user") User user){
        userService.add(user);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    public String edit (Model model, @PathVariable("id") int id){
    model.addAttribute("user", userService.getById(id));
    return "edit";
    }

    @PatchMapping ("/{id}")
    public String update (@ModelAttribute ("user") User user, @PathVariable("id") int id){
        userService.edit(user, id);
        return "redirect:/";
    }
    @DeleteMapping ("/{id}")
    public String delete(@PathVariable ("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
