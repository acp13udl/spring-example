package com.udl.softarch.springexample.test;

import com.udl.softarch.springexample.models.Greeting;
import com.udl.softarch.springexample.services.UserGreetingsService;

/**
 * Created by adrian on 31/3/15.
 */
public class Test {

    private static boolean isFirstTime=true;

    public static void createUserGreetingsTest(UserGreetingsService service){

        if (isFirstTime) {

            Greeting greeting1 = new Greeting();
            greeting1.setEmail("usergreeting@gmail.com");
            greeting1.setContent("This is a test greeting");

            Greeting greeting2 = new Greeting();
            greeting2.setEmail("usergreeting@gmail.com");
            greeting2.setContent("This is a test greeting 2");

            service.addGreetingToUser(greeting1);
            service.addGreetingToUser(greeting2);

            isFirstTime = false;
        }

    }
}
