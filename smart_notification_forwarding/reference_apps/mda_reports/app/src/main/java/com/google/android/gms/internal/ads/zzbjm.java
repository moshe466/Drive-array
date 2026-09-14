package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbjm implements zzdxg<zzakh> {
    private final zzdxp<zzakc> zzfdf;

    private zzbjm(zzdxp<zzakc> zzdxpVar) {
        this.zzfdf = zzdxpVar;
    }

    public static zzbjm zzb(zzdxp<zzakc> zzdxpVar) {
        return new zzbjm(zzdxpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzakh) zzdxm.zza(this.zzfdf.get().zzsh(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
