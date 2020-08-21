package com.lixiande.eblog.shiro;

import com.lixiande.eblog.entity.User;
import com.lixiande.eblog.service.UserService;
import com.lixiande.eblog.utils.JWTutils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountLockedException;

@Component
public class AccountRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;
    @Autowired
    JWTutils jwtUtils;


    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return authenticationToken instanceof JwtToken;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        JwtToken jwtToken =  (JwtToken) authenticationToken;
        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();
        User user = userService.getById(Long.valueOf(userId));
        if(user==null){
            throw new UnknownAccountException("--------------账户不存在------------------------");
        }
        if(user.getStatus()!=1){
            throw new LockedAccountException("--------------账户被锁定------------------------");
        }
        AccountProfile accountProfile = new AccountProfile();
        BeanUtils.copyProperties(user,accountProfile);
        return new SimpleAuthenticationInfo(accountProfile,jwtToken.getCredentials(), getName());
    }


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
