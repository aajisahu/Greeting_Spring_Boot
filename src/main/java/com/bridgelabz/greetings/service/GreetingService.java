package com.bridgelabz.greetings.service;

import com.bridgelabz.greetings.dto.UserDto;
import com.bridgelabz.greetings.model.Greeting;
import com.bridgelabz.greetings.model.User;
import com.bridgelabz.greetings.repository.IGreetingRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {
    private static final String template = "Hello world!";

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    IGreetingRepository iGreetingRepository;

    @Override
    public Greeting greetingMessage() {
        return new Greeting(counter.incrementAndGet(), String.format(template));
    }

    @Override
    public String greetingMessageByName(UserDto userDto) {
        User user = new User();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(userDto, user);
        iGreetingRepository.save(user);
        return ("Hello " + user.getFirstName() + " " + user.getLastName());
    }


    @Override
    public User getById(long id) {
        Optional<User> greetById = iGreetingRepository.findById(id);
        return greetById.orElse(null);
    }

    @Override
    public List<User> getAllGreetingMessages() {
        return iGreetingRepository.findAll();
    }

}