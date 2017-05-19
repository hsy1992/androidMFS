package me.jessyan.mvparms.hsy.mvp.ui.holder;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;

import butterknife.BindView;
import me.jessyan.mvparms.hsy.R;
import me.jessyan.mvparms.hsy.mvp.model.entity.ChooseRank;

/**
 * Created by haosiyuan on 2017/5/17.
 * 净化中
 */

public class ChooseRankRunningHeadHolder extends BaseHolder<ChooseRank> {

    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.rl_running)
    RelativeLayout rlRunning;
    @BindView(R.id.tv_rank)
    TextView tvRank;
    @BindView(R.id.tv_rank_content)
    TextView tvRankContent;
    @BindView(R.id.ll_rank_content)
    LinearLayout llRankContent;
    @BindView(R.id.ll_today)
    LinearLayout llToday;

    public ChooseRankRunningHeadHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(ChooseRank data, int position) {
        if (!((AnimationDrawable)rlRunning.getBackground()).isRunning()){
            ((AnimationDrawable)rlRunning.getBackground()).run();
        }
    }
}
