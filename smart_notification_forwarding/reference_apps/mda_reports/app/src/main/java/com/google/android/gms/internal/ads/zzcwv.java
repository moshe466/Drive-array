package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.widget.RelativeLayout;

/* loaded from: classes.dex */
final class zzcwv implements zzcoz<zzbke> {
    private final /* synthetic */ zzcwr zzgjd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcwv(zzcwr zzcwrVar) {
        this.zzgjd = zzcwrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcoz
    public final /* synthetic */ void onSuccess(zzbke zzbkeVar) {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        zzazb zzazbVar;
        ViewGroup viewGroup3;
        zzuj zzaod;
        ViewGroup viewGroup4;
        zzuj zzaod2;
        zzcwz zzcwzVar;
        com.google.android.gms.ads.internal.overlay.zzq zza;
        RelativeLayout.LayoutParams zzb;
        ViewGroup viewGroup5;
        zzbke zzbkeVar2 = zzbkeVar;
        zzbke zzbkeVar3 = this.zzgjd.a;
        if (zzbkeVar3 != null) {
            zzbkeVar3.destroy();
        }
        zzcwr zzcwrVar = this.zzgjd;
        zzcwrVar.a = zzbkeVar2;
        viewGroup = zzcwrVar.zzfdu;
        viewGroup.removeAllViews();
        viewGroup2 = this.zzgjd.zzfdu;
        viewGroup2.addView(zzbkeVar2.zzaga(), com.google.android.gms.ads.internal.zzq.zzks().zzwp());
        zzazbVar = this.zzgjd.zzbli;
        if (zzazbVar.zzdwa < ((Integer) zzve.zzoy().zzd(zzzn.zzcoh)).intValue()) {
            zza = this.zzgjd.zza(zzbkeVar2);
            zzcwr zzcwrVar2 = this.zzgjd;
            zzb = zzcwr.zzb(zzbkeVar2);
            zza.zzal(zzbkeVar2.zzagb());
            viewGroup5 = this.zzgjd.zzfdu;
            viewGroup5.addView(zza, zzb);
        }
        this.zzgjd.zzc(zzbkeVar2);
        viewGroup3 = this.zzgjd.zzfdu;
        zzaod = this.zzgjd.zzaod();
        viewGroup3.setMinimumHeight(zzaod.heightPixels);
        viewGroup4 = this.zzgjd.zzfdu;
        zzaod2 = this.zzgjd.zzaod();
        viewGroup4.setMinimumWidth(zzaod2.widthPixels);
        zzcwzVar = this.zzgjd.zzgix;
        zzcwzVar.zzb(new zzbkg(zzbkeVar2, this.zzgjd));
        zzbkeVar2.zzagf();
    }

    @Override // com.google.android.gms.internal.ads.zzcoz
    public final void zzamx() {
        this.zzgjd.a = null;
    }
}
