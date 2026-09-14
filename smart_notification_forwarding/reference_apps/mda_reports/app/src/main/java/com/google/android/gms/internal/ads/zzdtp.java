package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzdtp {
    private static final zzdtp zzhpq = new zzdtp();
    private final ConcurrentMap<Class<?>, zzdua<?>> zzhps = new ConcurrentHashMap();
    private final zzdtz zzhpr = new zzdsr();

    private zzdtp() {
    }

    public static zzdtp zzbbm() {
        return zzhpq;
    }

    public final <T> zzdua<T> zzba(T t) {
        return zzh(t.getClass());
    }

    public final <T> zzdua<T> zzh(Class<T> cls) {
        zzdrv.a(cls, "messageType");
        zzdua<T> zzduaVar = (zzdua) this.zzhps.get(cls);
        if (zzduaVar != null) {
            return zzduaVar;
        }
        zzdua<T> zzg = this.zzhpr.zzg(cls);
        zzdrv.a(cls, "messageType");
        zzdrv.a(zzg, "schema");
        zzdua<T> zzduaVar2 = (zzdua) this.zzhps.putIfAbsent(cls, zzg);
        return zzduaVar2 != null ? zzduaVar2 : zzg;
    }
}
