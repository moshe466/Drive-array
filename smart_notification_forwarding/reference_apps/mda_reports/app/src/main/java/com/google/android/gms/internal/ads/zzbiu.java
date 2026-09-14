package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzbiu implements zzbph {
    private final zzdac zzfbn;

    public zzbiu(zzdac zzdacVar) {
        this.zzfbn = zzdacVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzbv(@Nullable Context context) {
        try {
            this.zzfbn.pause();
        } catch (zzdab e) {
            zzayu.zzd("Cannot invoke onPause for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzbw(@Nullable Context context) {
        try {
            this.zzfbn.resume();
            if (context != null) {
                this.zzfbn.onContextChanged(context);
            }
        } catch (zzdab e) {
            zzayu.zzd("Cannot invoke onResume for the mediation adapter.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzbx(@Nullable Context context) {
        try {
            this.zzfbn.destroy();
        } catch (zzdab e) {
            zzayu.zzd("Cannot invoke onDestroy for the mediation adapter.", e);
        }
    }
}
