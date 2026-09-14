package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbii implements zzdxg<zzaow> {
    private static final zzbii zzfbg = new zzbii();

    public static zzbii zzafk() {
        return zzfbg;
    }

    public static zzaow zzafl() {
        return (zzaow) zzdxm.zza(new zzaow(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzafl();
    }
}
