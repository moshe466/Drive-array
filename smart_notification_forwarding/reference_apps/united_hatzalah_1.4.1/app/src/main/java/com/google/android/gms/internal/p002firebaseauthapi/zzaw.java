package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.AbstractMap;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzaw extends zzaj {
    private final /* synthetic */ zzat zza;

    public zzaw(zzat zzatVar) {
        this.zza = zzatVar;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        int i3;
        Object[] objArr;
        Object[] objArr2;
        i3 = this.zza.zzc;
        zzw.zza(i, i3);
        objArr = this.zza.zzb;
        int i4 = i * 2;
        Object obj = objArr[i4];
        Objects.requireNonNull(obj);
        objArr2 = this.zza.zzb;
        Object obj2 = objArr2[i4 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        int i;
        i = this.zza.zzc;
        return i;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final boolean zze() {
        return true;
    }
}
