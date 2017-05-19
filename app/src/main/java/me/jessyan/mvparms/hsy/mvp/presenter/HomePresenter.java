package me.jessyan.mvparms.hsy.mvp.presenter;

import android.app.Application;

import com.jess.arms.base.App;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.mvparms.hsy.mvp.contract.HomeContract;
import me.jessyan.mvparms.hsy.mvp.model.entity.Home;
import me.jessyan.mvparms.hsy.mvp.ui.adapter.HomeAdapter;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

/**
 * Created by haosiyuan on 2017/5/5.
 */
@FragmentScope
public class HomePresenter extends BasePresenter<HomeContract.Model,HomeContract.View> {

    private RxErrorHandler mErrorHandler;
    private AppManager mAppManager;
    private Application mApplication;

    private List<Home> list = new ArrayList<>();
    private HomeAdapter adapter;
    private AppComponent mAppComponent;

    @Inject
    public HomePresenter(HomeContract.Model model, HomeContract.View rootView, RxErrorHandler handler
            , AppManager appManager, Application application) {
        super(model, rootView);
        this.mApplication = application;
        this.mErrorHandler = handler;
        this.mAppManager = appManager;
        this.mAppComponent =  ((App) mApplication).getAppComponent();
    }

    public void requestApi(){
        mRootView.setToolBar("陈瑶");

        list.add(new Home("陈瑶 吃光全宇宙","1","+1000"));
        list.add(new Home("陈瑶 吃光全宇宙1","2","+1000"));
        list.add(new Home("陈瑶 吃光全宇宙2","3","+1000"));
        list.add(new Home("陈瑶 吃光全宇宙3","4","+1000"));
        list.add(new Home("陈瑶 吃光全宇宙4","5","+1000"));

        adapter = new HomeAdapter(list,
                mAppComponent.appManager().getCurrentActivity() == null
                        ? mAppComponent.Application() : mAppComponent.appManager().getCurrentActivity());
        mRootView.setAdapter(adapter);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mErrorHandler = null;
        mAppManager = null;
        mApplication = null;
        list = null;
        adapter = null;
    }
}
