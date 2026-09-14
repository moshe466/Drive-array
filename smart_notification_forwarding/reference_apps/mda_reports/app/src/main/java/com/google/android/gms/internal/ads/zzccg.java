package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzccg implements zzbph {

    @Nullable
    private final zzbdi zzcza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzccg(@Nullable zzbdi zzbdiVar) {
        this.zzcza = ((Boolean) zzve.zzoy().zzd(zzzn.zzciv)).booleanValue() ? zzbdiVar : null;
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzbv(@Nullable Context context) {
        zzbdi zzbdiVar = this.zzcza;
        if (zzbdiVar != null) {
            zzbdiVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzbw(@Nullable Context context) {
        zzbdi zzbdiVar = this.zzcza;
        if (zzbdiVar != null) {
            zzbdiVar.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbph
    public final void zzbx(@Nullable Context context) {
        zzbdi zzbdiVar = this.zzcza;
        if (zzbdiVar != null) {
            zzbdiVar.destroy();
        }
    }
}
