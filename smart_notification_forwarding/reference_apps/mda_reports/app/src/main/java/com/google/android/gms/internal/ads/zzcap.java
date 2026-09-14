package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcap implements zzdgt<zzbdi> {
    private final /* synthetic */ String zzfqn;
    private final /* synthetic */ Map zzfqo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcap(zzcaj zzcajVar, String str, Map map) {
        this.zzfqn = str;
        this.zzfqo = map;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(zzbdi zzbdiVar) {
        zzbdiVar.zza(this.zzfqn, this.zzfqo);
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
    }
}
