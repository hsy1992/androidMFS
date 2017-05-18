package me.jessyan.mvparms.demo.app.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by haosiyuan on 2017/5/16.
 * 软键盘控制器
 */

public final class UtilKeyBoard {

    private UtilKeyBoard() {
    }

    public static void openKeybord(EditText editText, Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager)context.getSystemService("input_method");
        inputMethodManager.showSoftInput(editText, 2);
        inputMethodManager.toggleSoftInput(2, 1);
    }

    public static void closeKeybord(EditText mEditText, Context mContext) {
        InputMethodManager inputMethodManager = (InputMethodManager)mContext.getSystemService("input_method");
        inputMethodManager.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }

}
