package com.groboot.mdaemergency.enums;

import il.org.mda.health.R;

/* loaded from: classes.dex */
public enum e {
    Hebrew(0, "iw", R.string.hebrew, R.drawable.languge_iw_25),
    English(1, "en", R.string.english, R.drawable.languge_en_25);

    String code;
    int id;
    private int imageResId;
    int nameResId;

    e(int i10, String str, int i11, int i12) {
        this.id = i10;
        this.code = str;
        this.nameResId = i11;
        this.imageResId = i12;
    }

    public static e getByCode(String str) {
        for (e eVar : values()) {
            if (eVar.code.equals(str)) {
                return eVar;
            }
        }
        return null;
    }

    public static e toLanguageType(String str) {
        try {
            return valueOf(str);
        } catch (Exception unused) {
            return Hebrew;
        }
    }

    public String getCode() {
        return this.code;
    }

    public int getId() {
        return this.id;
    }

    public int getImageResId() {
        return this.imageResId;
    }

    public int getNameResId() {
        return this.nameResId;
    }
}
