package com.example.ticketbioskop.service.user;

import com.example.ticketbioskop.entity.user.AppUser;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    AppUser addUser(AppUser user);
    AppUser updateUser(AppUser user);
    AppUser deleteUser(Long userId);

    AppUser getUserById(Long userId);

}
