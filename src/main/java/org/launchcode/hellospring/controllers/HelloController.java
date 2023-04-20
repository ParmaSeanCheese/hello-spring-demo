package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    // Handles request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    // lives /hello/goodbye due to overarching class annotation
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    // Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                    "<form action='/hello/greeting' method='post'>" + //submit a request to /hello
                        "<input type='text' name='name'>" +
                        "<select name='language' id='language'>" +
                            "<option value=''>--Please select Language--</option>" +
                            "<option value='english'>English</option>" +
                            "<option value='french'>French</option>" +
                            "<option value='spanish'>Spanish</option>" +
                            "<option value='german'>German</option>" +
                            "<option value='russian'>Russian</option>" +
                        "</select>" +
                        "<input type='submit' value='Greet me!'>" +
                    "</form>" +
                "</body>" +
                "</html>";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "greeting")
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

}
