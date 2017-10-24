package com.example.Controller;


import com.example.Entity.Greeting;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class GreetingController {



    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();




    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public @ResponseBody Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }


    @RequestMapping(path = "/hello")
    public String greeting(){
        return "hello";
    }




}
