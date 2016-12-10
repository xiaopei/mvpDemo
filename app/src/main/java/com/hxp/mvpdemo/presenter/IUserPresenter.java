package com.hxp.mvpdemo.presenter;

import com.hxp.mvpdemo.bean.UserBean;

/**
 * Created by HXP on 2016/12/11.
 */

public interface IUserPresenter {
    public void saveUserInfo(UserBean userBean);
    public void showUserInfo(int id);
}
