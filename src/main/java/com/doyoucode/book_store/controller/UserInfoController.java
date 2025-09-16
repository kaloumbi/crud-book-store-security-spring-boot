package com.doyoucode.book_store.controller;

import com.doyoucode.book_store.dto.UserInfoDto;
import com.doyoucode.book_store.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-info")
public class UserInfoController {

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/register")
    public ResponseEntity<String> createUserInfo(@RequestBody UserInfoDto userInfoDto){

        UserInfoDto userInfoDto1 = userInfoService.createUser(userInfoDto);
        return new ResponseEntity<>("User " + userInfoDto1.userName() + " Created Successfully !", HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> getUserInfo(@RequestBody UserInfoDto userInfoDto){

        String userInfoDtoLogged = userInfoService.getUserInfo(userInfoDto);
        return new ResponseEntity<>(userInfoDtoLogged, HttpStatus.OK);
    }
}
