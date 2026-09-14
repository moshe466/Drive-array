package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbig implements zzdxg<zzauz> {
    private static final zzbig zzfbe = new zzbig();

    public static zzbig zzafg() {
        return zzfbe;
    }

    public static zzauz zzafh() {
        return (zzauz) zzdxm.zza(new zzauz(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzafh();
    }
}
