package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public final class zzcpz implements zzcty<Bundle> {
    private final zzczu zzfgl;

    public zzcpz(zzczu zzczuVar) {
        Preconditions.checkNotNull(zzczuVar, "the targeting must not be null");
        this.zzfgl = zzczuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcty
    public final /* synthetic */ void zzr(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzczu zzczuVar = this.zzfgl;
        zzug zzugVar = zzczuVar.zzgml;
        bundle2.putString("slotname", zzczuVar.zzgmm);
        if (this.zzfgl.zzgms.contains("new_rewarded")) {
            bundle2.putBoolean("is_new_rewarded", true);
        }
        zzdaa.zza(bundle2, "cust_age", new SimpleDateFormat("yyyyMMdd", Locale.US).format(new Date(zzugVar.zzcby)), zzugVar.zzcby != -1);
        zzdaa.zza(bundle2, "extras", zzugVar.extras);
        zzdaa.zza(bundle2, "cust_gender", Integer.valueOf(zzugVar.zzcbz), zzugVar.zzcbz != -1);
        zzdaa.zza(bundle2, "kw", zzugVar.zzcca);
        zzdaa.zza(bundle2, "tag_for_child_directed_treatment", Integer.valueOf(zzugVar.zzabo), zzugVar.zzabo != -1);
        boolean z = zzugVar.zzccb;
        if (z) {
            bundle2.putBoolean("test_request", z);
        }
        zzdaa.zza(bundle2, "d_imp_hdr", (Integer) 1, zzugVar.versionCode >= 2 && zzugVar.zzbkh);
        String str = zzugVar.zzccc;
        zzdaa.zza(bundle2, "ppid", str, zzugVar.versionCode >= 2 && !TextUtils.isEmpty(str));
        Location location = zzugVar.zzmi;
        if (location != null) {
            Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long valueOf2 = Long.valueOf(location.getTime() * 1000);
            Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle3 = new Bundle();
            bundle3.putFloat("radius", valueOf.floatValue());
            bundle3.putLong("lat", valueOf3.longValue());
            bundle3.putLong("long", valueOf4.longValue());
            bundle3.putLong("time", valueOf2.longValue());
            bundle2.putBundle("uule", bundle3);
        }
        zzdaa.zza(bundle2, "url", zzugVar.zzcce);
        zzdaa.zza(bundle2, "neighboring_content_urls", zzugVar.zzccl);
        zzdaa.zza(bundle2, "custom_targeting", zzugVar.zzccg);
        zzdaa.zza(bundle2, "category_exclusions", zzugVar.zzcch);
        zzdaa.zza(bundle2, "request_agent", zzugVar.zzcci);
        zzdaa.zza(bundle2, "request_pkg", zzugVar.zzccj);
        zzdaa.zza(bundle2, "is_designed_for_families", Boolean.valueOf(zzugVar.zzcck), zzugVar.versionCode >= 7);
        if (zzugVar.versionCode >= 8) {
            zzdaa.zza(bundle2, "tag_for_under_age_of_consent", Integer.valueOf(zzugVar.zzabp), zzugVar.zzabp != -1);
            zzdaa.zza(bundle2, "max_ad_content_rating", zzugVar.zzabq);
        }
    }
}
