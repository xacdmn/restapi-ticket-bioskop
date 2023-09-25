package com.example.ticketbioskop.controller;

import com.example.ticketbioskop.entity.user.AppUser;
import com.example.ticketbioskop.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/add")
    public ResponseEntity<AppUser> addUser(@RequestBody AppUser user) {
        return ResponseEntity.ok(userService.addUser(user));
    }

    @PutMapping("/user/{userId}")
    public ResponseEntity<AppUser> updateUser(@PathVariable Long userId, @RequestBody AppUser user) {
        user.setId(userId);
        return ResponseEntity.ok(userService.updateUser(user));
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}

