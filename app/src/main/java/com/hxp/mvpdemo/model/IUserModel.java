package com.hxp.mvpdemo.model;

import com.hxp.mvpdemo.bean.UserBean;

/**
 * Created by HXP on 2016/12/11.
 */

public interface IUserModel {
    public void getUserInfo(int id,ICallback callback);
    public void saveUserInfo(UserBean userBean, ICallback callback);
}
