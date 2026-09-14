package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class zzbmj {
    public final List<? extends zzdhe<? extends zzbmd>> zzffu;

    public zzbmj(zzbmd zzbmdVar) {
        this.zzffu = Collections.singletonList(zzdgs.zzaj(zzbmdVar));
    }

    public zzbmj(List<? extends zzdhe<? extends zzbmd>> list) {
        this.zzffu = list;
    }

    public static zzcio<zzbmj> zza(@NonNull zzcio<? extends zzbmd> zzcioVar) {
        return new zzcin(zzcioVar, zzbml.a);
    }

    public static zzcio<zzbmj> zza(@NonNull zzckr<? extends zzbmd> zzckrVar) {
        return new zzcin(zzckrVar, zzbmm.a);
    }
}
