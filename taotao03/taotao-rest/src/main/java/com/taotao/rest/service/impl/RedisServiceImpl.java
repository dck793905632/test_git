package com.taotao.rest.service.impl;

import com.taotao.common.utils.TaotaoResult;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RedisServiceImpl implements RedisService {
    @Autowired
    private JedisClient jedisClient;
    @Value("${INDEX_CONTENT_REDIS_KEY}")
    String INDEX_CONTENT_REDIS_KEY;
    //大广告位的删除
    @Override
    public TaotaoResult syncContent(long contentCid) {
        jedisClient.hdel(INDEX_CONTENT_REDIS_KEY,contentCid+"");
        return TaotaoResult.ok();
    }
}
