package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcjx extends zzary implements zzbpu {

    @GuardedBy("this")
    private zzarz zzfze;

    @GuardedBy("this")
    private zzbpx zzfzf;

    @GuardedBy("this")
    private zzbth zzfzg;

    @Override // com.google.android.gms.internal.ads.zzarz
    public final synchronized void zza(IObjectWrapper iObjectWrapper, zzasd zzasdVar) {
        if (this.zzfze != null) {
            this.zzfze.zza(iObjectWrapper, zzasdVar);
        }
    }

    public final synchronized void zza(zzarz zzarzVar) {
        this.zzfze = zzarzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpu
    public final synchronized void zza(zzbpx zzbpxVar) {
        this.zzfzf = zzbpxVar;
    }

    public final synchronized void zza(zzbth zzbthVar) {
        this.zzfzg = zzbthVar;
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final synchronized void zzaf(IObjectWrapper iObjectWrapper) {
        if (this.zzfze != null) {
            this.zzfze.zzaf(iObjectWrapper);
        }
        if (this.zzfzg != null) {
            this.zzfzg.onInitializationSucceeded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final synchronized void zzag(IObjectWrapper iObjectWrapper) {
        if (this.zzfze != null) {
            this.zzfze.zzag(iObjectWrapper);
        }
        if (this.zzfzf != null) {
            this.zzfzf.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final synchronized void zzah(IObjectWrapper iObjectWrapper) {
        if (this.zzfze != null) {
            this.zzfze.zzah(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final synchronized void zzai(IObjectWrapper iObjectWrapper) {
        if (this.zzfze != null) {
            this.zzfze.zzai(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final synchronized void zzaj(IObjectWrapper iObjectWrapper) {
        if (this.zzfze != null) {
            this.zzfze.zzaj(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final synchronized void zzak(IObjectWrapper iObjectWrapper) {
        if (this.zzfze != null) {
            this.zzfze.zzak(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final synchronized void zzal(IObjectWrapper iObjectWrapper) {
        if (this.zzfze != null) {
            this.zzfze.zzal(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final synchronized void zzam(IObjectWrapper iObjectWrapper) {
        if (this.zzfze != null) {
            this.zzfze.zzam(iObjectWrapper);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final synchronized void zzb(Bundle bundle) {
        if (this.zzfze != null) {
            this.zzfze.zzb(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final synchronized void zzd(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzfze != null) {
            this.zzfze.zzd(iObjectWrapper, i);
        }
        if (this.zzfzg != null) {
            this.zzfzg.zzdh(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final synchronized void zze(IObjectWrapper iObjectWrapper, int i) {
        if (this.zzfze != null) {
            this.zzfze.zze(iObjectWrapper, i);
        }
        if (this.zzfzf != null) {
            this.zzfzf.onAdFailedToLoad(i);
        }
    }
}
