package me.jessyan.mvparms.demo.mvp.ui.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.app.utils.UtilKeyBoard;

/**
 * Created by haosiyuan on 2017/5/15.
 * 添加账号页面
 */

public abstract class WeiBoAddAccountDialog extends BaseDialog {

    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.tv_cancle)
    TextView tvCancle;
    @BindView(R.id.tv_ok)
    TextView tvOk;
    private Context mContext;

    public WeiBoAddAccountDialog(Context context) {
        super(context);
        this.mContext = context;
        setContentView(R.layout.dialog_addweiboaccount);
        //点击外部取消
        setCanceledOnTouchOutside(false);
        setCancelable(false);
    }

    @Override
    public int getGravity() {
        return Gravity.CENTER;
    }

    @Override
    public int getAnimations() {
        return R.style.myAnimation;
    }

    @OnClick({R.id.tv_cancle, R.id.tv_ok})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_cancle:
                //取消
                closeKeybord();
                this.dismiss();
                break;
            case R.id.tv_ok:
                //确定
                closeKeybord();
                this.dismiss();
                addAccount(etAccount.getText().toString(),etPassword.getText().toString());
                break;
        }
    }

    //关闭软键盘
    public void closeKeybord(){
        UtilKeyBoard.closeKeybord(etAccount,mContext);
        UtilKeyBoard.closeKeybord(etPassword,mContext);
    }

    //添加账号
    public abstract void addAccount(String account,String password);
}
