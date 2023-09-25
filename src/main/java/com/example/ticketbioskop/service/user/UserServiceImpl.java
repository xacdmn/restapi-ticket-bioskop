package com.example.ticketbioskop.service.user;

import com.example.ticketbioskop.entity.user.AppUser;
import com.example.ticketbioskop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public AppUser addUser(AppUser user) {
        return userRepository.save(user);
    }

    @Override
    public AppUser updateUser(AppUser user) {
        if (user.getId() == null || !userRepository.existsById(user.getId())) {
            throw new IllegalArgumentException("User with ID " + user.getId() + " does not exist.");
        }
        return userRepository.save(user);
    }

    @Override
    public AppUser deleteUser(Long userId) {
        return userRepository.deleteAppUserById(userId);
    }

    @Override
    public AppUser getUserById(Long userId) {
        return userRepository.getAppUserById(userId);
    }
}
