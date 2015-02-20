package com.udl.softarch.springexample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by davidkaste on 16/02/15.
 */

@Controller
@RequestMapping("/greeting")
public class GreetingController {

    //@RequestMapping(value = "/greeting")
    public ModelAndView viewGreeting() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("greeting");
        String name = "hola com va!";
        mav.addObject("name", name);
        return mav;
    }
}
