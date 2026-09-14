package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzamr {
    private static final zzamr zza = new zzamr();
    private final ConcurrentMap<Class<?>, zzamv<?>> zzc = new ConcurrentHashMap();
    private final zzamu zzb = new zzalq();

    private zzamr() {
    }

    public static zzamr zza() {
        return zza;
    }

    public final <T> zzamv<T> zza(Class<T> cls) {
        zzalb.zza(cls, "messageType");
        zzamv<T> zzamvVar = (zzamv) this.zzc.get(cls);
        if (zzamvVar == null) {
            zzamvVar = this.zzb.zza(cls);
            zzalb.zza(cls, "messageType");
            zzalb.zza(zzamvVar, "schema");
            zzamv<T> zzamvVar2 = (zzamv) this.zzc.putIfAbsent(cls, zzamvVar);
            if (zzamvVar2 != null) {
                return zzamvVar2;
            }
        }
        return zzamvVar;
    }

    public final <T> zzamv<T> zza(T t3) {
        return zza((Class) t3.getClass());
    }
}
