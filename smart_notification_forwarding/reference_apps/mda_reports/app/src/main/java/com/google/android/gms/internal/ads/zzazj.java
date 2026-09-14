package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzazj implements zzdgt<Object> {
    private final /* synthetic */ String zzdwm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazj(String str) {
        this.zzdwm = str;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void onSuccess(@Nullable Object obj) {
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        com.google.android.gms.ads.internal.zzq.zzku().zzb(th, this.zzdwm);
    }
}
