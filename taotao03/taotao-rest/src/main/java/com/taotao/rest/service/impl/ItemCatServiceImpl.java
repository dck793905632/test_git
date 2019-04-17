package com.taotao.rest.service.impl;

import com.taotao.common.utils.JsonUtils;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.rest.dao.JedisClient;
import com.taotao.rest.pojo.CatNode;
import com.taotao.rest.pojo.CatResult;
import com.taotao.rest.service.ItemCatSercice;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemCatServiceImpl implements ItemCatSercice {
    @Autowired
    private TbItemCatMapper itemCatMapper;
    @Autowired
    private JedisClient jedisClient;
    @Value("${LEFT_CONTENT_REDIS_KRY}")
    String LEFT_CONTENT_REDIS_KRY;
    @Override
    public CatResult getItemCatList() {
        //从缓存中查取信息
        try {
            //取出信息
            String catresult1 = jedisClient.hget("LEFT_CONTENT_REDIS_KRY", "cat");
            if(!StringUtils.isBlank(catresult1)){
                //将字符串转换为对象
                CatResult catResultPojo = JsonUtils.jsonToPojo(catresult1, CatResult.class);
                return catResultPojo;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        CatResult catResult = new CatResult();
        catResult.setData(getItemCat(0));

        //存入redis缓存中
        try {

            //将catResult对象转为字符串
            String catResultStr = JsonUtils.objectToJson(catResult);
            jedisClient.hset("LEFT_CONTENT_REDIS_KRY","cat",catResultStr);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return catResult;
    }

    private List<?> getItemCat(long parentId){
        //
        //创建数据库条件
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria=example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        //获取数据库信息
        List<TbItemCat> list = itemCatMapper.selectByExample(example);
        //返回值list
        List resultList = new ArrayList<>();
        //将list添加至返回值
        int count = 0;
        for (TbItemCat tbItemCat : list) {
            //判断是否为父节点
            if(tbItemCat.getIsParent()){
                //创建CatNode对象
                CatNode catNode = new CatNode();
                if (parentId==0){
                    catNode.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
                }else {
                    catNode.setName(tbItemCat.getName());
                }
                catNode.setUrl(	"/products/"+tbItemCat.getId()+".html");
                catNode.setItem(getItemCat(tbItemCat.getId()));
                resultList.add(catNode);
                count++;
                if(count>=14){
                    break;
                }
            }else {
                resultList.add("/products/"+tbItemCat.getId()+".html|" + tbItemCat.getName());
            }

        }
        return resultList;
    }
}
