package com.meng.craftsmen.wheelviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.meng.craftsmen.wheelviewdemo.dialog.FeedBackTypeDialog;

public class MainActivity extends AppCompatActivity {

    private FeedBackTypeDialog mFeedBackTypeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_type).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFeedBackTypeDialog = new FeedBackTypeDialog(MainActivity.this);
                mFeedBackTypeDialog.setConfirmListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String selectFeedType = mFeedBackTypeDialog.getSelectFeedType();
                        Toast.makeText(getApplicationContext(), selectFeedType, Toast.LENGTH_SHORT).show();
                    }
                });
                mFeedBackTypeDialog.show();
            }
        });
    }
}
