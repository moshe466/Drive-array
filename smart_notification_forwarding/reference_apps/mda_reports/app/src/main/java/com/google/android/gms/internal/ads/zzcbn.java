package com.google.android.gms.internal.ads;

import android.content.Context;

/* loaded from: classes.dex */
public final class zzcbn {
    private final zzazb zzbll;
    private final zzbdr zzbmj;
    private final zzsm zzeeg;
    private final zzdq zzefv;
    private final com.google.android.gms.ads.internal.zza zzefx;
    private final zzro zzefz;
    private final zzczu zzfgl;
    private final zzbqp zzfre;
    private final Context zzup;

    public zzcbn(zzbdr zzbdrVar, Context context, zzczu zzczuVar, zzdq zzdqVar, zzazb zzazbVar, com.google.android.gms.ads.internal.zza zzaVar, zzsm zzsmVar, zzbqp zzbqpVar, zzbts zzbtsVar) {
        this.zzbmj = zzbdrVar;
        this.zzup = context;
        this.zzfgl = zzczuVar;
        this.zzefv = zzdqVar;
        this.zzbll = zzazbVar;
        this.zzefx = zzaVar;
        this.zzeeg = zzsmVar;
        this.zzfre = zzbqpVar;
        this.zzefz = zzbtsVar;
    }

    public final zzbdi zza(zzuj zzujVar, boolean z) {
        return zzbdr.zza(this.zzup, zzbey.zzb(zzujVar), zzujVar.zzabg, false, false, this.zzefv, this.zzbll, null, new zzcbq(this), this.zzefx, this.zzeeg, this.zzefz, z);
    }

    public final zzbdi zzc(zzuj zzujVar) {
        return zza(zzujVar, false);
    }
}
