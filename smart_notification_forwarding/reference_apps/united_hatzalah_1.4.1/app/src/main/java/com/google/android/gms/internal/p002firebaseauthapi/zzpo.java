package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzpo<P> {
    private static final zzaae zza = zzaae.zza(new byte[0]);
    private final Map<zzaae, List<P>> zzb;

    public final Iterable<P> zza(byte[] bArr) {
        List<P> list;
        List<P> list2 = this.zzb.get(zza);
        if (bArr.length >= 5) {
            list = this.zzb.get(zzaae.zza(bArr, 0, 5));
        } else {
            list = null;
        }
        if (list2 == null && list == null) {
            return new ArrayList();
        }
        if (list2 == null) {
            return list;
        }
        if (list == null) {
            return list2;
        }
        return new zzpn(this, list, list2);
    }

    private zzpo(Map<zzaae, List<P>> map) {
        this.zzb = map;
    }
}
