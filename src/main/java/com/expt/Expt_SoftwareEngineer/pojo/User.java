package com.expt.Expt_SoftwareEngineer.pojo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDateTime;

@Data
public class User {
    @NotNull
    private Integer userId;

    @NotEmpty
    @Pattern(regexp = "^\\S{2,16}$")
    private String userName;

    @JsonIgnore
    @Pattern(regexp = "^\\S{6,32}$")
    private String password;

    @NotEmpty
    private String userType;

    @NotEmpty
    @Email
    private String email;

    private String userImg;

    @NotNull
    private LocalDateTime createTime;

    @NotNull
    private LocalDateTime updateTime;
}
