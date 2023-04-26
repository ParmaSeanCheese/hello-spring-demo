package org.launchcode.hellospring.controllers;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name, Model model){
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello.html";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model){
        model.addAttribute("greeting", "Hello, "  + name + "!");
        return "hello.html";
    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "form.html";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "greeting")
    @ResponseBody
    public String createMessage(@RequestParam String name, @RequestParam String language){
        if (language.equals("")){
            return "Please Select a language";
        } else if (language.equals("english")) {
            return "Hello, " + name + "!";
        } else if (language.equals("french")) {
            return "Bonjour, " + name + "!";
        } else if (language.equals("spanish")) {
            return "¡Buenos días, " + name + "!";
        } else if (language.equals("german")) {
            return "Guten Tag, " + name + "!";
        }
        return "Привет, " + name + "!";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list.html";
    }

}
