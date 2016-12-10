package com.hxp.mvpdemo.model;

/**
 * Created by HXP on 2016/12/11.
 */

public interface ICallback<T> {
    public void onSuccess(T t);
    public void onFail();
}
