package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class zzcmf implements zzcis<zzdac, zzcjx> {
    private final zzcka zzftq;

    @GuardedBy("this")
    private final Map<String, zzcip<zzdac, zzcjx>> zzgao = new HashMap();

    public zzcmf(zzcka zzckaVar) {
        this.zzftq = zzckaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcis
    public final zzcip<zzdac, zzcjx> zzd(String str, JSONObject jSONObject) {
        synchronized (this) {
            zzcip<zzdac, zzcjx> zzcipVar = this.zzgao.get(str);
            if (zzcipVar == null) {
                zzdac zze = this.zzftq.zze(str, jSONObject);
                if (zze == null) {
                    return null;
                }
                zzcipVar = new zzcip<>(zze, new zzcjx(), str);
                this.zzgao.put(str, zzcipVar);
            }
            return zzcipVar;
        }
    }
}
