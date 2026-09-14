package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzay extends zzaj<Object> {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzay(Object[] objArr, int i, int i3) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i3;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzw.zza(i, this.zzc);
        Object obj = this.zza[(i * 2) + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final boolean zze() {
        return true;
    }
}
