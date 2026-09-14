package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbgl implements zzdxg<zzazb> {
    private final zzbga zzejr;

    public zzbgl(zzbga zzbgaVar) {
        this.zzejr = zzbgaVar;
    }

    public static zzazb zzb(zzbga zzbgaVar) {
        return (zzazb) zzdxm.zza(zzbgaVar.c(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return zzb(this.zzejr);
    }
}
