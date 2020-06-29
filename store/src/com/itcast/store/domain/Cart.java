package com.itcast.store.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    //购物车
    //购物车包括未知数量的购物项、所有购物项的总钱数、方法一：添加至购物车、方法二：移除购物车、方法三：清空购物车
    //键值对中的键为product中的pid,值为一个购物项
    Map<String ,CartItem> map = new HashMap<String,CartItem>();
    //所有购物项的总钱数
    private double total;
    //方法一,传入购物项
    public void addCartItemToCart(CartItem cartItem){
        String pid = cartItem.getProduct().getPid();
        //首相判断购物车有无当前购物项，如果没有直接添加，如果有，则添加后的数量为当前数量+原先数量
        if(map.containsKey(pid)){
            CartItem oldCartItem = map.get(pid);
            int oldNum = oldCartItem.getNum();
            int newNum =cartItem.getNum();
            int totalNum = newNum+oldNum;
           /* System.out.println(oldNum);
            System.out.println(newNum);
            System.out.println(totalNum);*/
            oldCartItem.setNum(totalNum);
        }else {
            map.put(pid,cartItem);
        }
    }
    //方法二，移除购物车
    public void removeCart(String pid){
        map.remove(pid);
    }
    //方法三，清空购物车
    public void clearCart(){
        map.clear();
    }

    //判断购物车是否为空
    public Collection<CartItem>  getcartItem(){
        return map.values();
    }

    public Map<String, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }
    //计算总钱数/积分

    public double getTotal() {
        total = 0;
        //Collection<CartItem> values = map.values();
        for (CartItem cartItem:map.values()
             ) {
            total+=cartItem.getSubTotal();
        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
