package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzawc implements zzayp {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzdsv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawc(zzawb zzawbVar, Context context, String str) {
        this.val$context = context;
        this.zzdsv = str;
    }

    @Override // com.google.android.gms.internal.ads.zzayp
    public final void zzen(String str) {
        com.google.android.gms.ads.internal.zzq.zzkq();
        zzawb.zzb(this.val$context, this.zzdsv, str);
    }
}
