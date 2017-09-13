package com.meng.craftsmen.wheelviewdemo.dialog;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.meng.craftsmen.wheelviewdemo.R;
import com.meng.craftsmen.wheelviewdemo.view.WheelView;

import java.util.Arrays;

import static android.content.ContentValues.TAG;


/**
 * Created by wangchengm
 * 反馈类型
 */

public class FeedBackTypeDialog extends AppCompatDialog {

    private static final String[] PLANETS = new String[]{"商品相关", "物流状况", "客户服务", "优惠活动", "产品体检"};

    private final Activity mActivity;
    TextView mTvCancel;
    TextView mTvConfirm;
    WheelView mWheelViewType;


    public FeedBackTypeDialog(Context context) {
        super(context);
        mActivity = (Activity) context;

        View contentView = LayoutInflater.from(context).inflate(R.layout.dialog_feed_type, null);
        setContentView(contentView);

        mWheelViewType = (WheelView) contentView.findViewById(R.id.wheel_view_type);
        mTvConfirm = (TextView) contentView.findViewById(R.id.tv_confirm);
        mTvCancel = (TextView) contentView.findViewById(R.id.tv_cancel);

        Window dialogWindow = getWindow();
        if (null != dialogWindow) {

            dialogWindow.setGravity(Gravity.BOTTOM);//显示在底部

            dialogWindow.getDecorView().setPadding(0, 0, 0, 0);
            dialogWindow.setBackgroundDrawableResource(R.color.transparent);

            WindowManager.LayoutParams lp = dialogWindow.getAttributes();
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

            //进出动画
            lp.windowAnimations = R.style.DialogAnimation;
            dialogWindow.setAttributes(lp);
        }

        mWheelViewType.setOffset(2);
        mWheelViewType.setItems(Arrays.asList(PLANETS));
        mWheelViewType.setSeletion(3);
        mWheelViewType.setOnWheelViewListener(new WheelView.OnWheelViewListener() {
            @Override
            public void onSelected(int selectedIndex, String item) {
                Log.d(TAG, "[Dialog]selectedIndex: " + selectedIndex + ", item: " + item);
            }
        });

        setCancelDialog(contentView);
        setCancelDialog(mTvCancel);
    }

    private void setCancelDialog(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    public String getSelectFeedType() {
        return mWheelViewType.getSeletedItem();
    }

    public void setConfirmListener(View.OnClickListener listener) {
        mTvConfirm.setOnClickListener(listener);
    }

    @Override
    public void show() {
        if (mActivity == null || mActivity.isFinishing()) {
            return;
        }
        super.show();
    }

    @Override
    public void dismiss() {
        if (mActivity == null || mActivity.isFinishing()) {
            return;
        }
        if (isShowing()) {
            super.dismiss();
        }
    }
}
