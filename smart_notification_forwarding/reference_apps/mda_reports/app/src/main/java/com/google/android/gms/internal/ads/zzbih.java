package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbih implements zzdxg<zzava> {
    private static final zzbih zzfbf = new zzbih();

    public static zzbih zzafi() {
        return zzfbf;
    }

    public static zzava zzafj() {
        return (zzava) zzdxm.zza(new zzauy(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzafj();
    }
}
