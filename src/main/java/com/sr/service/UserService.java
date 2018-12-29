package com.sr.service;

import com.sr.secondmapper.SecondUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sr.firstmapper.FirstUserMapper;
import com.sr.model.User;

@Service
public class UserService {
    @Autowired
    public FirstUserMapper firstUserMapper;

    @Autowired
    public SecondUserMapper secondUserMapper;

    public User queryfirst(String username, String password) {
        User user = firstUserMapper.queryfirst(username, password);
        return user;
    }

    public User secondQuery(String username, String password) {
        User user = secondUserMapper.queryList(username, password);
        return user;
    }
}
