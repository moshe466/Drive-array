package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzboj implements zzdxg<Bundle> {
    private final zzbod zzfhi;

    private zzboj(zzbod zzbodVar) {
        this.zzfhi = zzbodVar;
    }

    public static zzboj zzh(zzbod zzbodVar) {
        return new zzboj(zzbodVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    @Nullable
    public final /* synthetic */ Object get() {
        return this.zzfhi.d();
    }
}
