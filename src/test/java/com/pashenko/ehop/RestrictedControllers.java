package com.pashenko.ehop;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

@SpringBootTest
public class RestrictedControllers {
    @Test
    @WithMockUser("user")
    public void whenUserGoesToUsersUrlOk(){

    }
}
