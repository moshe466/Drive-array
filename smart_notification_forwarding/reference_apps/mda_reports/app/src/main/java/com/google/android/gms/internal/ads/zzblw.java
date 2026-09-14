package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes.dex */
public final class zzblw implements zzbpe, zzbqb {
    private final zzazb zzbll;

    @Nullable
    private final zzbdi zzcza;
    private final zzczl zzffc;

    @Nullable
    @GuardedBy("this")
    private IObjectWrapper zzffd;

    @GuardedBy("this")
    private boolean zzffe;
    private final Context zzup;

    public zzblw(Context context, @Nullable zzbdi zzbdiVar, zzczl zzczlVar, zzazb zzazbVar) {
        this.zzup = context;
        this.zzcza = zzbdiVar;
        this.zzffc = zzczlVar;
        this.zzbll = zzazbVar;
    }

    private final synchronized void zzago() {
        if (this.zzffc.zzdli) {
            if (this.zzcza == null) {
                return;
            }
            if (com.google.android.gms.ads.internal.zzq.zzlf().zzp(this.zzup)) {
                int i = this.zzbll.zzdvz;
                int i2 = this.zzbll.zzdwa;
                StringBuilder sb = new StringBuilder(23);
                sb.append(i);
                sb.append(".");
                sb.append(i2);
                this.zzffd = com.google.android.gms.ads.internal.zzq.zzlf().zza(sb.toString(), this.zzcza.getWebView(), "", "javascript", this.zzffc.zzgly.optInt("media_type", -1) == 0 ? null : "javascript");
                View view = this.zzcza.getView();
                if (this.zzffd != null && view != null) {
                    com.google.android.gms.ads.internal.zzq.zzlf().zza(this.zzffd, view);
                    this.zzcza.zzan(this.zzffd);
                    com.google.android.gms.ads.internal.zzq.zzlf().zzab(this.zzffd);
                    this.zzffe = true;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbpe
    public final synchronized void onAdImpression() {
        if (!this.zzffe) {
            zzago();
        }
        if (this.zzffc.zzdli && this.zzffd != null && this.zzcza != null) {
            this.zzcza.zza("onSdkImpression", new ArrayMap());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbqb
    public final synchronized void onAdLoaded() {
        if (this.zzffe) {
            return;
        }
        zzago();
    }
}
