package com.alash.hng_stage_two.service;


import com.alash.hng_stage_two.dto.UserRequestDto;
import com.alash.hng_stage_two.entity.User;

public interface UserService {
    User createUser (UserRequestDto request);
    User updateUser(UserRequestDto request, Long userId);
    String deleteUser(Long userId);
    User getUser(Long userId);

}
