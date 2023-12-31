package com.expt.Expt_SoftwareEngineer.mapper;

import com.expt.Expt_SoftwareEngineer.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    // 根据用户名查询用户
    @Select("SELECT * FROM user WHERE user_name = #{username}")
    User findByUserName(String username);

    // 添加用户
    @Insert("INSERT INTO user(user_name,password,create_time,update_time) " +
            "VALUES(#{username},#{password},now(),now())")
    void addUser(String username, String password);

    @Update("UPDATE user SET user_name = #{userName},email = #{email},update_time = now() WHERE user_id = #{userId}")
    void update(User user);

    @Update("UPDATE user SET user_img = #{avatarUrl},update_time = now() WHERE user_id = #{id}")
    void updateAvatar(String avatarUrl, Integer id);

    @Update("UPDATE user SET password = #{password},update_time = now() WHERE user_id = #{id}")
    void updatePwd(String password, Integer id);
}
