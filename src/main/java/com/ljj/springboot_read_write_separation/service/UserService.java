package com.ljj.springboot_read_write_separation.service;

import com.ljj.springboot_read_write_separation.entity.User;

import java.util.List;

/**
 * @author: ljj
 * @Date: 2019/9/10 16:03
 * @Description:
 */
public interface UserService {
    int insert(User user);

    int saveUser(User user);

    List<User> selectUserList();

    User selectUserById(Long id);

    int deleteUserById(Long id);
}
