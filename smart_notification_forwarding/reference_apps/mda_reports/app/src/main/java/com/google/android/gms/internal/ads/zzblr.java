package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzblr implements zzdxg<Runnable> {
    private final zzbls zzffa;

    public zzblr(zzbls zzblsVar) {
        this.zzffa = zzblsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (Runnable) zzdxm.zza(this.zzffa.zzagn(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
