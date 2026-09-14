package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public final class zzaad extends zzaai {
    private final com.google.android.gms.ads.internal.zze zzcry;

    @Nullable
    private final String zzcrz;
    private final String zzcsa;

    public zzaad(com.google.android.gms.ads.internal.zze zzeVar, @Nullable String str, String str2) {
        this.zzcry = zzeVar;
        this.zzcrz = str;
        this.zzcsa = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzaaf
    public final String getContent() {
        return this.zzcsa;
    }

    @Override // com.google.android.gms.internal.ads.zzaaf
    public final void recordClick() {
        this.zzcry.zzjr();
    }

    @Override // com.google.android.gms.internal.ads.zzaaf
    public final void recordImpression() {
        this.zzcry.zzjs();
    }

    @Override // com.google.android.gms.internal.ads.zzaaf
    public final void zzn(@Nullable IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return;
        }
        this.zzcry.zzg((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaaf
    public final String zzqs() {
        return this.zzcrz;
    }
}
