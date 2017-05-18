package me.jessyan.mvparms.demo.mvp.ui.adapter;

import android.view.View;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;

import java.util.List;

import butterknife.BindView;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.model.entity.ChooseRank;
import me.jessyan.mvparms.demo.mvp.ui.contact.ChooseRankSelectView;
import me.jessyan.mvparms.demo.mvp.ui.holder.ChooseRankHolder;

/**
 * Created by jess on 9/4/16 12:57
 * Contact with jess.yan.effort@gmail.com
 */
public class ChooseRankAdapter extends DefaultAdapter<ChooseRank> {


    public ChooseRankAdapter(List<ChooseRank> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<ChooseRank> getHolder(View v, int viewType) {
        return new ChooseRankHolder(v,mInfos);
    }

    @Override
    public int getLayoutId(int viewType) {
        return R.layout.recycle_chooserank;
    }
}
