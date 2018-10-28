package com.hitsme.sshdemo.service.impl;

import com.hitsme.sshdemo.entity.User;
import com.hitsme.sshdemo.dao.UserDao;
import com.hitsme.sshdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mgl
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = true)
    private UserDao userDao;

    @Override
    public Long saveUser() {
        User user = new User();
        user.setUsername("11111");
        user.setPassword("11111");
        return userDao.save(user);
    }
}
