package com.expt.Expt_SoftwareEngineer.pojo;

import lombok.Data;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.time.LocalDateTime;

@Data
public class User {
    private Integer userID;
    private String userName;
    private String password;
    private String userType;
    private String email;
    private String userImg;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
