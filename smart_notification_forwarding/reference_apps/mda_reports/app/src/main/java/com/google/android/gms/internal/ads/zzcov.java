package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class zzcov {
    private final zzbwz zzgdm;
    private final zzcop zzgdn = new zzcop();
    private final zzbow zzgdo;

    public zzcov(zzbwz zzbwzVar) {
        this.zzgdm = zzbwzVar;
        final zzcop zzcopVar = this.zzgdn;
        final zzahh zzajt = this.zzgdm.zzajt();
        this.zzgdo = new zzbow(zzcopVar, zzajt) { // from class: com.google.android.gms.internal.ads.zzcoy
            private final zzcop zzgdq;
            private final zzahh zzgdr;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzgdq = zzcopVar;
                this.zzgdr = zzajt;
            }

            @Override // com.google.android.gms.internal.ads.zzbow
            public final void onAdFailedToLoad(int i) {
                zzcop zzcopVar2 = this.zzgdq;
                zzahh zzahhVar = this.zzgdr;
                zzcopVar2.onAdFailedToLoad(i);
                if (zzahhVar != null) {
                    try {
                        zzahhVar.onInstreamAdFailedToLoad(i);
                    } catch (RemoteException e) {
                        zzayu.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        };
    }

    public final zzbvi zzamr() {
        return new zzbvi(this.zzgdm, this.zzgdn.zzamo());
    }

    public final zzbov zzams() {
        return this.zzgdn;
    }

    public final zzbqb zzamt() {
        return this.zzgdn;
    }

    public final zzbow zzamu() {
        return this.zzgdo;
    }

    public final zzbpe zzamv() {
        return this.zzgdn;
    }

    public final zzty zzamw() {
        return this.zzgdn;
    }

    public final void zzc(zzvh zzvhVar) {
        this.zzgdn.zzc(zzvhVar);
    }
}
