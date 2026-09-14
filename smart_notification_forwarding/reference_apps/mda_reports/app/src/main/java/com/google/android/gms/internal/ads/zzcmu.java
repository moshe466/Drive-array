package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
final class zzcmu implements zzbth {
    final /* synthetic */ zzcms a;
    private final /* synthetic */ zzczt zzgav;
    private final /* synthetic */ zzczl zzgaw;
    private final /* synthetic */ zzcip zzgax;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcmu(zzcms zzcmsVar, zzczt zzcztVar, zzczl zzczlVar, zzcip zzcipVar) {
        this.a = zzcmsVar;
        this.zzgav = zzcztVar;
        this.zzgaw = zzczlVar;
        this.zzgax = zzcipVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbth
    public final void onInitializationSucceeded() {
        Executor executor;
        executor = this.a.zzfci;
        final zzczt zzcztVar = this.zzgav;
        final zzczl zzczlVar = this.zzgaw;
        final zzcip zzcipVar = this.zzgax;
        executor.execute(new Runnable(this, zzcztVar, zzczlVar, zzcipVar) { // from class: com.google.android.gms.internal.ads.zzcmt
            private final zzczl zzfel;
            private final zzczt zzfot;
            private final zzcmu zzgat;
            private final zzcip zzgau;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgat = this;
                this.zzfot = zzcztVar;
                this.zzfel = zzczlVar;
                this.zzgau = zzcipVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzcmu zzcmuVar = this.zzgat;
                zzczt zzcztVar2 = this.zzfot;
                zzczl zzczlVar2 = this.zzfel;
                zzcip zzcipVar2 = this.zzgau;
                zzcms zzcmsVar = zzcmuVar.a;
                zzcms.zzc(zzcztVar2, zzczlVar2, zzcipVar2);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbth
    public final void zzdh(int i) {
        String valueOf = String.valueOf(this.zzgax.zzfge);
        zzayu.zzez(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "));
    }
}
