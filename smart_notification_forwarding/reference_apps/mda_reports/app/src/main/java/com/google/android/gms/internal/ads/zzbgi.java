package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbgi implements zzdxg<String> {
    private final zzbga zzejr;

    public zzbgi(zzbga zzbgaVar) {
        this.zzejr = zzbgaVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (String) zzdxm.zza(this.zzejr.d(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
