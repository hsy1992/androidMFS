package me.jessyan.mvparms.demo.mvp.contract;


import android.content.Context;

import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

import me.jessyan.mvparms.demo.mvp.ui.adapter.HomeAdapter;

/**
 * Created by haosiyuan on 2017/5/5.
 * 微博账号管理
 */

public interface WeiBoManagerContract {

    interface View extends IView{
        void setAdapter(DefaultAdapter adapter);

        Context getContext();
    }

    interface Model extends IModel {

    }
}
