package com.luooh.inputmethod.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.luooh.inputmethod.R;
import com.luooh.inputmethod.utils.InputMethodUtils;

public final class SplashActivity extends BaseActivity {

    private View mContentView;
    private int mDurationTime = 2500;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mContentView = LayoutInflater.from(this).inflate(R.layout.activity_splash, null);
        setContentView(mContentView);

        startAnimation();
    }

    private void startAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.3f, 1.0f);
        alphaAnimation.setDuration(mDurationTime);
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(SplashActivity.this, MarketActivity.class);
                if (!InputMethodUtils.isThisImeCurrent(mActivity, mImm)) {
                    intent.setClass(mActivity, SetupWizardActivity.class);
                }
                startActivity(intent);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        mContentView.startAnimation(alphaAnimation);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }
}
