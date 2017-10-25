package com.example.Controller;


import com.example.Entity.Job;
import com.example.Entity.Status;
import com.example.Entity.User;
import com.example.Repository.StatusRepository;
import com.example.Repository.UserRepository;
import com.example.Services.UserService;
import jdk.nashorn.internal.scripts.JO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {


    @Autowired
    public UserRepository userRepository;

    @Autowired
    public UserService userService;

    @Autowired
    public StatusRepository statusRepository;


    @RequestMapping()
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





    @GetMapping("/signUp")
    public String openRegistration(){
        return "signUp";
    }


    @GetMapping("/register")
    public String openRegisterPage(Model model){
        model.addAttribute("statuses", statusRepository.findAll());
        model.addAttribute("user", new User());
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute(name = "user") User user)  {
        userRepository.save(user);
        return "redirect:/users";
    }





    @GetMapping("/{user_id}/edit")
    public String openEditPage(@PathVariable(value = "user_id")Integer id, Model model){
        model.addAttribute("statuses", statusRepository.findAll());
        model.addAttribute("user", userService.findOneById(id));
        return "editUser";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute(value = "user") User user){
        userRepository.save(user);
        return "redirect:/users";
    }






    @GetMapping("/{user_id}/jobs")
    public @ResponseBody Iterable<Job> getAllUserJobs(@PathVariable(value = "user_id") Integer id){
        return userService.getAllJobsByUserId(id);
    }


    @RequestMapping(value = "/{user_id}/job", method = RequestMethod.GET)
    public String showUserJobs(@PathVariable(value = "user_id") Integer id, Model model){
        model.addAttribute("jobs", userService.getAllJobsByUserId(id));
        return "showJob";
    }






    @GetMapping("/{user_id}/status")
    public @ResponseBody Status getUserStatusById(@PathVariable(value = "user_id") Integer id){
        return userService.getUserStatus(id);
    }

    @GetMapping("/job")
    public @ResponseBody Status getStatusWithParamters(@RequestParam(value = "id") Integer id){
        return userService.getUserStatus(id);
    }

    @GetMapping("/{user_id}/status/current")
    public String getUserStatus(@PathVariable(value = "user_id") Integer id){
        return userService.getUserStatus(id).getStatus();
    }


    @GetMapping("/{user_id}/remove")
    public String removeUser(@PathVariable(value = "user_id") Integer id) {
        userService.delete(id);
        return "redirect:/users";
    }

    @DeleteMapping("/{user_id}/delete")
    public @ResponseBody Status deleteUser(@PathVariable(value = "user_id") Integer id) {
        User user = userRepository.findOne(id);
        Status status = new Status(user.getUser_id(), "Deleted!");
        userService.delete(user);
        return status;
    }



}
