package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public abstract class zzdcd<E> {
    private static final zzdhe<?> zzgqa = zzdgs.zzaj(null);
    private final ScheduledExecutorService zzfdi;
    private final zzdhd zzfov;
    private final zzdcp<E> zzgqb;

    public zzdcd(zzdhd zzdhdVar, ScheduledExecutorService scheduledExecutorService, zzdcp<E> zzdcpVar) {
        this.zzfov = zzdhdVar;
        this.zzfdi = scheduledExecutorService;
        this.zzgqb = zzdcpVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract String a(E e);

    public final zzdcf zza(E e, zzdhe<?>... zzdheVarArr) {
        return new zzdcf(this, e, Arrays.asList(zzdheVarArr));
    }

    public final <I> zzdcj<I> zza(E e, zzdhe<I> zzdheVar) {
        return new zzdcj<>(this, e, zzdheVar, Collections.singletonList(zzdheVar), zzdheVar);
    }

    public final zzdch zzu(E e) {
        return new zzdch(this, e);
    }
}
