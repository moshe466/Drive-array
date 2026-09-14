package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class zzcat implements Callable<zzcaj> {
    private final zzbdr zzbmj;
    private final zzazb zzdij;
    private final zzdq zzefv;
    private final Executor zzfci;
    private final com.google.android.gms.ads.internal.zza zzfpj;
    private final Context zzup;

    public zzcat(Context context, Executor executor, zzdq zzdqVar, zzazb zzazbVar, com.google.android.gms.ads.internal.zza zzaVar, zzbdr zzbdrVar) {
        this.zzup = context;
        this.zzfci = executor;
        this.zzefv = zzdqVar;
        this.zzdij = zzazbVar;
        this.zzfpj = zzaVar;
        this.zzbmj = zzbdrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Context a(zzcat zzcatVar) {
        return zzcatVar.zzup;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Executor b(zzcat zzcatVar) {
        return zzcatVar.zzfci;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzdq c(zzcat zzcatVar) {
        return zzcatVar.zzefv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzazb d(zzcat zzcatVar) {
        return zzcatVar.zzdij;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ com.google.android.gms.ads.internal.zza e(zzcat zzcatVar) {
        return zzcatVar.zzfpj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ zzbdr f(zzcat zzcatVar) {
        return zzcatVar.zzbmj;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzcaj call() {
        zzcaj zzcajVar = new zzcaj(this);
        zzcajVar.zzakq();
        return zzcajVar;
    }
}
