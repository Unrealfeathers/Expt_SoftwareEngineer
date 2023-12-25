package com.expt.Expt_SoftwareEngineer.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import net.minidev.json.annotate.JsonIgnore;

import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(value = "password", allowSetters = true)
public class User {
    @NotNull
    private Integer userId;

    @NotEmpty
    private Integer typeId;

    @NotEmpty
    @Pattern(regexp = "^\\S{2,16}$")
    private String userName;

    @Pattern(regexp = "^\\S{6,32}$")
    private String password;

    @NotEmpty
    @Email
    private String email;

    private String userImg;

    @NotNull
    private LocalDateTime createTime;

    @NotNull
    private LocalDateTime updateTime;
}
