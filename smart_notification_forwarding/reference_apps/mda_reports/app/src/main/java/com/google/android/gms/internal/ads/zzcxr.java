package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbob;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzcxr<RequestComponentT extends zzbob<AdT>, AdT> implements zzcxt<RequestComponentT, AdT> {

    @Nullable
    @GuardedBy("this")
    private RequestComponentT zzgjx;

    @Override // com.google.android.gms.internal.ads.zzcxt
    public final zzdhe<AdT> zza(zzcxs zzcxsVar, zzcxv<RequestComponentT> zzcxvVar) {
        this.zzgjx = zzcxvVar.zzc(zzcxsVar).zzadg();
        return this.zzgjx.zzadc().zzaha();
    }

    @Override // com.google.android.gms.internal.ads.zzcxt
    public final /* synthetic */ Object zzaog() {
        return this.zzgjx;
    }
}
