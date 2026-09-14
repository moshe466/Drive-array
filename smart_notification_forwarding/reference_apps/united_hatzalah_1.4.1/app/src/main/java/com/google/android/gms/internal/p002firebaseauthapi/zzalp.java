package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.List;

/* loaded from: classes.dex */
final class zzalp implements zzalm {
    private static <E> zzalc<E> zzc(Object obj, long j2) {
        return (zzalc) zzanp.zze(obj, j2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalm
    public final <L> List<L> zza(Object obj, long j2) {
        zzalc zzc = zzc(obj, j2);
        if (zzc.zzc()) {
            return zzc;
        }
        int size = zzc.size();
        zzalc zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzanp.zza(obj, j2, zza);
        return zza;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalm
    public final void zzb(Object obj, long j2) {
        zzc(obj, j2).zzb();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzalm
    public final <E> void zza(Object obj, Object obj2, long j2) {
        zzalc zzc = zzc(obj, j2);
        zzalc zzc2 = zzc(obj2, j2);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzc()) {
                zzc = zzc.zza(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzanp.zza(obj, j2, zzc2);
    }
}
