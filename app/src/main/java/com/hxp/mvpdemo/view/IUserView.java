package com.hxp.mvpdemo.view;

/**
 * Created by HXP on 2016/12/11.
 */

public interface IUserView {
    public int getId();
    public String getName();

    public void setName(String name);

    public String getSex();

    public void setSex(String sex);

    public String getSign();

    public void setSign(String sign);

    public void showProcess();
    public void dismissProcess();
    public void showMessage(String msg);
}
