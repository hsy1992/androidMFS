package me.jessyan.mvparms.demo.app.utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.zhy.autolayout.utils.AutoUtils;

/**
 * Created by haosiyuan on 2017/5/15.
 * 设置控件大小
 */

public class ViewSizeUtil {

    //适配控件大小
    public static void AdaptationSize(View view ,int width , int height){
        view.getLayoutParams().height = AutoUtils.getPercentHeightSize(height);
        view.getLayoutParams().width = AutoUtils.getPercentWidthSize(width);
    }

    //设置margin
    public static void AdaptationMargin(View view ,int left,int top,int right,int buttom){
        ((ViewGroup.MarginLayoutParams)view.getLayoutParams()).setMargins(
                AutoUtils.getPercentWidthSize(left),AutoUtils.getPercentHeightSize(top)
                ,AutoUtils.getPercentWidthSize(right),AutoUtils.getPercentHeightSize(buttom)
        );
    }

}
