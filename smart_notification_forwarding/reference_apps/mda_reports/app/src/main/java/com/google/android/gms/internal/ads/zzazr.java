package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
public final class zzazr<T> implements zzdgt<T> {
    private final /* synthetic */ zzazo zzdwt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazr(zzazo zzazoVar) {
        this.zzdwt = zzazoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void onSuccess(@Nullable T t) {
        AtomicInteger atomicInteger;
        atomicInteger = this.zzdwt.zzdwq;
        atomicInteger.set(1);
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        AtomicInteger atomicInteger;
        atomicInteger = this.zzdwt.zzdwq;
        atomicInteger.set(-1);
    }
}
