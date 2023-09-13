package com.alash.hng_stage_two.service;

import com.alash.hng_stage_two.dto.UserRequestDto;
import com.alash.hng_stage_two.entity.User;
import com.alash.hng_stage_two.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class ServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public User updateUser(UserRequestDto request, Long userId) {
   User user = userRepository.findById(userId)
           .orElseThrow(()->new NoSuchElementException("User not found"));
   if(request.getEmail() != null){
       user.setEmail(request.getEmail());
   }
   if(request.getName() != null){
            user.setName(request.getName());
        }
   User savedUser = userRepository.save(user);
        return User.builder()
                .userId(savedUser.getUserId())
                .email(savedUser.getEmail())
                .name(savedUser.getName())
                .build();

    }

    @Override
    public String deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));
        userRepository.delete(user);
        return "User has been successfully deleted";
    }

    @Override
    public User getUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(()->new RuntimeException("User not found"));
        return User.builder()
                .userId(user.getUserId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }

    @Override
    public User createUser(UserRequestDto request) {
        String onlyStringRegex = "(^[a-zA-Z ]+$)";
        String onlyEmailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        boolean isExist = userRepository.existsByEmail(request.getEmail());

        if (!isInputValid(request.getEmail(), onlyEmailRegex)) {
            return User.builder()
                    .email("Email must be a string and must contain @ symbol")
                    .build();
        }
        if (!isInputValid(request.getName(), onlyStringRegex)) {
            return User.builder()
                    .name("Name must be a string")
                    .build();
        }
        if(isExist){
            return User.builder()
                    .email("Email already exists")
                    .build();
        }

//        if()//check if the email already exists in database
        User user = User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .build();
        User savedUser = userRepository.save(user);
        return User.builder()
                .userId(savedUser.getUserId())
                .email(savedUser.getEmail())
                .name(savedUser.getName())
                .build();
    }

    private boolean isInputValid(String input, String regex) {
        return Pattern.compile(regex)
                .matcher(input)
                .matches();
    }
}
