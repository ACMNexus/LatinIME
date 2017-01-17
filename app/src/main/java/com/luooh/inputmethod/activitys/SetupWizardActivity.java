/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.luooh.inputmethod.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import com.luooh.inputmethod.R;
import com.luooh.inputmethod.utils.InputMethodUtils;
import com.luooh.inputmethod.utils.ToastUtils;

public final class SetupWizardActivity extends BaseActivity {

    private Button mSetupStep1;
    private Button mSetupSetp2;
    private boolean mNeedsToAdjustStepNumberToSystemState;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_wizard);

        initView();
        setListener();
    }

    @Override
    protected void initView() {
        mSetupStep1 = (Button) findViewById(R.id.setup_step1);
        mSetupSetp2 = (Button) findViewById(R.id.setup_step2);
    }

    @Override
    protected void setListener() {
        mSetupStep1.setOnClickListener(this);
        mSetupSetp2.setOnClickListener(this);
    }

    @Override
    public void onClick(final View v) {
        switch (v.getId()) {
            case R.id.setup_step1:
                invokeLanguageAndInputSettings();
                break;
            case R.id.setup_step2:
                if(!InputMethodUtils.isThisImeEnabled(this, mImm)) {
                    ToastUtils.show(this, R.string.active_inputmethod_tips);
                    return;
                }
                mNeedsToAdjustStepNumberToSystemState = true;
                mImm.showInputMethodPicker();
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == event.KEYCODE_BACK) {
            Intent intent = new Intent(this, MarketActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    public void invokeLanguageAndInputSettings() {
        final Intent intent = new Intent();
        intent.setAction(Settings.ACTION_INPUT_METHOD_SETTINGS);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        startActivity(intent);
        mNeedsToAdjustStepNumberToSystemState = true;
    }

    @Override
    public void onWindowFocusChanged(final boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus && mNeedsToAdjustStepNumberToSystemState && InputMethodUtils.isThisImeCurrent(this, mImm)) {
            Intent intent = new Intent(this, MarketActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
