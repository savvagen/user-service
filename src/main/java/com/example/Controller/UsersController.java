package com.example.Controller;


import com.example.Entity.Status;
import com.example.Entity.User;
import com.example.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {


    @Autowired
    public UserRepository userRepository;



    @RequestMapping
    public String showUsers(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "usersList";
    }



    @RequestMapping("/{user_id}")
    public String showUser(@PathVariable(value = "user_id") Integer id, Model model){
        model.addAttribute("user", userRepository.findOne(id));
        return "showUser";
    }


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public @ResponseBody Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }


    @GetMapping("/{user_id}/status")
    public @ResponseBody Status getUserStatusById(@PathVariable(value = "user_id") Integer id){
        User user = userRepository.findOne(id);
        return new Status(id, user.getStatus());
    }




    @GetMapping("/signUp")
    public String openRegistration(){
        return "signUp";
    }



    @GetMapping("/register")
    public String openRegisterPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }



    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute(name = "user") User user)  {
        userRepository.save(user);
        return "redirect:/users";
    }



}
