package com.luooh.inputmethod;

import android.app.Application;

/**
 * Created by Luooh on 2017/1/17.
 */
public class LatinIMEApplication extends Application {

    private static LatinIMEApplication mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    public static LatinIMEApplication getInstance() {
        return mInstance;
    }
}
