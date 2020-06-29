package com.itcast.store.domain;

public class CartItem {
    //购物项
    //购物项包括product对象，购买数量，购买钱数
    private Product product;
    private int num;
    private double subTotal;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
    //购买总钱数计算得

    public double getSubTotal() {
        return num*product.getShop_price();
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }
}
