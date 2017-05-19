package me.jessyan.mvparms.hsy.mvp.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.jess.arms.widget.SelectView;
import com.jess.arms.widget.autolayout.AutoToolbar;

import org.simple.eventbus.Subscriber;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.mvparms.hsy.R;
import me.jessyan.mvparms.hsy.di.component.DaggerChooseRankComponent;
import me.jessyan.mvparms.hsy.di.module.ChooseRankModule;
import me.jessyan.mvparms.hsy.mvp.contract.ChooseRankContract;
import me.jessyan.mvparms.hsy.mvp.eventbus.ChooseRankChangeEvent;
import me.jessyan.mvparms.hsy.mvp.presenter.ChooseRankPresenter;
import me.jessyan.mvparms.hsy.mvp.ui.contact.ChooseRankSelectView;

/**
 * Created by haosiyuan on 2017/5/11.
 * 选择净化词页面
 */
public class ChooseRankActivity extends BaseActivity<ChooseRankPresenter> implements ChooseRankContract.View, SelectView.OnCheckChangeListener {

    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.ll_left)
    LinearLayout llLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.ll_right)
    LinearLayout llRight;
    @BindView(R.id.img_right)
    ImageView imgRight;
    @BindView(R.id.rl_weibo)
    RelativeLayout rlWeibo;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.appbar)
    AutoToolbar appbar;
    @BindView(R.id.choose_all)
    ChooseRankSelectView chooseAll;
    @BindView(R.id.tv_jinghua)
    TextView tvJinghua;


    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerChooseRankComponent
                .builder()
                .appComponent(appComponent)
                .chooseRankModule(new ChooseRankModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected View initView() {
        return LayoutInflater.from(this).inflate(R.layout.activity_choose_rank, null);
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTransparentForImageView(this, null);
    }

    @Override
    protected void initData() {
        //初始化标题
        mPresenter.initToolBar(tvTitle, tvLeft, tvRight);
        setSupportActionBar(appbar);
        //获取数据
        mPresenter.requestAPI();
        //选择监听
        chooseAll.setOnCheckChangeListener(this);
    }

    //选择监听
    @Override
    public void onCheckChange(View view, boolean isCheck) {
        mPresenter.ChooseAll(isCheck);
    }

    //设置适配器
    @Override
    public void setAdapter(DefaultAdapter adapter) {
        recyclerView.setAdapter(adapter);
        initRecycleView();
    }


    //设置选择数量
    @Subscriber
    public void onEventMainThread(ChooseRankChangeEvent event) {
        tvJinghua.setText("开始净化(" + event.getChooseNum() + ")");
    }

    /**
     * 初始化RecycleView
     */
    private void initRecycleView() {
        UiUtils.configRecycleView(recyclerView, new LinearLayoutManager(this));
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
     * 点击事件
     *
     * @param view
     */
    @OnClick({R.id.ll_left, R.id.ll_right, R.id.rl_weibo})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_left:
                //标题左侧点击
                mPresenter.AppBarLeftClick();
                break;
            case R.id.ll_right:
                //标题右侧点击
                mPresenter.AppBarRightClick();
                break;
            case R.id.rl_weibo:
                //微博账号管理
                mPresenter.WeiBoManager();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        DefaultAdapter.releaseAllHolder(recyclerView);//super.onDestroy()之后会unbind,所有view被置为null,所以必须在之前调用
        super.onDestroy();
    }

}
