package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class zzoz {
    private static zzoz zza = new zzoz();
    private final AtomicReference<zzpv> zzb = new AtomicReference<>(zzpv.zza().zza());

    public static zzoz zza() {
        return zza;
    }

    public final <KeyT extends zzbm, PrimitiveT> PrimitiveT zza(KeyT keyt, Class<PrimitiveT> cls) {
        return (PrimitiveT) this.zzb.get().zza(keyt, cls);
    }

    public final synchronized <KeyT extends zzbm, PrimitiveT> void zza(zzpr<KeyT, PrimitiveT> zzprVar) {
        this.zzb.set(zzpv.zza(this.zzb.get()).zza(zzprVar).zza());
    }

    public final synchronized <InputPrimitiveT, WrapperPrimitiveT> void zza(zzqc<InputPrimitiveT, WrapperPrimitiveT> zzqcVar) {
        this.zzb.set(zzpv.zza(this.zzb.get()).zza(zzqcVar).zza());
    }
}
