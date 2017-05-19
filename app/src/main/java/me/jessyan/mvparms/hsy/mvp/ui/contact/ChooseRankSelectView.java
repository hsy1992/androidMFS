package me.jessyan.mvparms.hsy.mvp.ui.contact;

import android.content.Context;
import android.util.AttributeSet;

import com.jess.arms.widget.SelectView;

import me.jessyan.mvparms.hsy.R;


/**
 * Created by haosiyuan on 2017/5/12.
 * 选择净化词
 */

public class ChooseRankSelectView extends SelectView {

    public ChooseRankSelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected boolean getOnClick() {
        return true;
    }

    @Override
    protected int getCheckYes() {
        return R.mipmap.ic_mz_selet;
    }

    @Override
    protected int getCheckNo() {
        return R.mipmap.ic_mz_unselet;
    }
}
