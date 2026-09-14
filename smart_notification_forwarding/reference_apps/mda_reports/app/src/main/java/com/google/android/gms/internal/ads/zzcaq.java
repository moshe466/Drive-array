package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzcaq implements zzdgt<zzbdi> {
    private final /* synthetic */ String zzfql;
    private final /* synthetic */ zzafn zzfqm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcaq(zzcaj zzcajVar, String str, zzafn zzafnVar) {
        this.zzfql = str;
        this.zzfqm = zzafnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(zzbdi zzbdiVar) {
        zzbdiVar.zzb(this.zzfql, this.zzfqm);
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
    }
}
