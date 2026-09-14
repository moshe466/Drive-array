package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/* loaded from: classes.dex */
public final class zzbve implements zzbov, zzbsm {

    @Nullable
    private final View view;
    private final zzatv zzbng;
    private final zzats zzffo;
    private final int zzfjj;
    private String zzfjp;
    private final Context zzup;

    public zzbve(zzats zzatsVar, Context context, zzatv zzatvVar, @Nullable View view, int i) {
        this.zzffo = zzatsVar;
        this.zzup = context;
        this.zzbng = zzatvVar;
        this.view = view;
        this.zzfjj = i;
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdClosed() {
        this.zzffo.zzam(false);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onAdOpened() {
        View view = this.view;
        if (view != null && this.zzfjp != null) {
            this.zzbng.zzg(view.getContext(), this.zzfjp);
        }
        this.zzffo.zzam(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsm
    public final void zzahx() {
        this.zzfjp = this.zzbng.zzad(this.zzup);
        String valueOf = String.valueOf(this.zzfjp);
        String str = this.zzfjj == 7 ? "/Rewarded" : "/Interstitial";
        this.zzfjp = str.length() != 0 ? valueOf.concat(str) : new String(valueOf);
    }

    @Override // com.google.android.gms.internal.ads.zzbov
    @ParametersAreNonnullByDefault
    public final void zzb(zzare zzareVar, String str, String str2) {
        if (this.zzbng.zzab(this.zzup)) {
            try {
                this.zzbng.zza(this.zzup, this.zzbng.zzag(this.zzup), this.zzffo.getAdUnitId(), zzareVar.getType(), zzareVar.getAmount());
            } catch (RemoteException e) {
                zzayu.zzd("Remote Exception to get reward item.", e);
            }
        }
    }
}
