package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzcdu implements zzdcx {
    private final Clock zzbmq;
    private final zzcds zzfsu;
    private final Map<zzdco, Long> zzfst = new HashMap();
    private final Map<zzdco, zzcdt> zzfsv = new HashMap();

    public zzcdu(zzcds zzcdsVar, Set<zzcdt> set, Clock clock) {
        zzdco zzdcoVar;
        this.zzfsu = zzcdsVar;
        for (zzcdt zzcdtVar : set) {
            Map<zzdco, zzcdt> map = this.zzfsv;
            zzdcoVar = zzcdtVar.zzfss;
            map.put(zzdcoVar, zzcdtVar);
        }
        this.zzbmq = clock;
    }

    private final void zza(zzdco zzdcoVar, boolean z) {
        zzdco zzdcoVar2;
        String str;
        zzdcoVar2 = this.zzfsv.get(zzdcoVar).zzfsr;
        String str2 = z ? "s." : "f.";
        if (this.zzfst.containsKey(zzdcoVar2)) {
            long elapsedRealtime = this.zzbmq.elapsedRealtime() - this.zzfst.get(zzdcoVar2).longValue();
            Map<String, String> zzqu = this.zzfsu.zzqu();
            str = this.zzfsv.get(zzdcoVar).label;
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "label.".concat(valueOf) : new String("label.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzqu.put(concat, valueOf2.length() != 0 ? str2.concat(valueOf2) : new String(str2));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zza(zzdco zzdcoVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zza(zzdco zzdcoVar, String str, Throwable th) {
        if (this.zzfst.containsKey(zzdcoVar)) {
            long elapsedRealtime = this.zzbmq.elapsedRealtime() - this.zzfst.get(zzdcoVar).longValue();
            Map<String, String> zzqu = this.zzfsu.zzqu();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzqu.put(concat, valueOf2.length() != 0 ? "f.".concat(valueOf2) : new String("f."));
        }
        if (this.zzfsv.containsKey(zzdcoVar)) {
            zza(zzdcoVar, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zzb(zzdco zzdcoVar, String str) {
        this.zzfst.put(zzdcoVar, Long.valueOf(this.zzbmq.elapsedRealtime()));
    }

    @Override // com.google.android.gms.internal.ads.zzdcx
    public final void zzc(zzdco zzdcoVar, String str) {
        if (this.zzfst.containsKey(zzdcoVar)) {
            long elapsedRealtime = this.zzbmq.elapsedRealtime() - this.zzfst.get(zzdcoVar).longValue();
            Map<String, String> zzqu = this.zzfsu.zzqu();
            String valueOf = String.valueOf(str);
            String concat = valueOf.length() != 0 ? "task.".concat(valueOf) : new String("task.");
            String valueOf2 = String.valueOf(Long.toString(elapsedRealtime));
            zzqu.put(concat, valueOf2.length() != 0 ? "s.".concat(valueOf2) : new String("s."));
        }
        if (this.zzfsv.containsKey(zzdcoVar)) {
            zza(zzdcoVar, true);
        }
    }
}
