package com.jess.arms.widget.ui.navigation;

import android.support.v4.app.Fragment;

/**
 * Created by haosiyuan on 2017/5/5.
 */

public class TabModel {
    private Fragment fragment;
    private int picNormal;
    private int picCheck;
    private String text;

    public TabModel(Fragment fragment, int picNormal, int picCheck, String text) {
        this.fragment = fragment;
        this.picNormal = picNormal;
        this.picCheck = picCheck;
        this.text = text;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public int getPicNormal() {
        return picNormal;
    }

    public int getPicCheck() {
        return picCheck;
    }

    public String getText() {
        return text;
    }
}
