package com.ljj.springboot_read_write_separation.mapper;

import com.ljj.springboot_read_write_separation.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: ljj
 * @Date: 2019/9/10 14:28
 * @Description:
 */
@Mapper
@Component
public interface UserMapper {
    @Select("select * from user")
    List<User> selectAllUser();

    @Select("select * from user where id = #{id}")
    User selectUserById(@Param("id") Long id);

    int saveUser(@Param("user") User user);

    int deleteUserById(@Param("id") Long id);
}
