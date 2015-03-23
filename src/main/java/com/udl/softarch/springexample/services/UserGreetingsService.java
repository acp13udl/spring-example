package com.udl.softarch.springexample.services;

import com.udl.softarch.springexample.models.Greeting;
import com.udl.softarch.springexample.models.User;

/**
 * Created by david on 23/03/15.
 */
public interface UserGreetingsService {
    User getUserAndGreetings(Long userId);
    Greeting addGreetingToUser(Greeting greeting);
    Greeting updateGreetingFromUser(Greeting updateGreeting, Long greetingId);
    void removeGreetingFromUser(Long greetingId);
}
