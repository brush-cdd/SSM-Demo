package com.market.service.impl;

import com.market.mapper.UserMapper;
import com.market.pojo.User;
import com.market.pojo.UserExample;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);

        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null){
            return userList.get(0);
        }
        return null;
    }
}
