package cn.heclam.mapper;

import cn.heclam.entity.User;

public interface UserMapper {

    User findByName(String username);

    User findById(Long id);

    void update(User user);

    void create(User user);

    void delete(Long id);
}
