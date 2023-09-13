package com.alash.hng_stage_two.controller;

import com.alash.hng_stage_two.dto.UserRequestDto;
import com.alash.hng_stage_two.entity.User;
import com.alash.hng_stage_two.service.UserService;
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
    @PutMapping("/{user_id}")
    public User UpdateUser(@PathVariable Long user_id,
                           @RequestBody UserRequestDto request) { //change this one to path variable
        return userService.updateUser(request, user_id);
    }
    @DeleteMapping("/{user_id}")
    public String  deleteUser(@PathVariable Long user_id) {
        return userService.deleteUser(user_id);
    }
    @GetMapping("/{user_id}")
    public User getUser(@PathVariable Long user_id) {
        return userService.getUser(user_id);
    }

}
