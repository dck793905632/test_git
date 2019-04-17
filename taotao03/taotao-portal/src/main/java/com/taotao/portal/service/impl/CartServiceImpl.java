package com.taotao.portal.service.impl;


import com.taotao.common.utils.CookieUtils;
import com.taotao.common.utils.HttpClientUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.portal.pojo.CartItem;
import com.taotao.portal.service.CartService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/*
购物车
* */
@Service
public class CartServiceImpl implements CartService {

    @Value("${REST_BASE_URL}")
    String REST_BASE_URL;
    @Value("${INFO_URL}")
    String INFO_URL;
    @Override
    public TaotaoResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response) {
        CartItem cartItem =null;
        //获取购物车列表
        List<CartItem> itemList  = getCartItemList(request);
        for (CartItem cItem : itemList ) {
            //如果存在此商品
            if(cItem.getId()==itemId){
                cItem.setNum(cItem.getNum()+num);
                cartItem=cItem;
                break;
            }
        }
        if(cartItem==null){
            cartItem = new CartItem();
            //调用rest接口
            String json = HttpClientUtil.doGet(REST_BASE_URL + INFO_URL + itemId);
            //将json转换为对象
            TaotaoResult result = TaotaoResult.formatToPojo(json, TbItem.class);
            if(result.getStatus()==200){
                TbItem item = (TbItem) result.getData();
                cartItem.setId(item.getId());
                cartItem.setImage(item.getImage()==null?"":item.getImage().split(",")[0]);
                cartItem.setNum(num);
                cartItem.setPrice(item.getPrice());
                cartItem.setTitle(item.getTitle());
            }
            //添加到购物车列表
            itemList.add(cartItem);
        }
        //把购物车列表写入cookie
        CookieUtils.setCookie(request,response,"TT_CART",JsonUtils.objectToJson(itemList),true);

        return TaotaoResult.ok();
    }

    @Override
    public List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response) {
        List<CartItem> itemList = getCartItemList(request);
        return itemList;
    }

    //删除
    @Override
    public TaotaoResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response) {
        List<CartItem> itemList = getCartItemList(request);
        for (CartItem cartItem : itemList) {
            if(cartItem.getId()==itemId){
                itemList.remove(cartItem);
                break;
            }
        }
        CookieUtils.setCookie(request,response,"TT_CART",JsonUtils.objectToJson(itemList));
        return TaotaoResult.ok();
    }

    //获取购物车列表
    private List<CartItem> getCartItemList(HttpServletRequest  request){
        //从cookie中获取购物车列表
        String cartJson = CookieUtils.getCookieValue(request, "TT_CART", true);
        if(cartJson==null){
            return new ArrayList<>();
        }
        try {
            //将json字符串转换为list集合
            List<CartItem> list = JsonUtils.jsonToList(cartJson, CartItem.class);
            return list;
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
