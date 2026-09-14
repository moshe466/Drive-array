package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzdbn {
    private HashMap<zzdbh, zzdbb> zzgph = new HashMap<>();

    public final zzdbb zzb(zzdbh zzdbhVar, Context context) {
        zzdbb zzdbbVar = this.zzgph.get(zzdbhVar);
        if (zzdbbVar != null) {
            return zzdbbVar;
        }
        zzdba zzdbaVar = new zzdba(zzdbe.zza(zzdbhVar, context));
        this.zzgph.put(zzdbhVar, zzdbaVar);
        return zzdbaVar;
    }
}
