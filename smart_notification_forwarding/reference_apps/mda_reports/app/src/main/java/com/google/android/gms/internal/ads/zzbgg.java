package com.google.android.gms.internal.ads;

/* loaded from: classes.dex */
public final class zzbgg implements zzdxg<zzbij> {
    private final zzbga zzejr;
    private final zzdxp<zzbfx> zzejt;

    public zzbgg(zzbga zzbgaVar, zzdxp<zzbfx> zzdxpVar) {
        this.zzejr = zzbgaVar;
        this.zzejt = zzdxpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdxp
    public final /* synthetic */ Object get() {
        return (zzbij) zzdxm.zza(this.zzejt.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
