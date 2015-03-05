package com.udl.softarch.springexample.controllers;

import com.udl.softarch.springexample.models.Greeting;
import com.udl.softarch.springexample.repositories.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by davidkaste on 16/02/15.
 */

@Controller
@RequestMapping("/greetings")
public class GreetingController {

    @Autowired
    GreetingRepository greetingRepository;

    /*@RequestMapping(method = RequestMethod.GET)
    public ModelAndView viewGreeting() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("greeting");
        String name = "anonymous";
        mav.addObject("name", name);
        return mav;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ModelAndView viewGreeting(@PathVariable(value = "name") String name) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("greeting");
        mav.addObject("name", name);
        return mav;
    }*/

    // LIST

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Greeting> list(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        PageRequest request = new PageRequest(page, size);
        return greetingRepository.findAll(request).getContent();
    }

    @RequestMapping(method = RequestMethod.GET, produces = "text/html")
    public ModelAndView listHtml(
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        return new ModelAndView("greetings", "greetings", list(page, size));
    }

    // RETRIEVE

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Greeting retrieve(@PathVariable("id") Long id) {
        return greetingRepository.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "text/html")
    public ModelAndView retrieveHtml(@PathVariable("id") Long id) {
        return new ModelAndView("greeting", "greeting", retrieve(id));
    }

     //CREATE

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Greeting create(@Valid @RequestBody Greeting greeting, HttpServletResponse response) {
        return greeting;
    }

    // NEXT DAY WE'LL CONTINUE HERE

    //UPDATE

    //DELETE
}
