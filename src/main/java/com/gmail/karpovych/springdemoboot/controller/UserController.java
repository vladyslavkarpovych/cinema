package com.gmail.karpovych.springdemoboot.controller;

import com.gmail.karpovych.springdemoboot.model.User;
import com.gmail.karpovych.springdemoboot.repository.UserRepository;
import com.gmail.karpovych.springdemoboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping("/use")
//    public String findAll(Model model) {
//        List<User> users = userService.findAll();
//        model.addAttribute("users", users);
//        return "user/user-list";
//    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user/user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("user/user-edit/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user/user-edit";
    }

    @PostMapping("/user-edit")
    public String updateUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable(value = "pageNo") int pageNo,
                                @RequestParam("sortField") String sortField,
                                @RequestParam("sortDir") String sortDir,
                                Model model) {
        int pageSize = 5;

        Page<User> page = userService.findPaginated(pageNo, pageSize, sortField, sortDir);
        List<User> listEmployees = page.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("listEmployees", listEmployees);
        return "user/user-list";
    }

    @GetMapping("/users")
    public String viewHomePage(Model model) {
        return findPaginated(1, "id", "asc", model);
    }
}