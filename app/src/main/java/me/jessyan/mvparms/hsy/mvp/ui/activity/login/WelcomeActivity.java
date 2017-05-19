package me.jessyan.mvparms.hsy.mvp.ui.activity.login;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import com.jaeger.library.StatusBarUtil;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.mvp.IView;
import com.jess.arms.utils.UiUtils;


import me.jessyan.mvparms.hsy.R;
import me.jessyan.mvparms.hsy.di.component.login.DaggerWelcomeComponent;
import me.jessyan.mvparms.hsy.di.module.login.WelcomeModule;
import me.jessyan.mvparms.hsy.mvp.presenter.login.WelcomePresenter;

/**
 * Created by haosiyuan on 2017/5/3.
 * 欢迎页
 */

public class WelcomeActivity extends BaseActivity<WelcomePresenter> implements IView{


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerWelcomeComponent
                .builder()
                .appComponent(appComponent)
                .welcomeModule(new WelcomeModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View initView() {
        //全屏
        getWindow().setFlags(WindowManager.LayoutParams. FLAG_FULLSCREEN ,
                WindowManager.LayoutParams. FLAG_FULLSCREEN);
        return LayoutInflater.from(this).inflate(R.layout.activity_welcome, null, false);
    }

    @Override
    protected void initData() {
        //开始倒计时
        mPresenter.startCountDownTimer();
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTransparentForImageView(this,null);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void launchActivity(Intent intent) {
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }
}
