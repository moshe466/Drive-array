package com.groboot.mdaemergency.enums;

import android.content.Context;
import il.org.mda.health.R;

/* loaded from: classes.dex */
public enum i {
    normal("0", R.string.regular_sound, R.drawable.speaker),
    continual("1", R.string.long_sound, R.drawable.speaker_long);

    private int imageResId;
    private String key;
    private int resId;

    i(String str, int i10, int i11) {
        this.key = str;
        this.resId = i10;
        this.imageResId = i11;
    }

    public static i getByKey(String str) {
        for (i iVar : values()) {
            if (iVar.key.equals(str)) {
                return iVar;
            }
        }
        return null;
    }

    public static String getDescriptionByKey(Context context, String str) {
        for (i iVar : values()) {
            if (iVar.key.equals(str)) {
                return context.getString(iVar.resId);
            }
        }
        return null;
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
