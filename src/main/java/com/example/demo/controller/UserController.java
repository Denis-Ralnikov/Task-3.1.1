package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
@RequestMapping("/")
@EnableTransactionManagement
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getAllUser(Model model) {
        model.addAttribute("users",userService.getAllUsers());
        return "users";
    }
    @GetMapping("/addUser")
    public String addUser(){
        return "addUser";
    }

    @PostMapping("/addUser")
    @Transactional
    public String addUserPost(@RequestParam String name, @RequestParam int age, Model model){
        User user = new User(name,age);
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping("/{id}/delete")
    @Transactional
    public String deleteUser(@PathVariable(value = "id") Long id, Model model){
        User user = userService.findById(id);
        userService.deleteUser(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable(value = "id") Long id,Model model){
        User user = userService.findById(id);
        model.addAttribute("user",user);
        return "edit";
    }

    @PostMapping("/{id}/edit")
    @Transactional
    public String editUserPost(@PathVariable(value = "id") Long id, @RequestParam String name,
                               @RequestParam int age,  Model model){
        User user = userService.findById(id);
        user.setName(name);
        user.setAge(age);
        userService.save(user);
        return "redirect:/";
    }
}
