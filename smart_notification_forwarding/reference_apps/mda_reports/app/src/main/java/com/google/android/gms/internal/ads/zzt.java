package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzag;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzt implements Runnable {
    private final /* synthetic */ String zzas;
    private final /* synthetic */ long zzat;
    private final /* synthetic */ zzq zzau;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzt(zzq zzqVar, String str, long j) {
        this.zzau = zzqVar;
        this.zzas = str;
        this.zzat = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzag.zza zzaVar;
        zzag.zza zzaVar2;
        zzaVar = this.zzau.zzae;
        zzaVar.zza(this.zzas, this.zzat);
        zzaVar2 = this.zzau.zzae;
        zzaVar2.zzc(this.zzau.toString());
    }
}
