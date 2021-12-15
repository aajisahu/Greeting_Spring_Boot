package com.bridgelabz.greetings.controller;

import com.bridgelabz.greetings.dto.UserDto;
import com.bridgelabz.greetings.model.Greeting;
import com.bridgelabz.greetings.model.User;
import com.bridgelabz.greetings.repository.IGreetingRepository;
import com.bridgelabz.greetings.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    @Autowired
    private IGreetingService greetingService;

    /*
       *localhost:8080/greeting/service
       @return={id =1 , content="hello world!}
        */
    @GetMapping("greeting/service")
    public Greeting greeting() {
        return greetingService.greetingMessage();


    }

    @PostMapping("/greeting")
    public String greetingMessage(@RequestBody UserDto userDto) {
        return greetingService.greetingMessageByName(userDto);
    }
        @Autowired
        IGreetingRepository savefile;
        public void save(User user){
        savefile.save(user);
        }

    @GetMapping("/find")
    public User findGreetById(@RequestParam long id) {
        return greetingService.getById(id);
    }

    @GetMapping("/allgreetings")
    public List<User> findAllGreeting() {
        return greetingService.getAllGreetingMessages();
    }

    @PutMapping("/editmessage/{id}")
    public User editGreetMesage(@PathVariable long id, @RequestBody UserDto userDto) {
        return greetingService.updateGreetMessage(id, userDto);

    }
}

