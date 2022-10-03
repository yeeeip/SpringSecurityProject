package com.nuzhd.springsecurityexample.event;

import com.nuzhd.springsecurityexample.model.MyUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private MyUser user;
    private String appUrl;

    public RegistrationCompleteEvent(MyUser user, String appUrl) {
        super(user);
        this.user = user;
        this.appUrl = appUrl;
    }
}
