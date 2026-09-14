package com.groboot.mdaemergency.enums;

import android.content.Context;
import android.os.Build;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public enum k {
    withVibrate("0", R.string.with_vibrate, R.drawable.vibrate),
    withoutVibrate("1", R.string.without_vibrate, R.drawable.not_vibrate),
    onlyVibrate("2", R.string.only_vibrate, R.drawable.only_vibrate);

    int imageResId;
    String key;
    int resId;

    k(String str, int i10, int i11) {
        this.key = str;
        this.resId = i10;
        this.imageResId = i11;
    }

    public static k getByKey(String str) {
        for (k kVar : getValues()) {
            if (kVar.key.equals(str)) {
                return kVar;
            }
        }
        if (Build.VERSION.SDK_INT >= 26) {
            return withVibrate;
        }
        return null;
    }

    public static String getDescriptionByKey(Context context, String str) {
        for (k kVar : getValues()) {
            if (kVar.key.equals(str)) {
                return context.getString(kVar.resId);
            }
        }
        return null;
    }

    public static k[] getValues() {
        return Build.VERSION.SDK_INT >= 26 ? new k[]{withVibrate, onlyVibrate} : values();
    }

    public String getDescription(Context context) {
        return context.getString(this.resId);
    }

    public int getImageResId() {
        return this.imageResId;
    }

    public String getKey() {
        return this.key;
    }

    public int getResIdText() {
        return this.resId;
    }
}
