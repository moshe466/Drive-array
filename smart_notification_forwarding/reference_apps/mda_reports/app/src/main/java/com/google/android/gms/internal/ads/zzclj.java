package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbod;

/* loaded from: classes.dex */
public final class zzclj extends zzclk<zzbkk> {
    private final zzbvi zzelu;
    private final zzbrm zzers;
    private final zzcns zzexc;
    private final ViewGroup zzfdu;
    private final zzbqp zzffm;
    private final zzbfx zzfzz;
    private final zzbod.zza zzgaa;

    public zzclj(zzbfx zzbfxVar, zzbod.zza zzaVar, zzcns zzcnsVar, zzbrm zzbrmVar, zzbvi zzbviVar, zzbqp zzbqpVar, @Nullable ViewGroup viewGroup) {
        this.zzfzz = zzbfxVar;
        this.zzgaa = zzaVar;
        this.zzexc = zzcnsVar;
        this.zzers = zzbrmVar;
        this.zzelu = zzbviVar;
        this.zzffm = zzbqpVar;
        this.zzfdu = viewGroup;
    }

    @Override // com.google.android.gms.internal.ads.zzclk
    protected final zzdhe<zzbkk> a(zzczu zzczuVar, Bundle bundle) {
        return this.zzfzz.zzach().zzc(this.zzgaa.zza(zzczuVar).zze(bundle).zzahh()).zzc(this.zzers).zza(this.zzexc).zzb(this.zzelu).zza(new zzbma(this.zzffm)).zzb(new zzbkf(this.zzfdu)).zzaee().zzadc().zzaha();
    }
}
