package com.luooh.inputmethod.utils;

import android.content.Context;
import android.provider.Settings;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Luooh on 2017/1/16.
 */
public class InputMethodUtils {

    /*
     * We may not be able to get our own {@link InputMethodInfo} just after this IME is installed
     * because {@link InputMethodManagerService} may not be aware of this IME yet.
     * Note: {@link RichInputMethodManager} has similar methods. Here in setup wizard, we can't
     * use it for the reason above.
     *
     * Check if the IME specified by the context is enabled.
     * CAVEAT: This may cause a round trip IPC.
     *
     * @param context package context of the IME to be checked.
     * @param imm the {@link InputMethodManager}.
     * @return true if this IME is enabled.
     */
    public static boolean isThisImeEnabled(final Context context,
                                                  final InputMethodManager imm) {
        final String packageName = context.getPackageName();
        for (final InputMethodInfo imi : imm.getEnabledInputMethodList()) {
            if (packageName.equals(imi.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check if the IME specified by the context is the current IME.
     * CAVEAT: This may cause a round trip IPC.
     *
     * @param context package context of the IME to be checked.
     * @param imm the {@link InputMethodManager}.
     * @return true if this IME is the current IME.
     */
    public static boolean isThisImeCurrent(final Context context,
                                           final InputMethodManager imm) {
        final InputMethodInfo imi = getInputMethodInfoOf(context.getPackageName(), imm);
        final String currentImeId = Settings.Secure.getString(
                context.getContentResolver(), Settings.Secure.DEFAULT_INPUT_METHOD);
        return imi != null && imi.getId().equals(currentImeId);
    }

    /**
     * Get {@link InputMethodInfo} of the IME specified by the package name.
     * CAVEAT: This may cause a round trip IPC.
     *
     * @param packageName package name of the IME.
     * @param imm the {@link InputMethodManager}.
     * @return the {@link InputMethodInfo} of the IME specified by the <code>packageName</code>,
     * or null if not found.
     */
     public static InputMethodInfo getInputMethodInfoOf(final String packageName,
                                                              final InputMethodManager imm) {
        for (final InputMethodInfo imi : imm.getInputMethodList()) {
            if (packageName.equals(imi.getPackageName())) {
                return imi;
            }
        }
        return null;
    }
}
