package me.jessyan.mvparms.demo.mvp.ui.adapter;

import android.content.Context;
import android.view.View;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;

import java.util.List;

import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.model.entity.Home;
import me.jessyan.mvparms.demo.mvp.ui.holder.HomeHeadHolder;
import me.jessyan.mvparms.demo.mvp.ui.holder.HomeItemHolder;

/**
 * Created by haosiyuan on 2017/5/10.
 * 主页
 */

public class HomeAdapter extends DefaultAdapter<Home> {

    private static int RECYCLE_HEAD = 0;
    private static int RECYCLE_ITEM = 1;
    private List<Home> list;
    private Context mContext;

    public HomeAdapter(List<Home> infos, Context mContext) {
        super(infos);
        this.list = infos;
        this.mContext = mContext;
    }

    @Override
    public BaseHolder<Home> getHolder(View v, int viewType) {
        return viewType == RECYCLE_HEAD ? new HomeHeadHolder(v,mContext) : new HomeItemHolder(v,list);
    }

    @Override
    public int getLayoutId(int viewType) {
        return viewType == RECYCLE_HEAD ? R.layout.recycle_home_head : R.layout.recycle_home_item;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + 1;
    }

    //重构
    @Override
    public void onBindViewHolder(BaseHolder<Home> holder, int position) {
        if (position != 0){
            holder.setData(mInfos.get(position - 1), position);
        }else {
            holder.setData(null, position);

        }
    }

    /**
     * viewtype 类型
     *
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {
        return position == 0 ? RECYCLE_HEAD : RECYCLE_ITEM;
    }

}
