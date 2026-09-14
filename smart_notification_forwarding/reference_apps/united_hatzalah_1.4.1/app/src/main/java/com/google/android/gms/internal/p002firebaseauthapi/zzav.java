package com.google.android.gms.internal.p002firebaseauthapi;

/* loaded from: classes.dex */
final class zzav<K> extends zzas<K> {
    private final transient zzan<K, ?> zza;
    private final transient zzaj<K> zzb;

    public zzav(zzan<K, ?> zzanVar, zzaj<K> zzajVar) {
        this.zza = zzanVar;
        this.zzb = zzajVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (this.zza.get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzas, com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final zzaj<K> zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzas, com.google.android.gms.internal.p002firebaseauthapi.zzai, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* renamed from: zzd */
    public final zzba<K> iterator() {
        return (zzba) zzc().iterator();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzai
    public final boolean zze() {
        return true;
    }
}
