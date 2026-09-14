package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.internal.zzbk;
import com.google.firebase.auth.zzc;
import java.util.List;

/* loaded from: classes.dex */
public final class zzaaj {
    private String zza;
    private List<zzahq> zzb;
    private zzc zzc;

    public zzaaj(String str, List<zzahq> list, zzc zzcVar) {
        this.zza = str;
        this.zzb = list;
        this.zzc = zzcVar;
    }

    public final zzc zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zza;
    }

    public final List<MultiFactorInfo> zzc() {
        return zzbk.zza(this.zzb);
    }
}
