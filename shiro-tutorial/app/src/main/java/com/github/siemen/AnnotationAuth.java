package com.github.siemen;
/**
 * Created by Zhan on 2017-09-29.
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.*;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 *
 */
public class AnnotationAuth {

    @RequiresAuthentication
    public void methodA(){
        //要求验证通过
        if(!SecurityUtils.getSubject().isAuthenticated()){
            throw new AuthorizationException();
        }
    }

    @RequiresGuest
    public void methdB(){
        //要求没被验证和记住
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principals = subject.getPrincipals();
        if(principals != null && !principals.isEmpty()){
            throw new AuthorizationException();
        }
    }

    @RequiresPermissions("resource:action")
    public void methdC(){
        //要求具有某权限
        Subject subject = SecurityUtils.getSubject();
        if(!subject.isPermitted("resource:action")){
            throw new AuthorizationException();
        }
    }

    @RequiresRoles("admin")
    public void methodD(){
        //要求具有某角色
        Subject subject = SecurityUtils.getSubject();
        if(!subject.hasRole("admin")){
            throw new AuthorizationException();
        }
    }

    @RequiresUser
    public void methodE(){
        //要求为应用程序用户：
        //已拥有身份：通过验证或rememberd 与 guest相反
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principals = subject.getPrincipals();
        if(principals == null || principals.isEmpty()){
            throw new AuthorizationException();
        }
    }
}
