package com.hxp.mvpdemo.model;

import com.hxp.mvpdemo.bean.UserBean;

/**
 * Created by HXP on 2016/12/11.
 */

public class UserModelImpl implements IUserModel {
    @Override
    public void getUserInfo(final int id, final ICallback callback) {
        new Thread() {
            @Override
            public void run(){
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                //模拟获取用户信息成功
                if (id == 1){
                    UserBean user = new UserBean();
                    user.setName("lucy");
                    user.setSex("female");
                    user.setSign("be what you want to be!");
                    callback.onSuccess(user);
                } else{
                    callback.onFail();
                }
            }
        }.start();
    }

    @Override
    public void saveUserInfo(final UserBean userBean, final ICallback callback) {
        new Thread() {
            @Override
            public void run(){
                try{
                    Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
                //模拟获取用户信息成功
                if (userBean != null){
                    callback.onSuccess(null);
                } else{
                    callback.onFail();
                }
            }
        }.start();
    }
}
