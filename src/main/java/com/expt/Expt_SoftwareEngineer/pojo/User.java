package com.expt.Expt_SoftwareEngineer.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;

import java.time.LocalDateTime;

@Data
public class User {
    @NotNull
    private Integer userID;

    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String userName;

    @JsonIgnore
    private String password;
    private String userType;

    @NotEmpty
    @Email
    private String email;
    private String userImg;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
