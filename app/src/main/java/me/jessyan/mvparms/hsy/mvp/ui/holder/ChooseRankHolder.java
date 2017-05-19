package me.jessyan.mvparms.hsy.mvp.ui.holder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;

import org.simple.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import me.jessyan.mvparms.hsy.R;
import me.jessyan.mvparms.hsy.mvp.eventbus.ChooseRankChangeEvent;
import me.jessyan.mvparms.hsy.mvp.model.entity.ChooseRank;
import me.jessyan.mvparms.hsy.mvp.ui.contact.ChooseRankSelectView;

/**
 * 净化holder
 */
public class ChooseRankHolder extends BaseHolder<ChooseRank> {

    private Context mContext;
    private Intent intent;
    private View itemView;

    @BindView(R.id.choose_view)
    ChooseRankSelectView chooseView;
    @BindView(R.id.tv_rankName)
    TextView tvRankName;
    @BindView(R.id.tv_history)
    TextView tvHistory;
    @BindView(R.id.tv_now)
    TextView tvNow;
    @BindView(R.id.tv_mingci)
    TextView tvMingci;
    @BindView(R.id.tv_fire)
    TextView tvFire;

    private List<ChooseRank> mInfos;

    public ChooseRankHolder(View itemView, List<ChooseRank> mInfos) {
        super(itemView);
        this.itemView = itemView;
        this.mInfos = mInfos;
    }

    @Override
    public void setData(ChooseRank data, int position) {
        if (position % 2 == 0){
            itemView.setBackgroundColor(Color.parseColor("#f8f8f8"));
        }else {
            itemView.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        if (data.isCheck()){
            chooseView.setCheck(true);
        }else{
            chooseView.setCheck(false);
        }

        //选择改变时
        chooseView.setOnCheckChangeListener((view, isCheck) -> {
            if (isCheck){
                mInfos.get(position).setCheck(true);
            }else{
                mInfos.get(position).setCheck(false);
            }
            EventBus.getDefault().post(new ChooseRankChangeEvent(mInfos));
        });
    }


    @Override
    protected void onRelease() {
        mContext = null;
        intent = null;
        mInfos = null;
    }
}
