package com.HngTaskTwo.HngTaskTwo.service;

import com.HngTaskTwo.HngTaskTwo.dto.UserRequestDto;
import com.HngTaskTwo.HngTaskTwo.entity.User;

public interface UserService {
    User createUser (UserRequestDto request);
    User updateUser(UserRequestDto request, Long userId);
    String deleteUser(Long userId);
    User getUser(Long userId);

}
