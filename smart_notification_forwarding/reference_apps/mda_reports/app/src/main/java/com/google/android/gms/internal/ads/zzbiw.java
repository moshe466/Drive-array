package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzbiw implements zzbov, zzbpe, zzbqb, zzty {

    @Nullable
    private final View view;
    private final zzczt zzfbl;
    private final zzdda zzfbm;
    private final zzczl zzfbs;
    private final zzdq zzfbt;

    @GuardedBy("this")
    private boolean zzfbu;

    @GuardedBy("this")
    private boolean zzfbv;
    private final Context zzup;

    public zzbiw(Context context, zzczt zzcztVar, zzczl zzczlVar, zzdda zzddaVar, @Nullable View view, zzdq zzdqVar) {
        this.zzup = context;
        this.zzfbl = zzcztVar;
        this.zzfbs = zzczlVar;
        this.zzfbm = zzddaVar;
        this.zzfbt = zzdqVar;
        this.view = view;
    }

    @Override // com.google.android.gms.internal.ads.zzty
    public final void onAdClicked() {
        zzdda zzddaVar = this.zzfbm;
        zzczt zzcztVar = this.zzfbl;
        zzczl zzczlVar = this.zzfbs;
        zzddaVar.zza(zzcztVar, zzczlVar, zzczlVar.zzdbq);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void onAdImpression() {
        if (!this.zzfbv) {
            this.zzfbm.zza(this.zzfbl, this.zzfbs, false, ((Boolean) zzve.zzoy().zzd(zzzn.zzcls)).booleanValue() ? this.zzfbt.zzbw().zza(this.zzup, this.view, (Activity) null) : null, this.zzfbs.zzdbr);
            this.zzfbv = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbqb
    public final synchronized void onAdLoaded() {
        if (this.zzfbu) {
            ArrayList arrayList = new ArrayList(this.zzfbs.zzdbr);
            arrayList.addAll(this.zzfbs.zzglk);
            this.zzfbm.zza(this.zzfbl, this.zzfbs, true, null, arrayList);
        } else {
            this.zzfbm.zza(this.zzfbl, this.zzfbs, this.zzfbs.zzglm);
            this.zzfbm.zza(this.zzfbl, this.zzfbs, this.zzfbs.zzglk);
        }
        this.zzfbu = true;
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdOpened() {
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoCompleted() {
        zzdda zzddaVar = this.zzfbm;
        zzczt zzcztVar = this.zzfbl;
        zzczl zzczlVar = this.zzfbs;
        zzddaVar.zza(zzcztVar, zzczlVar, zzczlVar.zzgll);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoStarted() {
        zzdda zzddaVar = this.zzfbm;
        zzczt zzcztVar = this.zzfbl;
        zzczl zzczlVar = this.zzfbs;
        zzddaVar.zza(zzcztVar, zzczlVar, zzczlVar.zzdkz);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void zzb(zzare zzareVar, String str, String str2) {
        zzdda zzddaVar = this.zzfbm;
        zzczt zzcztVar = this.zzfbl;
        zzczl zzczlVar = this.zzfbs;
        zzddaVar.zza(zzcztVar, zzczlVar, zzczlVar.zzdla, zzareVar);
    }
}
