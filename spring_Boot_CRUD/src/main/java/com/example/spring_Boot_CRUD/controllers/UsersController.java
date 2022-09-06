package com.example.spring_Boot_CRUD.controllers;

import com.example.spring_Boot_CRUD.models.User;
import com.example.spring_Boot_CRUD.service.UserService;
import com.example.spring_Boot_CRUD.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserService usersServices;


    @Autowired
    public UsersController(UserService usersServices) {
        this.usersServices = usersServices;
    }


    @GetMapping()
    public String showAllUsers(Model model) {
        model.addAttribute("users", usersServices.listUser());
        return "users/users";
    }

    @GetMapping("/{id}")
    public String showUserById(@PathVariable("id") Long id, Model model) {
        model.addAttribute("index", usersServices.getUserById(id));
        return "users/index";
    }

    @GetMapping("/new")
    public String createNewUserForm(Model model) {                  // по запросу "/new" в браузер вернется форма для создания нового юзера
        model.addAttribute("user", new User());
        return "users/new";                                         // возвращаем название Thymeleaf-шаблона, где у нас будет лежать форма для создания нового юзера
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") User user){
        usersServices.addUser(user);
        return "redirect:/users";                                // указываем адрес, на который мы хотим перенаправить пользоватея
    }

    @GetMapping("/{id}/edit")
    public String editUsers(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", usersServices.getUserById(id));
        return "/users/edit";
    }

    @PatchMapping("/{id}")
    public String updateUsers(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        usersServices.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteUsers(@PathVariable("id") Long id) {
        usersServices.removeUser(id);
        return "redirect:/users";
    }


}
