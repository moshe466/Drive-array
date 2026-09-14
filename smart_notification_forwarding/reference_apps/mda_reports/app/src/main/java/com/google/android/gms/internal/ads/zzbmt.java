package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbmt {
    private final zzczt zzelt;
    private final zzczl zzfbs;
    private final String zzfge;

    public zzbmt(zzczt zzcztVar, zzczl zzczlVar, @Nullable String str) {
        this.zzelt = zzcztVar;
        this.zzfbs = zzczlVar;
        this.zzfge = str == null ? "com.google.ads.mediation.admob.AdMobAdapter" : str;
    }

    public final zzczt zzagw() {
        return this.zzelt;
    }

    public final zzczl zzagx() {
        return this.zzfbs;
    }

    public final String zzagy() {
        return this.zzfge;
    }
}
