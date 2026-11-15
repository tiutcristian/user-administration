package com.project.user.administration.controller;

import com.project.user.administration.services.UserService;
import com.project.user.administration.vo.UserAuthorizeResponseVo;
import com.project.user.administration.vo.UserRequestVo;
import com.project.user.administration.vo.UserTokenResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/{userId}")
    @CrossOrigin
    public UserRequestVo getUserById(@PathVariable Long userId) {
        return userService.findByUserId(userId);
    }

    @GetMapping("/user/all")
    @CrossOrigin
    public List<UserRequestVo> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/user")
    @CrossOrigin
    public List<UserRequestVo> getUsersByName(@RequestParam String name) {
        return userService.findUsersByNameContaining(name);
    }

    @PostMapping("/user/register")
    @CrossOrigin
    public void registerNewUser(@RequestBody UserRequestVo userRequestVo) {
        userService.registerNewUser(userRequestVo);
    }

    @PostMapping("/user/authenticate")
    @CrossOrigin
    public UserTokenResponseVo login(@RequestBody UserRequestVo userRequestVo) {
        return userService.validateUserCredentialsAndGenerateToken(userRequestVo);
    }

    @PostMapping("/user/authorize")
    @CrossOrigin
    public UserAuthorizeResponseVo authorize(@RequestBody UserRequestVo userRequestVo) throws ParseException {
        return userService.authorizeV1(userRequestVo);
    }

}