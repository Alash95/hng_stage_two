package com.HngTaskTwo.HngTaskTwo.controller;

import com.HngTaskTwo.HngTaskTwo.dto.UserRequestDto;
import com.HngTaskTwo.HngTaskTwo.entity.User;
import com.HngTaskTwo.HngTaskTwo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody UserRequestDto request) {
        return userService.createUser(request);
    }
    @PutMapping
    public User UpdateUser(@RequestBody UserRequestDto request, @PathVariable("user_id") Long userId) { //change this one to path variable
        return userService.updateUser(request, userId);
    }
    @DeleteMapping("/{id}")
    public String  deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

}
