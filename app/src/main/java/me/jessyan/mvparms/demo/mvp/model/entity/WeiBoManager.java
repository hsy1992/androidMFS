package me.jessyan.mvparms.demo.mvp.model.entity;

/**
 * Created by haosiyuan on 2017/5/15.
 * 微博账号管理
 */

public class WeiBoManager {

    public WeiBoManager(String account) {
        this.account = account;
    }

    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
