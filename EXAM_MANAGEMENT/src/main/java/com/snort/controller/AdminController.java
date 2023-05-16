package com.snort.controller;

import com.snort.entities.User;
import com.snort.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/index")
    public String adminDashBoard(Model model){
        model.addAttribute("title","Admin Dashboard");
        return "admin/admin_home";
    }
    @GetMapping("/show-users")
    public String showAllUsers(Model model){
        List<User> userList= userRepository.findAll();
        model.addAttribute("userList",userList);
        model.addAttribute("title", "Show User List");
        return "admin/user-list";
    }

}
