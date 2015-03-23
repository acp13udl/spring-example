package com.udl.softarch.springexample.controllers;

import com.udl.softarch.springexample.repositories.GreetingRepository;
import com.udl.softarch.springexample.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by david on 23/03/15.
 */

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    GreetingRepository greetingRepository;

    //LIST
    //RETRIEVE


}
