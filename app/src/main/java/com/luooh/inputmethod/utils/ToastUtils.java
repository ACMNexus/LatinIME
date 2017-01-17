package com.luooh.inputmethod.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Luooh on 2017/1/16.
 */
public class ToastUtils {

    public static void show(Context context, int resId) {
        Toast.makeText(context, resId, Toast.LENGTH_LONG).show();
    }
}
