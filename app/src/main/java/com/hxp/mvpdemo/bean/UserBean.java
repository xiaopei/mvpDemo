package com.hxp.mvpdemo.bean;

import java.io.Serializable;

/**
 * Created by HXP on 2016/12/11.
 */

public class UserBean implements Serializable {
    private int id;
    private String name;
    private String sex;
    private String sign;

    public UserBean() {
    }

    public UserBean(int id, String name, String sex, String sign) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.sign = sign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
