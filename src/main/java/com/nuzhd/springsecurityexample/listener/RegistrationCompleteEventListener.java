package com.nuzhd.springsecurityexample.listener;

import com.nuzhd.springsecurityexample.event.RegistrationCompleteEvent;
import com.nuzhd.springsecurityexample.model.MyUser;
import com.nuzhd.springsecurityexample.service.MyUserService;
import org.springframework.context.ApplicationListener;

import java.util.UUID;

public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private MyUserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        MyUser user = event.getUser();
        String token = UUID.randomUUID().toString();


    }

}
