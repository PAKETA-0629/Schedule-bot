package org.springbootschedulebot.repositoryIT;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springbootschedulebot.model.User;
import org.springbootschedulebot.service.UserService;
import org.springbootschedulebot.util.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryIT {

    @Autowired
    private UserService userService;

    private static User EXISTING_USER;

    @BeforeAll
    static void init() {

        EXISTING_USER = User.builder().name("kyrylo0629").id(1L).build();
    }

    @Test
    void updateState() {

        userService.setState(EXISTING_USER, States.CREATE, 1L);
        System.out.println(userService.findAll());

    }

    @Test
    void updateStage() {
        userService.setStage(EXISTING_USER, 2L);
        System.out.println(userService.findAll());
    }
}
