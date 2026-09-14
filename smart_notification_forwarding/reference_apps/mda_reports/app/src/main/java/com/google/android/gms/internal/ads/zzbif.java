package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbif implements zzdxg<zzaks> {
    private static final zzbif zzfbd = new zzbif();

    public static zzbif zzafe() {
        return zzfbd;
    }

    public static zzaks zzaff() {
        return (zzaks) zzdxm.zza(new zzaks(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzaff();
    }
}
