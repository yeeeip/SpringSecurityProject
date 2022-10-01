package com.nuzhd.springsecurityexample.service.impl;

import com.nuzhd.springsecurityexample.model.MyUser;
import com.nuzhd.springsecurityexample.repository.MyUserRepository;
import com.nuzhd.springsecurityexample.service.MyUserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements MyUserService {

    private MyUserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(MyUserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public MyUser registerUser(MyUser user) {
        user.setRole("USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
}
