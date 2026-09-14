package com.google.android.gms.internal.p002firebaseauthapi;

import java.lang.Enum;
import java.security.GeneralSecurityException;
import java.util.Map;

/* loaded from: classes.dex */
public final class zznk<E extends Enum<E>, O> {
    private final Map<E, O> zza;
    private final Map<O, E> zzb;

    public static <E extends Enum<E>, O> zznn<E, O> zza() {
        return new zznn<>();
    }

    private zznk(Map<E, O> map, Map<O, E> map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final E zza(O o2) {
        E e4 = this.zzb.get(o2);
        if (e4 != null) {
            return e4;
        }
        throw new GeneralSecurityException("Unable to convert object enum: ".concat(String.valueOf(o2)));
    }

    public final O zza(E e4) {
        O o2 = this.zza.get(e4);
        if (o2 != null) {
            return o2;
        }
        throw new GeneralSecurityException("Unable to convert proto enum: ".concat(String.valueOf(e4)));
    }
}
