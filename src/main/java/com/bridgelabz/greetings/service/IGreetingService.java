package com.bridgelabz.greetings.service;

import com.bridgelabz.greetings.dto.UserDto;
import com.bridgelabz.greetings.model.Greeting;
import com.bridgelabz.greetings.model.User;

public interface IGreetingService {
    Greeting greetingMessage();
    String greetingMessageByName(UserDto userDto);
    User getById(long id);
}