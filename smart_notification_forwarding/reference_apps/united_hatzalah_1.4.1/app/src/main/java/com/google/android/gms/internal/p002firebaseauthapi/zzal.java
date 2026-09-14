package com.google.android.gms.internal.p002firebaseauthapi;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzal<E> extends zzad<E> {
    private final zzaj<E> zza;

    public zzal(zzaj<E> zzajVar, int i) {
        super(zzajVar.size(), i);
        this.zza = zzajVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzad
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
