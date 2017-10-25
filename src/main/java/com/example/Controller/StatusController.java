package com.example.Controller;


import com.example.Entity.Status;
import com.example.Repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class StatusController {

    @Autowired
    public StatusRepository statusRepository;


    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public @ResponseBody Status getStatus(@RequestParam(value = "id") Integer id){
        return statusRepository.findOne(id);
    }


}
