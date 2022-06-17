package com.pashenko.ehop;

import static org.junit.jupiter.api.Assertions.*;
import com.pashenko.ehop.controllers.HomeController;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class EhopApplicationTests {
    @LocalServerPort
    private Integer port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private HomeController controller;

    @Test
    @Order(0)
    void contextLoads() {
        assertNotNull(controller);
    }

    @Test
    @Order(10)
    public void isConfiguredServerPortReachable(){
        assertDoesNotThrow(() -> {
            this.restTemplate.getForObject("http://localhost:" + this.port, String.class);
        });
    }

}
