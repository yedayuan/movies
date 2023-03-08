package com.itheima.moves;


import java.io.Serializable;

/**
 * 商家类
 */
public class Business extends Uset implements Serializable {

    private  String shopName;//店铺名
    private  String  address;//店铺地址

    public Business() {
    }

    public Business(String loginName, String usetName, String passWord, char sex, String phone, double money) {
        super(loginName, usetName, passWord, sex, phone, money);
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Business{" +
                "shopName='" + shopName + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
