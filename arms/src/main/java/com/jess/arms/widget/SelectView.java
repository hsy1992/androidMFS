package com.jess.arms.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

/**
 * Created by haosiyuan on 2017/5/12.
 * 选择
 */
public abstract class SelectView extends ImageView {

    private SelectView.OnCheckChangeListener onCheckChangeListener;
    private boolean isCheck;

    public SelectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setScaleType(ScaleType.FIT_XY);
        if(this.getOnClick()) {
            this.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    SelectView.this.setCheck(!SelectView.this.isCheck);
                }
            });
        }

        this.setCheck(this.isCheck, false);
    }

    public void setCheck(boolean isCheck) {
        this.setCheck(isCheck, true);
    }

    public void setCheck(boolean isCheck, boolean isClick) {
        this.isCheck = isCheck;
        this.setImageResource(isCheck ? this.getCheckYes() : this.getCheckNo());
        if(this.onCheckChangeListener != null && isClick) {
            this.onCheckChangeListener.onCheckChange(this, isCheck);
        }

    }

    public boolean isCheck() {
        return this.isCheck;
    }

    public void setOnCheckChangeListener(SelectView.OnCheckChangeListener onCheckChangeListener) {
        this.onCheckChangeListener = onCheckChangeListener;
    }

    protected abstract boolean getOnClick();

    protected abstract int getCheckYes();

    protected abstract int getCheckNo();

    public interface OnCheckChangeListener {
        void onCheckChange(View view, boolean isCheck);
    }
}
