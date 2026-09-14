package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzso;
import com.google.android.gms.internal.ads.zzsy;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzccw implements zzbow, zzbpe, zzbqb, zzbqx, zzbri, zzty {
    private final zzsm zzfry;

    @GuardedBy("this")
    private boolean zzfrz = false;

    @GuardedBy("this")
    private boolean zzfsa = false;

    public zzccw(zzsm zzsmVar, @Nullable zzcxw zzcxwVar) {
        this.zzfry = zzsmVar;
        zzsmVar.zza(zzso.zza.EnumC0023zza.AD_REQUEST);
        if (zzcxwVar != null) {
            zzsmVar.zza(zzso.zza.EnumC0023zza.REQUEST_IS_PREFETCH);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final synchronized void onAdClicked() {
        if (this.zzfsa) {
            this.zzfry.zza(zzso.zza.EnumC0023zza.AD_SUBSEQUENT_CLICK);
        } else {
            this.zzfry.zza(zzso.zza.EnumC0023zza.AD_FIRST_CLICK);
            this.zzfsa = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbow
    public final void onAdFailedToLoad(int i) {
        zzsm zzsmVar;
        zzso.zza.EnumC0023zza enumC0023zza;
        switch (i) {
            case 1:
                zzsmVar = this.zzfry;
                enumC0023zza = zzso.zza.EnumC0023zza.AD_FAILED_TO_LOAD_INVALID_REQUEST;
                break;
            case 2:
                zzsmVar = this.zzfry;
                enumC0023zza = zzso.zza.EnumC0023zza.AD_FAILED_TO_LOAD_NETWORK_ERROR;
                break;
            case 3:
                zzsmVar = this.zzfry;
                enumC0023zza = zzso.zza.EnumC0023zza.AD_FAILED_TO_LOAD_NO_FILL;
                break;
            case 4:
                zzsmVar = this.zzfry;
                enumC0023zza = zzso.zza.EnumC0023zza.AD_FAILED_TO_LOAD_TIMEOUT;
                break;
            case 5:
                zzsmVar = this.zzfry;
                enumC0023zza = zzso.zza.EnumC0023zza.AD_FAILED_TO_LOAD_CANCELLED;
                break;
            case 6:
                zzsmVar = this.zzfry;
                enumC0023zza = zzso.zza.EnumC0023zza.AD_FAILED_TO_LOAD_NO_ERROR;
                break;
            case 7:
                zzsmVar = this.zzfry;
                enumC0023zza = zzso.zza.EnumC0023zza.AD_FAILED_TO_LOAD_NOT_FOUND;
                break;
            default:
                zzsmVar = this.zzfry;
                enumC0023zza = zzso.zza.EnumC0023zza.AD_FAILED_TO_LOAD;
                break;
        }
        zzsmVar.zza(enumC0023zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void onAdImpression() {
        this.zzfry.zza(zzso.zza.EnumC0023zza.AD_IMPRESSION);
    }

    @Override // com.google.android.gms.internal.ads.zzbqb
    public final void onAdLoaded() {
        this.zzfry.zza(zzso.zza.EnumC0023zza.AD_LOADED);
    }

    @Override // com.google.android.gms.internal.ads.zzbri
    public final void zza(final zzsy.zza zzaVar) {
        this.zzfry.zza(new zzsp(zzaVar) { // from class: com.google.android.gms.internal.ads.zzccy
            private final zzsy.zza zzfhy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfhy = zzaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzsp
            public final void zza(zztu zztuVar) {
                zztuVar.zzcbb = this.zzfhy;
            }
        });
        this.zzfry.zza(zzso.zza.EnumC0023zza.REQUEST_LOADED_FROM_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(zzaqk zzaqkVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzbqx
    public final void zzb(final zzczt zzcztVar) {
        this.zzfry.zza(new zzsp(zzcztVar) { // from class: com.google.android.gms.internal.ads.zzccv
            private final zzczt zzfhw;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfhw = zzcztVar;
            }

            @Override // com.google.android.gms.internal.ads.zzsp
            public final void zza(zztu zztuVar) {
                zzczt zzcztVar2 = this.zzfhw;
                zztuVar.zzcay.zzbzw.zzbzo = zzcztVar2.zzgmi.zzgmf.zzbzo;
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzbri
    public final void zzb(final zzsy.zza zzaVar) {
        this.zzfry.zza(new zzsp(zzaVar) { // from class: com.google.android.gms.internal.ads.zzccx
            private final zzsy.zza zzfhy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfhy = zzaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzsp
            public final void zza(zztu zztuVar) {
                zztuVar.zzcbb = this.zzfhy;
            }
        });
        this.zzfry.zza(zzso.zza.EnumC0023zza.REQUEST_SAVED_TO_CACHE);
    }

    @Override // com.google.android.gms.internal.ads.zzbri
    public final void zzc(final zzsy.zza zzaVar) {
        this.zzfry.zza(new zzsp(zzaVar) { // from class: com.google.android.gms.internal.ads.zzcda
            private final zzsy.zza zzfhy;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.zzfhy = zzaVar;
            }

            @Override // com.google.android.gms.internal.ads.zzsp
            public final void zza(zztu zztuVar) {
                zztuVar.zzcbb = this.zzfhy;
            }
        });
        this.zzfry.zza(zzso.zza.EnumC0023zza.REQUEST_PREFETCH_INTERCEPTED);
    }
}
