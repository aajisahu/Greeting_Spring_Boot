package com.bridgelabz.greetings.service;

import com.bridgelabz.greetings.dto.UserDto;
import com.bridgelabz.greetings.model.Greeting;

public interface IGreetingService {
    Greeting greetingMessage();
    String greetingMessageByName(UserDto userDto);

}