package com.luooh.inputmethod.activitys;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import com.android.inputmethod.latin.R;
import com.luooh.inputmethod.view.PagerSlidingTabStrip;

public class MarketActivity extends BaseActivity {

    private ViewPager mViewPager;
    private PagerSlidingTabStrip mPageTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market);
    }

    @Override
    protected void initView() {
        mViewPager = (ViewPager) findViewById(R.id.vp_market);
        mPageTitles = (PagerSlidingTabStrip) findViewById(R.id.pst_titles);
    }
}
