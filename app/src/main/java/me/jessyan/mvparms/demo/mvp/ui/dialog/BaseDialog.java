package me.jessyan.mvparms.demo.mvp.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;

import com.jess.arms.utils.KnifeUtil;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.Unbinder;
import me.jessyan.mvparms.demo.R;

/**
 * Created by haosiyuan on 2017/5/15.
 * 基类弹窗
 */

public abstract class BaseDialog extends Dialog{

    private Window window;
    private Context context;
    private WindowManager windowManager;
    private Display display;
    private WindowManager.LayoutParams lp;
    private Unbinder unbinder;

    public BaseDialog(Context context) {
        super(context, R.style.myDialog);
    }

    public BaseDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
        //点击外部取消
        setCanceledOnTouchOutside(true);
        setCancelable(true);
        //初始化dialog
        initDialog();
    }

    //初始化弹窗
    private void initDialog() {
        window = this.getWindow();
        window.setGravity(getGravity());
        //动画
        window.setWindowAnimations(R.style.myAnimation);
        //设置宽
        windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
        lp = window.getAttributes();
        lp.width = display.getWidth(); // 设置宽度
        this.getWindow().setAttributes(lp);
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //返回键消失
        if(keyCode == KeyEvent.KEYCODE_BACK){
            dismiss();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        //屏幕适配
        AutoUtils.auto(getWindow().getDecorView());
        unbinder = KnifeUtil.bindTarget(this, getWindow().getDecorView());//绑定

    }

    @Override
    public void setOnDismissListener(OnDismissListener listener) {
        super.setOnDismissListener(listener);
        window = null;
        context = null;
        windowManager = null;
        display = null;
        lp = null;
        unbinder = null;
    }

    //位置
    public abstract int getGravity();
    //动画
    public abstract int getAnimations();
}
