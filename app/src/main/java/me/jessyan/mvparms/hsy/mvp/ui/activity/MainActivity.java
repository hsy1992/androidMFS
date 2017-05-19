package me.jessyan.mvparms.hsy.mvp.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;

import com.jaeger.library.StatusBarUtil;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.jess.arms.widget.ui.navigation.NavigationManager;
import com.jess.arms.widget.ui.navigation.NavigationModel;
import com.jess.arms.widget.ui.navigation.NavigationView;
import com.jess.arms.widget.ui.navigation.TabModel;

import butterknife.BindView;
import me.jessyan.mvparms.hsy.R;
import me.jessyan.mvparms.hsy.di.component.DaggerMainComponent;
import me.jessyan.mvparms.hsy.di.module.MainModule;
import me.jessyan.mvparms.hsy.mvp.contract.MainContract;
import me.jessyan.mvparms.hsy.mvp.presenter.MainPresenter;
import me.jessyan.mvparms.hsy.mvp.ui.fragment.HomeFragment;
import me.jessyan.mvparms.hsy.mvp.ui.fragment.MeFragment;

/**
 * Created by haosiyuan on 2017/5/5.
 * 主页
 */

public class MainActivity extends BaseActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.navigationView)
    NavigationView navigationView;
    //导航栏
    private NavigationManager navigationManager;
    private HomeFragment homeFragment = new HomeFragment();
    private MeFragment meFragment = new MeFragment();

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainComponent.builder()
                .appComponent(appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View initView() {
        return LayoutInflater.from(this).inflate(R.layout.activity_main, null);
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTransparentForImageViewInFragment(this, null);
    }

    @Override
    protected void initData() {
        //初始化导航栏
        navigationManager = new NavigationManager()
                .addFragmentManager(getSupportFragmentManager())
                .addTab(new NavigationModel
                        .Builder()
                        .setColorCheck(Color.parseColor("#fb5b81"))
                        .setColorNormal(Color.parseColor("#7e7e7e"))
                        .setTextSize(100)
                        .setDirection(NavigationManager.DIRECTION_BOTTOM)
                        .setTabHeight(145)
                        .addTab(new TabModel(homeFragment, R.mipmap.mfs_tab_reinforce_no, R.mipmap.mfs_tab_reinforce_se, "爱豆"))
                        .addTab(new TabModel(meFragment, R.mipmap.mfs_tab_fanscircle_no, R.mipmap.mfs_tab_fanscircle_se, "发现"))
                        .addTab(new TabModel(new HomeFragment(), R.mipmap.mfs_tab_rank_no, R.mipmap.mfs_tab_rank_se, "应援部"))
                        .addTab(new TabModel(new HomeFragment(), R.mipmap.mfs_tab_mine_no, R.mipmap.mfs_tab_mine_se, "我的"))
                        .build());
        navigationManager.build(navigationView);
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
        finish();
    }


    /**
     * 返回键
     */
    @Override
    public void onBackPressed() {
        //放入后台
        moveTaskToBack(true);
    }

    /**
     * 销毁
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        //导航栏
        navigationManager = null;
        //fragment
        meFragment = null;
        homeFragment = null;
    }

}
