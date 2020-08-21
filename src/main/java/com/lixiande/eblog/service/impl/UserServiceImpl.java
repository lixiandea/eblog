package com.lixiande.eblog.service.impl;

import com.lixiande.eblog.entity.User;
import com.lixiande.eblog.mapper.UserMapper;
import com.lixiande.eblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lixiande
 * @since 2020-07-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
