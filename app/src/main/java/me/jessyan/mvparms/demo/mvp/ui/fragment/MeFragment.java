package me.jessyan.mvparms.demo.mvp.ui.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;

import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerMeComponent;
import me.jessyan.mvparms.demo.di.module.MeModule;
import me.jessyan.mvparms.demo.mvp.contract.MeContract;
import me.jessyan.mvparms.demo.mvp.presenter.MePresenter;

/**
 * Created by haosiyuan on 2017/5/5.
 * 我的页面
 */
public class MeFragment extends BaseFragment<MePresenter> implements MeContract.View {

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerMeComponent
                .builder()
                .appComponent(appComponent)
                .meModule(new MeModule(this))
                .build()
                .inject(this);
    }


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_me, null);
    }

    @Override
    protected void initData() {
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {
        UiUtils.SnackbarText(message);
    }

    @Override
    public void launchActivity(Intent intent) {
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
