package com.itheima.moves;

import java.io.Serializable;

public  class Uset implements Runnable ,Serializable{
    private  static final long serialversionUID=1;//版本号
    private String loginName;//登录名假名
    private String usetName;//用户名
    private transient String passWord;//密码
    private char sex;//性别
    private String phone;//电话
    private transient double money;//账户余额

    public Uset() {
    }

    public Uset(String loginName, String usetName, String passWord, char sex, String phone, double money) {
        this.loginName = loginName;
        this.usetName = usetName;
        this.passWord = passWord;
        this.sex = sex;
        this.phone = phone;
        this.money = money;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getUsetName() {
        return usetName;
    }

    public void setUsetName(String usetName) {
        this.usetName = usetName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread()+"线执行");
    }

    @Override
    public String toString() {
        return "Uset{" +
                "loginName='" + loginName + '\'' +
                ", usetName='" + usetName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", money=" + money +
                '}';
    }
}
