package me.jessyan.mvparms.hsy.mvp.ui.adapter;

import android.view.View;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;

import java.util.List;

import me.jessyan.mvparms.hsy.R;
import me.jessyan.mvparms.hsy.mvp.model.entity.ChooseRank;
import me.jessyan.mvparms.hsy.mvp.ui.holder.ChooseRankRunningHeadHolder;
import me.jessyan.mvparms.hsy.mvp.ui.holder.ChooseRankRunningItemHolder;

/**
 * Created by jess on 9/4/16 12:57
 * Contact with jess.yan.effort@gmail.com
 */
public class ChooseRankRunningAdapter extends DefaultAdapter<ChooseRank> {

    private static int RankRunningHead = 0;
    private static int RankRunningItem = 1;

    public ChooseRankRunningAdapter(List<ChooseRank> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<ChooseRank> getHolder(View v, int viewType) {
        return viewType == RankRunningHead ? new ChooseRankRunningHeadHolder(v) : new ChooseRankRunningItemHolder(v);
    }

    @Override
    public int getLayoutId(int viewType) {
        return viewType == RankRunningHead ? R.layout.recycle_chooserunning_head : R.layout.recycle_chooserank;
    }


    //重构
    @Override
    public void onBindViewHolder(BaseHolder<ChooseRank> holder, int position) {
        if (position == 0) {
            holder.setData(null, position);
        } else {
            holder.setData(mInfos.get(position - 1), position);
        }
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? RankRunningHead : RankRunningItem;
    }
}
