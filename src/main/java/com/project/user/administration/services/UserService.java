package com.project.user.administration.services;

import com.project.user.administration.model.User;
import com.project.user.administration.repository.UserRepository;
import com.project.user.administration.vo.UserRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserRequestVo findByUserId(Long userId) {

        User user = userRepository.findByUserId(userId);

        return UserRequestVo.builder()
                .username(user.getUserName())
                .email(user.getEmail())
                .build();
    }
}
 