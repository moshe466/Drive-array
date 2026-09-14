package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbs;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzen implements Runnable {
    private final /* synthetic */ zzei zzyc;
    private final /* synthetic */ int zzyf;
    private final /* synthetic */ boolean zzyg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzen(zzei zzeiVar, int i, boolean z) {
        this.zzyc = zzeiVar;
        this.zzyf = i;
        this.zzyg = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean zza;
        zzbs.zza b = this.zzyc.b(this.zzyf, this.zzyg);
        this.zzyc.zzxr = b;
        zza = zzei.zza(this.zzyf, b);
        if (zza) {
            this.zzyc.a(this.zzyf + 1, this.zzyg);
        }
    }
}
