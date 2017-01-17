package com.luooh.inputmethod.activitys;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;

/**
 * Created by Luooh on 2017/1/15.
 */

public class BaseActivity extends AppCompatActivity implements View.OnClickListener, AbsListView.OnItemClickListener{

    protected Activity mActivity;
    protected InputMethodManager mImm;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mActivity = this;
        mImm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
    }

    protected void init() {
    }

    protected void initView() {
    }

    protected void setListener() {
    }

    @Override
    public void onClick(View v) {
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    }
}
