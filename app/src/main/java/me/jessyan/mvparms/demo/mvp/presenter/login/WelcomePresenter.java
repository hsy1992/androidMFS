package me.jessyan.mvparms.demo.mvp.presenter.login;

import android.app.Application;
import android.content.Intent;
import android.os.CountDownTimer;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.mvp.ui.activity.MainActivity;
import me.jessyan.mvparms.demo.mvp.ui.activity.UserActivity;
import me.jessyan.mvparms.demo.mvp.ui.activity.login.WelcomeActivity;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

/**
 * Created by haosiyuan on 2017/5/3.
 * 欢迎页
 */
@ActivityScope
public class WelcomePresenter extends BasePresenter<IModel,IView> {

    private RxErrorHandler mErrorHandler;//收集rxjava错误的管理器
    private AppManager mAppManager;//activity管理器
    private Application mApplication;//application
    private CountDownTimer countDownTimer;//倒计时

    @Inject
    public WelcomePresenter(IModel model, IView rootView, RxErrorHandler handler
            , AppManager appManager, Application application) {
        super(model, rootView);

        this.mErrorHandler = handler;
        this.mAppManager = appManager;
        this.mApplication = application;

    }

    //倒计时3秒后跳页
    public void startCountDownTimer(){
        countDownTimer = new CountDownTimer(3000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                mRootView.launchActivity(new Intent(mApplication, MainActivity.class));
                mRootView.killMyself();
            }
        }.start();
    }

    //销毁
    @Override
    public void onDestroy() {
        super.onDestroy();
        countDownTimer = null;
    }
}
