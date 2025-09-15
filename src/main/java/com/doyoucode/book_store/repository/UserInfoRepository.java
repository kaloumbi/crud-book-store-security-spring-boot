package com.doyoucode.book_store.repository;


import com.doyoucode.book_store.entity.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserInfoRepository extends MongoRepository<UserInfo, String> {

    Optional<UserInfo> findByUserName(String userName);
}
