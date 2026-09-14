package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class zzbmd {
    protected final zzczt a;
    protected final zzczl b;
    private final zzbpg zzffp;
    private final zzbpw zzffq;

    @Nullable
    private final zzcxq zzffr;
    private final zzbom zzffs;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbmd(zzbmg zzbmgVar) {
        this.a = zzbmg.a(zzbmgVar);
        this.b = zzbmg.b(zzbmgVar);
        this.zzffp = zzbmg.c(zzbmgVar);
        this.zzffq = zzbmg.d(zzbmgVar);
        this.zzffr = zzbmg.e(zzbmgVar);
        this.zzffs = zzbmg.f(zzbmgVar);
    }

    public void destroy() {
        this.zzffp.zzbx(null);
    }

    public void zzagf() {
        this.zzffq.onAdLoaded();
    }

    public final zzbpg zzagr() {
        return this.zzffp;
    }

    public final zzbom zzags() {
        return this.zzffs;
    }

    @Nullable
    public final zzcxq zzagt() {
        return this.zzffr;
    }
}
