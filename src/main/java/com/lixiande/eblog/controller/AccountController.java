package com.lixiande.eblog.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.additional.query.impl.QueryChainWrapper;
import com.lixiande.eblog.common.Result;
import com.lixiande.eblog.dto.LoginDto;
import com.lixiande.eblog.entity.User;
import com.lixiande.eblog.service.UserService;
import com.lixiande.eblog.utils.JWTutils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;
import javax.servlet.http.HttpServletResponse;
import java.sql.Wrapper;

@RestController
public class AccountController {
    @Autowired
    UserService userService;
    @Autowired
    JWTutils jwtUtils;

    @PostMapping("/login")
    public Result login(HttpServletResponse response, @Validated@RequestBody LoginDto loginDto){
        User user = userService.getOne(new QueryWrapper<User>().eq("username", loginDto.getUserName()));
        Assert.notNull(user,"用户不存在");
        if(!user.getPassword().equals(SecureUtil.md5(loginDto.getPassWord()))){
            return Result.fail(null,"密码不正确","404");
        }
        String jwt = jwtUtils.generateToken(user.getId());
        response.setHeader("Authorization", jwt);
        response.setHeader("Access-control-Expose-Headers", "Authorization");
        return  Result.succ(MapUtil.builder().
                put("id",user.getId()).
                put("username",user.getUsername()).
                put("avatar",user.getAvatar()).put("email",user.getEmail()),"success"+ jwt, "200");
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return Result.succ(null,"logout now","200");
    }

    @RequiresAuthentication
    @GetMapping("/signin")
    public Result signin(HttpServletResponse response, @Validated@RequestBody LoginDto signinDto){
        return null;
    }



}
