package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzcsg implements zzcty<Bundle> {
    private final zzczj zzfbj;

    public zzcsg(zzczj zzczjVar) {
        this.zzfbj = zzczjVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzczj zzczjVar = this.zzfbj;
        if (zzczjVar != null) {
            bundle2.putBoolean("render_in_browser", zzczjVar.zzaom());
            bundle2.putBoolean("disable_ml", this.zzfbj.zzaon());
        }
    }
}
