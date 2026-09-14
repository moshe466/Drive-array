package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class zzbuy implements com.google.android.gms.ads.internal.overlay.zzo, zzbqb {
    private final zzazb zzbll;

    @Nullable
    private final zzbdi zzcza;
    private final zzczl zzffc;

    @Nullable
    @VisibleForTesting
    private IObjectWrapper zzffd;
    private final int zzfjj;
    private final Context zzup;

    public zzbuy(Context context, @Nullable zzbdi zzbdiVar, zzczl zzczlVar, zzazb zzazbVar, int i) {
        this.zzup = context;
        this.zzcza = zzbdiVar;
        this.zzffc = zzczlVar;
        this.zzbll = zzazbVar;
        this.zzfjj = i;
    }

    @Override // com.google.android.gms.internal.ads.zzbqb
    public final void onAdLoaded() {
        int i = this.zzfjj;
        if ((i == 7 || i == 3) && this.zzffc.zzdli && this.zzcza != null && com.google.android.gms.ads.internal.zzq.zzlf().zzp(this.zzup)) {
            zzazb zzazbVar = this.zzbll;
            int i2 = zzazbVar.zzdvz;
            int i3 = zzazbVar.zzdwa;
            StringBuilder sb = new StringBuilder(23);
            sb.append(i2);
            sb.append(".");
            sb.append(i3);
            this.zzffd = com.google.android.gms.ads.internal.zzq.zzlf().zza(sb.toString(), this.zzcza.getWebView(), "", "javascript", this.zzffc.zzgly.optInt("media_type", -1) == 0 ? null : "javascript");
            if (this.zzffd == null || this.zzcza.getView() == null) {
                return;
            }
            com.google.android.gms.ads.internal.zzq.zzlf().zza(this.zzffd, this.zzcza.getView());
            this.zzcza.zzan(this.zzffd);
            com.google.android.gms.ads.internal.zzq.zzlf().zzab(this.zzffd);
        }
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzte() {
        this.zzffd = null;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zztf() {
        zzbdi zzbdiVar;
        if (this.zzffd == null || (zzbdiVar = this.zzcza) == null) {
            return;
        }
        zzbdiVar.zza("onSdkImpression", new HashMap());
    }
}
