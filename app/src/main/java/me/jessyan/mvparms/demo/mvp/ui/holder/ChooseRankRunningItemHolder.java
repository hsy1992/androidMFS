package me.jessyan.mvparms.demo.mvp.ui.holder;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.model.entity.ChooseRank;
import me.jessyan.mvparms.demo.mvp.ui.contact.ChooseRankSelectView;

/**
 * Created by haosiyuan on 2017/5/17.
 * 净化中
 */

public class ChooseRankRunningItemHolder extends BaseHolder<ChooseRank> {

    @BindView(R.id.choose_view)
    ChooseRankSelectView chooseView;
    @BindView(R.id.tv_rankName)
    TextView tvRankName;
    @BindView(R.id.tv_history)
    TextView tvHistory;
    @BindView(R.id.tv_now)
    TextView tvNow;
    @BindView(R.id.loading)
    ImageView loading;
    @BindView(R.id.tv_mingci)
    TextView tvMingci;
    @BindView(R.id.tv_fire)
    TextView tvFire;
    @BindView(R.id.img_head)
    CircleImageView imgHead;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_buttom)
    LinearLayout llButtom;

    private View itemView;

    public ChooseRankRunningItemHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    @Override
    public void setData(ChooseRank data, int position) {

        if (position % 2 == 0){
            itemView.setBackgroundColor(Color.parseColor("#f8f8f8"));
        }else {
            itemView.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        chooseView.setVisibility(View.GONE);
        llButtom.setVisibility(View.VISIBLE);
        loading.setVisibility(View.VISIBLE);
        //动画开始
        if (!((AnimationDrawable)loading.getBackground()).isRunning()){
            ((AnimationDrawable)loading.getBackground()).run();
        }

    }
}
