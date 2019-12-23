package com.vanrf.mapper;

import com.vanrf.bean.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao  {
    @Select("select * from t_user where username=#{username} and password=#{password}")
    User login(User user);
    @Update("UPDATE t_user SET password = #{password} WHERE user_id = #{userId}")
    Integer update(Integer userId,String password);
    @Select("select * from t_user")
    List<User> findAll();
}
