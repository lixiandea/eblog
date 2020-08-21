package com.lixiande.eblog.controller;


import com.lixiande.eblog.common.Result;
import com.lixiande.eblog.entity.User;
import com.lixiande.eblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.jws.soap.SOAPBinding;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lixiande
 * @since 2020-07-03
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/index")
    public Result index(){
        return Result.succ (userService.getById(1L),"success ", "200");
    }



}
