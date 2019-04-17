package com.taotao.sso.service.impl;

import com.sun.scenario.effect.impl.prism.PrImage;
import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbUserMapper;
import com.taotao.pojo.TbUser;
import com.taotao.pojo.TbUserExample;
import com.taotao.sso.dao.JedisClient;
import com.taotao.sso.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import redis.clients.jedis.JedisCluster;

import javax.naming.ldap.PagedResultsControl;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TbUserMapper userMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${REDIS_USER_SESSION_KEY}")
    String REDIS_USER_SESSION_KEY;
    @Value("${SSO_SESSION_EXPIRE}")
    Integer SSO_SESSION_EXPIRE;
    @Override
    public TaotaoResult checkData(String content, Integer type) {
        //对数据进行校验：1、2、3分别代表username、phone、email
        //创建查询条件
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        //判断查询类型
        if(1==type){
            criteria.andUsernameEqualTo(content);
        }else if (2==type){
            criteria.andPhoneEqualTo(content);
        }else {
            criteria.andEmailEqualTo(content);
        }
        List<TbUser> list = userMapper.selectByExample(example);
        if(list==null||list.size()==0){
            return TaotaoResult.ok(true);
        }
        return TaotaoResult.ok(false);
    }

    @Override
    public TaotaoResult createUser(TbUser user) {
        user.setCreated(new Date());
        user.setUpdated(new Date());
        //使用md5加密
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        userMapper.insert(user);
        return TaotaoResult.ok();
    }

    @Override
    public TaotaoResult userLogin(String username, String password,
                                  HttpServletRequest request, HttpServletResponse response) {
        TbUserExample example = new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<TbUser> list = userMapper.selectByExample(example);
        //判断有无信息
        if(list==null||list.size()==0){
            return TaotaoResult.build(400,"用户名或密码错误");
        }
        TbUser user = list.get(0);
        if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())){
            return TaotaoResult.build(400,"用户名或密码错误");
        }
        //生成token
        String token = UUID.randomUUID().toString();
        //保存用户对象之前，把密码清空
        user.setPassword(null);
        //把用户信息写入redis
        jedisClient.set(REDIS_USER_SESSION_KEY+":"+token, JsonUtils.objectToJson(user));
        //设置过期时间
        jedisClient.expire(REDIS_USER_SESSION_KEY+":"+token ,SSO_SESSION_EXPIRE);
        //写入cookie
        CookieUtils.setCookie(request,response,"TT_TOKEN",token);
        //返回token
        return TaotaoResult.ok(token);
    }

    @Override
    public TaotaoResult getUserByToken(String token) {
        String json = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + token);
        //判断是否为空
        if(StringUtils.isBlank(json)){
            return TaotaoResult.build(400,"长时间未操作，请重新登陆");
        }
        //更新过期时间
        jedisClient.expire(REDIS_USER_SESSION_KEY+":"+token ,SSO_SESSION_EXPIRE);
        //返回用户信息
        return TaotaoResult.ok(JsonUtils.jsonToPojo(json,TbUser.class));
    }

    //安全退出
    @Override
    public TaotaoResult Userlogout(String token, String callback) {
        String json = jedisClient.get(REDIS_USER_SESSION_KEY + ":" + token);
        if(json!=null){
            jedisClient.del(REDIS_USER_SESSION_KEY + ":" + token);
        }
        return TaotaoResult.ok();
    }
}
