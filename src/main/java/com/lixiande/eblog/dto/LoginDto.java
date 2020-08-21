package com.lixiande.eblog.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
public class LoginDto {
    @NotBlank(message = "昵称不能为空")
    String userName;
    @NotBlank(message = "密码不能为空")
    String passWord;
}
