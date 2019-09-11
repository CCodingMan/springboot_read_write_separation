package com.ljj.springboot_read_write_separation.service.impl;

import com.ljj.springboot_read_write_separation.annotation.Master;
import com.ljj.springboot_read_write_separation.entity.User;
import com.ljj.springboot_read_write_separation.mapper.UserMapper;
import com.ljj.springboot_read_write_separation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: ljj
 * @Date: 2019/9/10 16:04
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int insert(User user) {
        return userMapper.saveUser(user);
    }

    @Master
    @Transactional(rollbackFor = Exception.class)
    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public List<User> selectUserList() {
        return userMapper.selectAllUser();
    }

    @Override
    public User selectUserById(Long id) {
        return userMapper.selectUserById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int deleteUserById(Long id) {
        return userMapper.deleteUserById(id);
    }
}
