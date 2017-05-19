package me.jessyan.mvparms.hsy.mvp.ui.holder;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.utils.UiUtils;

import butterknife.BindView;
import me.jessyan.mvparms.hsy.R;
import me.jessyan.mvparms.hsy.mvp.model.entity.Home;
import me.jessyan.mvparms.hsy.mvp.ui.activity.ChooseRankRunningActivity;

/**
 * Created by jess on 9/4/16 12:56
 * Contact with jess.yan.effort@gmail.com
 * 首页头部
 */
public class HomeHeadHolder extends BaseHolder<Home> {

    @BindView(R.id.tv_start)
    TextView tvStart;
    private Context mContext;
    private Intent intent;

    public HomeHeadHolder(View itemView,Context mContext) {
        super(itemView);
        this.mContext = mContext;
    }

    @Override
    public void setData(Home data, int position) {
        //净化跳页
        tvStart.setOnClickListener(v -> {
            intent = new Intent(mContext, ChooseRankRunningActivity.class);
            UiUtils.startActivity(intent);
        });
    }


    @Override
    protected void onRelease() {
        mContext = null;
        intent = null;
    }
}
