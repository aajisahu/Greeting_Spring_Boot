package com.bridgelabz.greetings.controller;

import com.bridgelabz.greetings.model.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
    public class GreetingController {
        private static final String template = "Hello, %s!";
        private final AtomicLong counter = new AtomicLong();

        /*
         *curl localhost:8080/greeting
         @return={id =1 , content="hello world!}
         * localhost:8080/greeting?name=Ashish
         * @return= { id=2, content="hello Ashish!
         */
        @GetMapping(value={"/greeting","/greeting/","/greeting/home"})
        public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }
        /*
        *localhost:8080/greeting/Ashish
        @return={id =1 , content="hello Ashish!}
         */
        @GetMapping("greeting/{name}")
        public Greeting greetings(@PathVariable String name) {
            return new Greeting(counter.incrementAndGet(), String.format(template, name));
        }

    }
