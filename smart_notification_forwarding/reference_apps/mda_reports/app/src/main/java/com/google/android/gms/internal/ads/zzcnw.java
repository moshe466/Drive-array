package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

/* loaded from: classes.dex */
public final class zzcnw implements zzcnq<zzbtu> {
    private final zzbup zzfyt;
    private final Context zzup;

    public zzcnw(Context context, zzbup zzbupVar) {
        this.zzup = context;
        this.zzfyt = zzbupVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcnq
    public final /* synthetic */ zzbtu zza(zzczt zzcztVar, zzczl zzczlVar, View view, zzcnt zzcntVar) {
        zzbtw zza = this.zzfyt.zza(new zzbmt(zzcztVar, zzczlVar, null), new zzcny(this, zzcnv.a));
        zzcntVar.zza(new zzcnx(this, zza));
        return zza.zzaem();
    }
}
