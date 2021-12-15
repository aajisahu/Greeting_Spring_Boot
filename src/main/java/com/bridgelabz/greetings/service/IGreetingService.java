package com.bridgelabz.greetings.service;

import com.bridgelabz.greetings.dto.UserDto;
import com.bridgelabz.greetings.model.Greeting;
import com.bridgelabz.greetings.model.User;

import java.util.List;

public interface IGreetingService {
    Greeting greetingMessage();

    String greetingMessageByName(UserDto userDto);

    User getById(long id);

    List<User> getAllGreetingMessages();

    User updateGreetMessage(long id, UserDto userDto);

    String deleteGreetMessage(long id);
}