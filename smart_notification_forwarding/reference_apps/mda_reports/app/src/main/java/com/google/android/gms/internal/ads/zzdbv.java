package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzdbv implements zzdxg<zzdhd> {
    private static final zzdbv zzgpt = new zzdbv();

    public static zzdbv zzapz() {
        return zzgpt;
    }

    public static zzdhd zzaqa() {
        return (zzdhd) zzdxm.zza(zzazd.zzdwe, "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzaqa();
    }
}
