package me.jessyan.mvparms.hsy.mvp.ui.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.jess.arms.base.BaseHolder;

import java.util.List;

import butterknife.BindView;
import me.jessyan.mvparms.hsy.R;
import me.jessyan.mvparms.hsy.mvp.model.entity.Home;
import rx.Observable;

/**
 * Created by jess on 9/4/16 12:56
 * Contact with jess.yan.effort@gmail.com
 */
public class HomeItemHolder extends BaseHolder<Home> {

    @BindView(R.id.img_step)
    ImageView imgStep;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.img_line)
    ImageView imgLine;
    @BindView(R.id.tv_mingci)
    TextView tvMingci;
    @BindView(R.id.tv_fire)
    TextView tvFire;
    @BindView(R.id.img_right)
    ImageView imgRight;

    private List<Home> list;

    public HomeItemHolder(View itemView, List<Home> list) {
        super(itemView);
        this.list = list;

    }

    @Override
    public void setData(Home data, int position) {
        Observable.just(data.getRankName())
                .subscribe(RxTextView.text(tvContent));

        Observable.just(data.getRank())
                .subscribe(RxTextView.text(tvMingci));

        Observable.just(data.getFireValue())
                .subscribe(RxTextView.text(tvFire));

        if (position == list.size()){
            imgLine.setVisibility(View.GONE);
        }

        if (position == (list.size()/2 + 1)){
            imgRight.setVisibility(View.VISIBLE);
        }

        if (position == 1){
            imgStep.setImageResource(R.mipmap.ic_clean_tagg1);
        }else if (position == list.size()){
            imgStep.setImageResource(R.mipmap.ic_clean_tagg3);
        }else{
            imgStep.setImageResource(R.mipmap.ic_clean_tagg2);
        }

    }


    @Override
    protected void onRelease() {
        list = null;
    }
}
