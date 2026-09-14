package com.google.android.gms.internal.p002firebaseauthapi;

/* loaded from: classes.dex */
final class zzaa extends zzac {
    private final /* synthetic */ zzf zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaa(zzv zzvVar, CharSequence charSequence, zzf zzfVar) {
        super(zzvVar, charSequence);
        this.zzb = zzfVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzac
    public final int zza(int i) {
        return i + 1;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzac
    public final int zzb(int i) {
        return this.zzb.zza(((zzac) this).zza, i);
    }
}
