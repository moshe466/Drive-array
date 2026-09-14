package com.lt.plugin.lt_plugin.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.AudioAttributes;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import io.flutter.plugins.sharedpreferences.SharedPreferencesPluginKt;

/* loaded from: classes.dex */
public class VibrationHelper {
    private static VibrationHelper _instance;
    private final String TAG = "VibrationHelper";
    private Context context;
    private SharedPreferences webviewPrefs;

    /* loaded from: classes.dex */
    public enum VibrationMode {
        LONG,
        SHORT,
        OFF
    }

    private VibrationHelper(Context context) {
        this.context = context;
        this.webviewPrefs = context.getSharedPreferences(SharedPreferencesPluginKt.SHARED_PREFERENCES_NAME, 0);
    }

    public static VibrationHelper Instance(Context context) {
        if (_instance == null) {
            _instance = new VibrationHelper(context);
        }
        return _instance;
    }

    private void vibrateInternal(VibrationEffect vibrationEffect) {
        Vibrator vibrator = (Vibrator) this.context.getSystemService("vibrator");
        if (vibrator != null) {
            vibrator.cancel();
            if (vibrationEffect == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 29) {
                vibrator.vibrate(vibrationEffect, new AudioAttributes.Builder().setUsage(4).build());
            } else {
                vibrator.vibrate(vibrationEffect);
            }
        }
    }

    public VibrationEffect getEffect(String str, int i) {
        return getEffectForMode(getVibrationLevel(str), i);
    }

    public VibrationEffect getEffectForMode(VibrationMode vibrationMode, int i) {
        int i3;
        int[] iArr;
        long[] jArr;
        VibrationEffect createWaveform;
        if (i == 0) {
            i3 = -1;
        } else {
            i3 = i;
        }
        int ordinal = vibrationMode.ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                return null;
            }
            jArr = new long[]{1000, 200, 1000, 200};
            iArr = new int[]{i3, 0, i3, 0};
        } else {
            iArr = new int[]{i3, 0, i3, 0, i3, 0, i3, 0, i3, 0};
            jArr = new long[]{1000, 200, 1000, 200, 1000, 200, 1000, 200, 1000, 200};
        }
        createWaveform = VibrationEffect.createWaveform(jArr, iArr, -1);
        return createWaveform;
    }

    public VibrationMode getVibrationLevel(String str) {
        try {
            return VibrationMode.valueOf(this.webviewPrefs.getString("flutter.webview.vibrationMode", "OFF").toUpperCase());
        } catch (IllegalArgumentException unused) {
            return VibrationMode.OFF;
        }
    }

    public void setVibrationLevel(String str, String str2) {
        LogHelper.d("VibrationHelper", "setVibrationLevel: " + str);
        this.webviewPrefs.edit().putString("flutter.webview.vibrationMode", str).commit();
    }

    public void vibrateNow(String str, int i) {
        LogHelper.d("VibrationHelper", "vibrateNow: " + str);
        vibrateInternal(getEffectForMode(getVibrationLevel(str), i));
    }

    public void vibrateWithMode(String str, int i) {
        String upperCase;
        VibrationMode vibrationMode;
        if (str == null) {
            upperCase = "OFF";
        } else {
            try {
                upperCase = str.toUpperCase();
            } catch (IllegalArgumentException unused) {
                vibrationMode = VibrationMode.OFF;
            }
        }
        vibrationMode = VibrationMode.valueOf(upperCase);
        LogHelper.d("VibrationHelper", "vibrateWithMode: " + vibrationMode);
        vibrateInternal(getEffectForMode(vibrationMode, i));
    }
}
