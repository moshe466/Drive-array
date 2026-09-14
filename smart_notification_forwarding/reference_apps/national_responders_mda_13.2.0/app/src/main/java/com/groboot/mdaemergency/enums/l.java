package com.groboot.mdaemergency.enums;

import il.org.mda.health.R;

/* loaded from: classes.dex */
public enum l {
    No_Sound("-1", R.string.no_sound, 0),
    Siren_1("1", R.string.siren_1, R.raw.m1),
    Siren_2("2", R.string.siren_2, R.raw.m2),
    Siren_3("3", R.string.siren_3, R.raw.m3),
    Bell("4", R.string.bell, R.raw.m4),
    Beeper("5", R.string.beeper, R.raw.m5),
    Message("6", R.string.message, R.raw.m6);

    String key;
    int soundId;
    int soundNameResId;

    l(String str, int i10, int i11) {
        this.key = str;
        this.soundNameResId = i10;
        this.soundId = i11;
    }

    public static l getByKey(String str) {
        for (l lVar : values()) {
            if (lVar.key.equals(str)) {
                return lVar;
            }
        }
        return null;
    }

    public String getKey() {
        return this.key;
    }

    public int getSoundId() {
        return this.soundId;
    }

    public int getsoundNameResId() {
        return this.soundNameResId;
    }
}
