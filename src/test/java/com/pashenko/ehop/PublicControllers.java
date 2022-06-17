package com.pashenko.ehop;

import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.AbstractMap.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PublicControllers {
    /**
     * constant fields contains: related url & piece of page content
     */
    private final SimpleEntry<String, String> HOME = new SimpleEntry<>("/", "E-shop");
    private final SimpleEntry<String, String> SIGNUP = new SimpleEntry<>("/signup", "E-shop");
    private final SimpleEntry<String, String> LOGIN = new SimpleEntry<>("/login", "action=\"/login\"");
    private final SimpleEntry<String, String> CATALOG = new SimpleEntry<>("/catalog", "action=\"/login\"");

    @Autowired
    private MockMvc mvc;

    @Test
    public void homePagePerformingReturnsHome() {
        assertDoesNotThrow(() -> {
            performGetFromEntry(HOME, HttpStatus.OK);
        });
    }

    @Test
    public void loginPagePerformingReturnsLogin(){
        assertDoesNotThrow(() -> {
            performGetFromEntry(LOGIN, HttpStatus.OK);
        });
    }

    @Test
    public void signupPagePerformingReturnsSignup(){
        assertDoesNotThrow(() -> {
            performGetFromEntry(SIGNUP, HttpStatus.OK);
        });
    }

    @Test
    public void catalogPagePerformingReturnsSignup(){
        assertDoesNotThrow(() -> {
            performGetFromEntry(CATALOG, HttpStatus.OK);
        });
    }

    private ResultActions performGetFromEntry(SimpleEntry<String, String> entry, HttpStatus expectStatus) throws Exception {
        return this.mvc.perform(get(entry.getKey()))
                .andExpect(status().is(expectStatus.value()))
                .andExpect(content().string(containsString(entry.getValue())));
    }
}
