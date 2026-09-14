package com.google.android.gms.ads.internal;

import android.content.Context;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzdq;
import com.google.android.gms.internal.ads.zzdr;
import java.util.concurrent.Callable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzm implements Callable<zzdq> {
    private final /* synthetic */ zzl zzblk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(zzl zzlVar) {
        this.zzblk = zzlVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzdq call() {
        zzazb zzazbVar;
        Context context;
        zzazbVar = this.zzblk.zzbll;
        String str = zzazbVar.zzbma;
        context = this.zzblk.zzup;
        return new zzdq(zzdr.zza(str, context, false));
    }
}
