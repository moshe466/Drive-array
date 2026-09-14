package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzcwz implements zzbow, zzbqg, zzcxq {
    private final zzdax zzgjf;
    private final AtomicReference<zzrg> zzgjg = new AtomicReference<>();
    private final AtomicReference<zzrl> zzgjh = new AtomicReference<>();
    private final AtomicReference<zzbqg> zzgji = new AtomicReference<>();
    private zzcwz zzgjj = null;

    public zzcwz(zzdax zzdaxVar) {
        this.zzgjf = zzdaxVar;
    }

    public static zzcwz zza(zzcwz zzcwzVar) {
        zzcwz zzcwzVar2 = new zzcwz(zzcwzVar.zzgjf);
        zzcwzVar2.zzb(zzcwzVar);
        return zzcwzVar2;
    }

    public final void onAdClosed() {
        zzcwz zzcwzVar = this;
        while (true) {
            zzcwz zzcwzVar2 = zzcwzVar.zzgjj;
            if (zzcwzVar2 == null) {
                zzcwzVar.zzgjf.onAdClosed();
                zzcxp.zza(zzcwzVar.zzgjh, zzcxa.a);
                return;
            }
            zzcwzVar = zzcwzVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final void onAdFailedToLoad(final int i) {
        zzcwz zzcwzVar = this;
        while (true) {
            zzcwz zzcwzVar2 = zzcwzVar.zzgjj;
            if (zzcwzVar2 == null) {
                zzcxp.zza(zzcwzVar.zzgjg, new zzcxo(i) { // from class: com.google.android.gms.internal.ads.zzcxb
                    private final int zzdvv;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzdvv = i;
                    }

                    @Override // com.google.android.gms.internal.ads.zzcxo
                    public final void zzt(Object obj) {
                        ((zzrg) obj).onAppOpenAdFailedToLoad(this.zzdvv);
                    }
                });
                return;
            }
            zzcwzVar = zzcwzVar2;
        }
    }

    public final void zza(zzbqg zzbqgVar) {
        this.zzgji.set(zzbqgVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbqg
    public final void zzahi() {
        zzcwz zzcwzVar = this;
        while (true) {
            zzcwz zzcwzVar2 = zzcwzVar.zzgjj;
            if (zzcwzVar2 == null) {
                zzcxp.zza(zzcwzVar.zzgji, zzcxd.a);
                return;
            }
            zzcwzVar = zzcwzVar2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcxq
    public final void zzb(zzcxq zzcxqVar) {
        this.zzgjj = (zzcwz) zzcxqVar;
    }

    public final void zzb(final zzrf zzrfVar) {
        zzcwz zzcwzVar = this;
        while (true) {
            zzcwz zzcwzVar2 = zzcwzVar.zzgjj;
            if (zzcwzVar2 == null) {
                zzcxp.zza(zzcwzVar.zzgjg, new zzcxo(zzrfVar) { // from class: com.google.android.gms.internal.ads.zzcwy
                    private final zzrf zzgje;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        this.zzgje = zzrfVar;
                    }

                    @Override // com.google.android.gms.internal.ads.zzcxo
                    public final void zzt(Object obj) {
                        ((zzrg) obj).zza(this.zzgje);
                    }
                });
                return;
            }
            zzcwzVar = zzcwzVar2;
        }
    }

    public final void zzb(zzrg zzrgVar) {
        this.zzgjg.set(zzrgVar);
    }

    public final void zzb(zzrl zzrlVar) {
        this.zzgjh.set(zzrlVar);
    }
}
