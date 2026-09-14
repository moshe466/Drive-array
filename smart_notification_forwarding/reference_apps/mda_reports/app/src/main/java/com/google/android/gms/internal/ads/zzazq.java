package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* loaded from: classes.dex */
public final class zzazq<T> implements zzdgt<T> {
    private final /* synthetic */ zzazp zzdwr;
    private final /* synthetic */ zzazn zzdws;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzazq(zzazo zzazoVar, zzazp zzazpVar, zzazn zzaznVar) {
        this.zzdwr = zzazpVar;
        this.zzdws = zzaznVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void onSuccess(@Nullable T t) {
        this.zzdwr.zzh(t);
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        this.zzdws.run();
    }
}
