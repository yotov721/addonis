package com.addonis.demo.services;

import com.addonis.demo.models.UserInfo;
import com.addonis.demo.repository.contracts.UserInfoRepository;
import com.addonis.demo.services.contracts.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    UserInfoRepository userInfoRepository;

    @Autowired
    public UserInfoServiceImpl(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public UserInfo findByEmailAddress(String emailAddress) {
        return userInfoRepository.findByEmailAddress(emailAddress);
    }
}