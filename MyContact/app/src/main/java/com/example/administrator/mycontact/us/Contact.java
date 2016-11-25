package com.example.administrator.mycontact.us;

/**
 * Created by Administrator on 2016/8/18.
 */
public class Contact {
    public String name;
    public String qq;
    public String phone;

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }
}

