package com.lwa.shiro.realm;

import com.lwa.shiro.codec.HmacSHA256Utils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * Created by lwa on 2017/4/5.
 */
public class StatelessRealm extends AuthorizingRealm{
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof StatelessToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //根据用户名查找角色，请根据需求实现
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo =  new SimpleAuthorizationInfo();
        authorizationInfo.addRole("admin");
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        StatelessToken statelessToken = (StatelessToken)authenticationToken;
        String username = statelessToken.getUsername();
        String key = getKey(username);//根据用户名获取密钥（和客户端的一样）
        //在服务器端生成客户端参数消息摘要
        String serverDigest = HmacSHA256Utils.digest(key, statelessToken.getParams());
        return null;
    }

    private String getKey(String username) {//得到密钥，此处硬编码一个
        if("admin".equals(username)) {
            return "dadadswdewq2ewdwqdwadsadasd";
        }
        return null;
    }
}
