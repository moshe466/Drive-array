package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzgz {
    private static final zzgz zza = new zzgz();
    private final ConcurrentMap<Class<?>, zzhd<?>> zzc = new ConcurrentHashMap();
    private final zzhg zzb = new zzgb();

    private zzgz() {
    }

    public static zzgz zza() {
        return zza;
    }

    public final <T> zzhd<T> zza(Class<T> cls) {
        zzff.a(cls, "messageType");
        zzhd<T> zzhdVar = (zzhd) this.zzc.get(cls);
        if (zzhdVar != null) {
            return zzhdVar;
        }
        zzhd<T> zza2 = this.zzb.zza(cls);
        zzff.a(cls, "messageType");
        zzff.a(zza2, "schema");
        zzhd<T> zzhdVar2 = (zzhd) this.zzc.putIfAbsent(cls, zza2);
        return zzhdVar2 != null ? zzhdVar2 : zza2;
    }

    public final <T> zzhd<T> zza(T t) {
        return zza((Class) t.getClass());
    }
}
