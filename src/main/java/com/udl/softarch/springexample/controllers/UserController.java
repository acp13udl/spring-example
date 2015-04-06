package com.udl.softarch.springexample.controllers;

import com.google.common.base.Preconditions;
import com.udl.softarch.springexample.models.Greeting;
import com.udl.softarch.springexample.models.User;
import com.udl.softarch.springexample.repositories.GreetingRepository;
import com.udl.softarch.springexample.repositories.UserRepository;
import com.udl.softarch.springexample.services.UserGreetingsService;
import com.udl.softarch.springexample.services.UserGreetingsServiceImpl;
import com.udl.softarch.springexample.test.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.lang.invoke.MethodType;
import java.lang.reflect.Method;

/**
 * Created by david on 23/03/15.
 */

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserGreetingsService userGreetingsService;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<User> list(@RequestParam(required = false, defaultValue = "0") int page,
                               @RequestParam(required = false, defaultValue = "10") int size) {

        Test.createUserGreetingsTest(userGreetingsService);
        PageRequest pageRequest = new PageRequest(page, size);
        return userRepository.findAll(pageRequest).getContent();
    }

    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public ModelAndView listHTML(@RequestParam(required = false, defaultValue = "0") int page,
                                 @RequestParam(required = false, defaultValue = "10") int size) {
        PageRequest pageRequest = new PageRequest(page, size);
        return new ModelAndView("users", "users", list(page, size));
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public User receive(@PathVariable("id")Long id){

        Test.createUserGreetingsTest(userGreetingsService);
        Preconditions.checkNotNull(userRepository.findOne(id), "Test user not found");
        return userGreetingsService.getUserAndGreetings(id);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces = "text/html")
    public ModelAndView receiveHTML(@PathVariable("id")Long id){

        return new ModelAndView("user","user",receive(id));
    }



}
