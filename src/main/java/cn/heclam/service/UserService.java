package cn.heclam.service;

import cn.heclam.entity.User;

public interface UserService extends BaseService<User> {

    User findByName(String username);

    void changePassword(Long id, String newPassword);
}
