package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbod;

/* loaded from: classes.dex */
public final class zzcli extends zzclk<zzbmj> {
    private final zzbvi zzelu;
    private final zzbrm zzers;
    private final zzbfx zzfzz;
    private final zzbod.zza zzgaa;

    public zzcli(zzbfx zzbfxVar, zzbvi zzbviVar, zzbod.zza zzaVar, zzbrm zzbrmVar) {
        this.zzfzz = zzbfxVar;
        this.zzelu = zzbviVar;
        this.zzgaa = zzaVar;
        this.zzers = zzbrmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzclk
    protected final zzdhe<zzbmj> a(zzczu zzczuVar, Bundle bundle) {
        return this.zzfzz.zzacl().zza(this.zzgaa.zza(zzczuVar).zze(bundle).zzahh()).zza(this.zzers).zza(this.zzelu).zzadf().zzadc().zzaha();
    }
}
