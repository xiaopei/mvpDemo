package com.hxp.mvpdemo.presenter;

import android.os.Handler;
import android.os.Looper;

import com.hxp.mvpdemo.bean.UserBean;
import com.hxp.mvpdemo.model.ICallback;
import com.hxp.mvpdemo.model.IUserModel;
import com.hxp.mvpdemo.model.UserModelImpl;
import com.hxp.mvpdemo.view.IUserView;



/**
 * Created by HXP on 2016/12/11.
 */

public class UserPresenterImpl implements IUserPresenter{
    private IUserModel userModel;
    private IUserView userView;
    Handler handler = new Handler(Looper.getMainLooper()) ;

    public UserPresenterImpl(IUserView userView) {
        this.userView = userView;
        userModel = new UserModelImpl();
    }

    @Override
    public void saveUserInfo(UserBean userBean) {
        userView.showProcess();
        userModel.saveUserInfo(userBean, new ICallback() {
            @Override
            public void onSuccess(Object o) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.dismissProcess();
                        userView.showMessage("update success");
                    }
                });

            }

            @Override
            public void onFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.dismissProcess();
                        userView.showMessage("update failed");
                    }
                });
            }
        });
    }

    @Override
    public void showUserInfo(int id) {
        userView.showProcess();
        userModel.getUserInfo(id, new ICallback<UserBean>() {
            @Override
            public void onSuccess(final UserBean userBean1) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.dismissProcess();
                        userView.setSex(userBean1.getSex());
                        userView.setName(userBean1.getName());
                        userView.setSign(userBean1.getSign());
                    }
                });
            }

            @Override
            public void onFail() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        userView.dismissProcess();
                        userView.showMessage("get user infomation failed");
                    }
                });
            }
        });
    }
}
