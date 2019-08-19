package cn.heclam.service.impl;

import cn.heclam.entity.User;
import cn.heclam.mapper.UserMapper;
import cn.heclam.service.PasswordHelper;
import cn.heclam.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    //注入
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordHelper passwordHelper;

    @Override
    public User findByName(String username) {
        return userMapper.findByName(username);
    }

    @Override
    public void changePassword(Long id, String newPassword) {
        User user = userMapper.findById(id);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userMapper.update(user);
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findById(Long id) {
        return null;
    }

    @Override
    public void create(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        userMapper.create(user);
    }

    @Override
    public void update(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        userMapper.update(user);
    }

    @Override
    public void delete(Long... ids) {
        for (Long id : ids){
            userMapper.delete(id);
        }
    }
}
