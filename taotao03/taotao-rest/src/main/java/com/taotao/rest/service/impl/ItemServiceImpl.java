package com.taotao.rest.service.impl;

import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private TbItemMapper itemMapper;
    @Autowired
    private TbItemDescMapper itemDescMapper;
    @Autowired
    private TbItemParamItemMapper itemParamItemMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${REDIS_ITEM_KEY}")
    String REDIS_ITEM_KEY;
    @Value("${REDIS_TIME}")
    Integer REDIS_TIME;
    @Override
    public TaotaoResult getItemBaseInfo(long itemId) {

        try {
            //缓存逻辑
            //从redis中取数据
            String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":base");
            if(!StringUtils.isBlank(json)){
                TbItem item = JsonUtils.jsonToPojo(json, TbItem.class);
                return TaotaoResult.ok(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        TbItem item = itemMapper.selectByPrimaryKey(itemId);

        try {
            //将数据存到redis
            jedisClient.set(REDIS_ITEM_KEY+":"+itemId+":base", JsonUtils.objectToJson(item));
            //设置过期时间
            jedisClient.expire(REDIS_ITEM_KEY+":"+itemId+":base",REDIS_TIME);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TaotaoResult.ok(item);
    }

    @Override
    public TaotaoResult getItemDesc(long itemId) {
        try {
            //从缓存中获取信息
            String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":desc");
            if (!StringUtils.isBlank(json)){
                //将json转化为对象
                TbItemDesc itemDesc = JsonUtils.jsonToPojo(json, TbItemDesc.class);
                return TaotaoResult.ok(itemDesc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        //执行数据库语句获取信息
        TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);

        try {
            //将信息插入缓存
            jedisClient.set(REDIS_ITEM_KEY+":"+itemId+":desc",JsonUtils.objectToJson(itemDesc));
            //设置过期时间
            jedisClient.expire(REDIS_ITEM_KEY+":"+itemId+":desc",REDIS_TIME);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return TaotaoResult.ok(itemDesc);
    }

    @Override
    public TaotaoResult getItemParam(long itemId) {
        //从缓存中取数据
        String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId + ":pram");
        //转java对象
        if(!StringUtils.isBlank(json)){
            TbItemParamItem itemParamItem = JsonUtils.jsonToPojo(json, TbItemParamItem.class);
            return TaotaoResult.ok(itemParamItem);
        }
        //从数据库查信息
        TbItemParamItemExample example = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemParamItem> list = itemParamItemMapper.selectByExampleWithBLOBs(example);

        if(list!=null&&list.size()>0){
            TbItemParamItem itemParamItem = list.get(0);
            try {

                //存入缓存中
                jedisClient.set(REDIS_ITEM_KEY+":"+itemId+":pram",JsonUtils.objectToJson(itemParamItem));
                //设置过期时间
                jedisClient.expire(REDIS_ITEM_KEY+":"+itemId+":pram",REDIS_TIME);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return TaotaoResult.ok(itemParamItem);
        }

        return TaotaoResult.build(400,"无此数据");
    }
}
