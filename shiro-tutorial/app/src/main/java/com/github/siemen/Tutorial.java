package com.github.siemen;
/**
 * Created by Zhan on 2017-09-27.
 */

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.Sha256CredentialsMatcher;
import org.apache.shiro.config.Ini;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 */
public class Tutorial {

    private static final Logger logger = LoggerFactory.getLogger(Tutorial.class);

    public static void main(String[] args) {

        Ini ini = new Ini();
        ini.addSection("'").put("","");

        logger.info("My first apache shiro app");

        //prepare
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //get current subject
        Subject currentUser = SecurityUtils.getSubject();
        //use session and pass k-v

        Session session = currentUser.getSession();
        session.setAttribute("Key","Value");
        String value = (String) session.getAttribute("Key");
        if("Value".equals(value)){
            logger.info("Retrieved the correct vlaue![value]",value);
        }

        if(!currentUser.isAuthenticated()){
            //collect user principals: user-pass,openid,x509
            UsernamePasswordToken token = new UsernamePasswordToken("lonestrar", "vespa");
            //authenticated 与 remebered 互斥  不同操作下的安全要求不同
            //to support remember me
            token.setRememberMe(true);
            //currentUser.isRemembered();
            try {
                currentUser.login(token);
                //ModularRealmAuthenticator.authemticate(token)
                //doSingleRealmAuthentication   doMultiRealmAuthentication
                //realm.supports(token) realm.getAuthenticationInfo(token)
                //strategy.beforeAllAttempts  afterAllAttempts
            }catch (UnknownAccountException uae){
                //user not exists
                logger.error("user account not exists[{}]",token.getUsername());
            }catch (IncorrectCredentialsException ice){
                //password didn't mathc
                logger.error("password is wrong");
            }catch (LockedAccountException lae){
                //user locked
                logger.error("user account is locked [{}]",token.getUsername());
            }catch (AuthenticationException ae){
                //other exception
                logger.error("error happend");
            }
            //get who is this
            logger.info("user [{}] logged successfully",currentUser.getPrincipal());
            //test if has a role
            //rolePermissionResolver
            //info.getRoles().contains(roleIdentifier)
            if(currentUser.hasRole("schwartz")){
                logger.info("May the Schwartz with you");
            }else{
                logger.info("hello, mere mortal");
            }
            //test if has permission on xx
            //securityManager.isPermitted  authorizer.isPermitted
            //((Authorizer)realm).isPermitted(principals, permission))
            //Permission p = this.getPermissionResolver().resolvePermission(permission);
            if(currentUser.isPermitted("lightsaber:weild")){
                logger.info("You may use a lightsaber ring,Use it wisely");
            }else{
                logger.info("Sorry,lightsaber rings are for schwartz masters only");
            }
            //deep check
            if(currentUser.isPermitted("winnebago:drive:eagle5")){
                logger.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5' . \" +\n" +
                        "\"Here are the keys - have fun!");
            }else{
                logger.info("Sorry, you are not allowed to drive eagle5 winnebago");
            }
            //logout and clear identify information
            currentUser.logout();
        }

        System.exit(0);
    }
}
