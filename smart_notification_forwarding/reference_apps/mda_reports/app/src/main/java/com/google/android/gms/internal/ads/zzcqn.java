package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class zzcqn implements zzcty<Bundle> {
    private final zzuo zzgey;

    public zzcqn(zzuo zzuoVar) {
        this.zzgey = zzuoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzuo zzuoVar = this.zzgey;
        if (zzuoVar != null) {
            int i = zzuoVar.orientation;
            if (i == 1) {
                bundle2.putString("avo", "p");
            } else if (i == 2) {
                bundle2.putString("avo", "l");
            }
        }
    }
}
