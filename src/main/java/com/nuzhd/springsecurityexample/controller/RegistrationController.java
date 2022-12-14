package com.nuzhd.springsecurityexample.controller;

import com.nuzhd.springsecurityexample.event.RegistrationCompleteEvent;
import com.nuzhd.springsecurityexample.model.MyUser;
import com.nuzhd.springsecurityexample.service.MyUserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private MyUserService userService;
    private ApplicationEventPublisher applicationEventPublisher;

    public RegistrationController(MyUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String registerUser(MyUser user) {
        MyUser newUser = userService.registerUser(user);
        applicationEventPublisher.publishEvent(new RegistrationCompleteEvent(user,
                ""
        ));
        return "Success!\n" + newUser.toString();
    }

}
