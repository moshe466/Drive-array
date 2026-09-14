package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* loaded from: classes.dex */
final class zzcrs implements zzcty<Bundle> {
    private final String zzdke;
    private final String zzgft;
    private final Bundle zzgfu;

    private zzcrs(String str, String str2, Bundle bundle) {
        this.zzdke = str;
        this.zzgft = str2;
        this.zzgfu = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        bundle2.putString("consent_string", this.zzdke);
        bundle2.putString("fc_consent", this.zzgft);
        bundle2.putBundle("iab_consent_info", this.zzgfu);
    }
}
