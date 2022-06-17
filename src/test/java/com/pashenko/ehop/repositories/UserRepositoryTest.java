package com.pashenko.ehop.repositories;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class UserRepositoryTest {
    private final String USERNAME = "user@eshop.local";

    @Autowired
    private UserRepository repository;

    @Test
    public void loadUserByUserNameReturnsUser(){
        assertDoesNotThrow(() ->{
                    repository.getUserByUserName(USERNAME).orElseThrow();
                }
        );
    }

}
