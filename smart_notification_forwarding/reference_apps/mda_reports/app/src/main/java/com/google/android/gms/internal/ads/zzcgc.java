package com.google.android.gms.internal.ads;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
final class zzcgc implements zzdgt<zzczt> {
    private final /* synthetic */ zzcfx zzfvj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcgc(zzcfx zzcfxVar) {
        this.zzfvj = zzcfxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final /* synthetic */ void onSuccess(zzczt zzcztVar) {
        zzchz zzchzVar;
        zzchz zzchzVar2;
        zzczt zzcztVar2 = zzcztVar;
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcqf)).booleanValue()) {
            zzchzVar = this.zzfvj.zzfvf;
            zzchzVar.zzdk(zzcztVar2.zzgmi.zzgmf.responseCode);
            zzchzVar2 = this.zzfvj.zzfvf;
            zzchzVar2.zzeq(zzcztVar2.zzgmi.zzgmf.zzfwt);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgt
    public final void zzb(Throwable th) {
        Pattern pattern;
        zzchz zzchzVar;
        if (((Boolean) zzve.zzoy().zzd(zzzn.zzcqf)).booleanValue()) {
            pattern = zzcfx.zzfvg;
            Matcher matcher = pattern.matcher(th.getMessage());
            if (matcher.matches()) {
                String group = matcher.group(1);
                zzchzVar = this.zzfvj.zzfvf;
                zzchzVar.zzdk(Integer.parseInt(group));
            }
        }
    }
}
