package com.taotao.rest.service.impl;

import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import com.taotao.pojo.TbContentExample;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ContentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private TbContentMapper contentMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${INDEX_CONTENT_REDIS_KEY}")
    String INDEX_CONTENT_REDIS_KEY;
    @Override
    public List<TbContent> getContentByCategoryId(long categoryId) {
        //从缓存中查询

        try {
            //获取缓存中的值
            String result = jedisClient.hget("INDEX_CONTENT_REDIS_KEY", categoryId + "");
            if (!StringUtils.isBlank(result)) {
                //将字符串转换为list
                List<TbContent> resultList = JsonUtils.jsonToList(result, TbContent.class);
                //返回
                return resultList;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        //确定查询条件
        TbContentExample example = new TbContentExample();
        TbContentExample.Criteria criteria = example.createCriteria();
        criteria.andCategoryIdEqualTo(categoryId);
        //执行sql语句
        List<TbContent> list = contentMapper.selectByExample(example);

        //加入到缓存中
        try {
            //list转换为字符串
            String str = JsonUtils.objectToJson(list);
            //将信息存入缓存
            jedisClient.hset("INDEX_CONTENT_REDIS_KEY", categoryId + "", str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
