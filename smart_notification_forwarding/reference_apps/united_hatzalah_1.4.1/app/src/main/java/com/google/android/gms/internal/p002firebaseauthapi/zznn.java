package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.Enum;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zznn<E extends Enum<E>, O> {
    private Map<E, O> zza;
    private Map<O, E> zzb;

    public final zznn<E, O> zza(E e4, O o2) {
        this.zza.put(e4, o2);
        this.zzb.put(o2, e4);
        return this;
    }

    private zznn() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zznk<E, O> zza() {
        return new zznk<>(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb));
    }
}
