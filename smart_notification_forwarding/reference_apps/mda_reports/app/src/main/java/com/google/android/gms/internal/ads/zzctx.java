package com.google.android.gms.internal.ads;

import android.os.Bundle;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzctx implements zzcub<zzcty<Bundle>> {
    private final boolean zzggy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzctx(@Nullable zzcxw zzcxwVar) {
        this.zzggy = zzcxwVar != null;
    }

    @Override // com.google.android.gms.internal.ads.zzcub
    public final zzdhe<zzcty<Bundle>> zzanc() {
        return zzdgs.zzaj(this.zzggy ? zzctw.a : null);
    }
}
