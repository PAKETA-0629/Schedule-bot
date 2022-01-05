package org.springbootschedulebot.service;

import org.springbootschedulebot.model.User;
import org.springbootschedulebot.repository.UserRepository;
import org.springbootschedulebot.util.States;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void create(String username) {
        userRepository.create(username);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User findByName(String username) {
        return userRepository.findByName(username);
    }

    public void setState(User user, States state, Long stage) {
        userRepository.updateState(user.getId(), state.name(), stage);
    }

    public void setStage(User user, Long stage) {
        userRepository.updateStage(user.getId(), stage);
    }
}
