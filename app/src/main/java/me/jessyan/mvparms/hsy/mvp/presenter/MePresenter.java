package me.jessyan.mvparms.hsy.mvp.presenter;

import android.app.Application;

import com.jess.arms.base.App;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;

import javax.inject.Inject;

import me.jessyan.mvparms.hsy.mvp.contract.MeContract;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

/**
 * Created by haosiyuan on 2017/5/17.
 * 我的页面
 */
@FragmentScope
public class MePresenter extends BasePresenter<MeContract.Model,MeContract.View> {

    private RxErrorHandler mErrorHandler;
    private AppManager mAppManager;
    private Application mApplication;
    private AppComponent mAppComponent;

    @Inject
    public MePresenter(MeContract.Model model, MeContract.View rootView, RxErrorHandler handler
            , AppManager appManager, Application application) {
        super(model, rootView);
        this.mApplication = application;
        this.mErrorHandler = handler;
        this.mAppManager = appManager;
        this.mAppComponent =  ((App) mApplication).getAppComponent();
    }


}
