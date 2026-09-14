package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
final class zzdk implements Runnable {
    private final /* synthetic */ Context zzwf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdk(zzdi zzdiVar, Context context) {
        this.zzwf = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzdc zzdcVar;
        zzdcVar = zzdi.zzvc;
        zzdcVar.zzb(this.zzwf);
    }
}
