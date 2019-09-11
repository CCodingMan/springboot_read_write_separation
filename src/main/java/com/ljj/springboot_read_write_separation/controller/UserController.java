package com.ljj.springboot_read_write_separation.controller;

import com.ljj.springboot_read_write_separation.entity.User;
import com.ljj.springboot_read_write_separation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ljj
 * @Date: 2019/9/10 16:26
 * @Description:
 */
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saveUser")
    public String saveUser(@RequestBody User user){
        int count = userService.saveUser(user);
        return count > 0 ? "数据以保存" : "数据保存异常";
    }

    @PostMapping("/insertUser")
    public String insertUser(@RequestBody User user){
        int count = userService.insert(user);
        return count > 0 ? "数据以保存" : "数据保存异常";
    }

    @GetMapping("/selectAllUsers")
    public List<User> selectAllUsers(){
        List<User> users = userService.selectUserList();
        return users;
    }

    @GetMapping("/deleteUserById/{id}")
    public String deleteUserById(@PathVariable(name = "id") Long id){
        int count = userService.deleteUserById(id);
        return count == 0 ? "未找到要删除的数据" : String.format("id=%s的用户数据被删除", id);
    }
}
