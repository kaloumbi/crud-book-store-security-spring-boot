package com.doyoucode.book_store.service.impl;

import com.doyoucode.book_store.dto.UserInfoDto;
import com.doyoucode.book_store.entity.UserInfo;
import com.doyoucode.book_store.mapper.UserInfoMapper;
import com.doyoucode.book_store.repository.UserInfoRepository;
import com.doyoucode.book_store.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    UserInfoRepository userInfoRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserInfoDto createUser(UserInfoDto userInfoDto) {
        UserInfo userInfo = UserInfoMapper.toEntity(userInfoDto);
        userInfo.setPassword(passwordEncoder.encode(userInfoDto.password()));
        UserInfo userSaved = userInfoRepository.save(userInfo);

        return UserInfoMapper.toDto(userSaved);
    }
}
