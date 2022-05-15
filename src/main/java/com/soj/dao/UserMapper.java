package com.soj.dao;

import com.soj.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Insert("insert into user(name, password) VALUES (#{name}, #{password})")
    int addUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(int id);

    @Select("select * from user where name = #{username} and password = #{password}")
    User getUser(@Param("username") String username, @Param("password") String password);

    @Update("update user set name = #{name}, password = #{password} where id = #{id}")
    int editUser(User user);

    @Select("select * from user")
    List<User> getUsers();
}
