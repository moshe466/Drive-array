package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzcst implements zzcty<Bundle> {
    private final String zzggc;

    public zzcst(String str) {
        this.zzggc = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean zzd(Set<String> set) {
        return set.contains("rewarded") || set.contains("interstitial") || set.contains("native") || set.contains("banner");
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        zzdaa.zza(bundle, "omid_v", this.zzggc);
    }
}
