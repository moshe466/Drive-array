package com.google.android.gms.internal.ads;

import android.util.Log;

/* loaded from: classes.dex */
public final class zzdwr extends zzdwy {
    private String name;

    public zzdwr(String str) {
        this.name = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdwy
    public final void zzhp(String str) {
        String str2 = this.name;
        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 1 + String.valueOf(str).length());
        sb.append(str2);
        sb.append(":");
        sb.append(str);
        Log.d("isoparser", sb.toString());
    }
}
