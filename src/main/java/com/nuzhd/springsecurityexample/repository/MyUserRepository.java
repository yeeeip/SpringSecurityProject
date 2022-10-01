package com.nuzhd.springsecurityexample.repository;


import com.nuzhd.springsecurityexample.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MyUserRepository extends JpaRepository<MyUser, UUID> {

}
