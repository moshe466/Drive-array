package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzamd implements NativeMediationAdRequest {
    private final String zzabq;
    private final int zzcbz;
    private final boolean zzcck;
    private final int zzddh;
    private final int zzddi;
    private final zzaby zzddz;
    private final List<String> zzdea = new ArrayList();
    private final Map<String, Boolean> zzdeb = new HashMap();
    private final Date zzme;
    private final Set<String> zzmg;
    private final boolean zzmh;
    private final Location zzmi;

    public zzamd(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, zzaby zzabyVar, List<String> list, boolean z2, int i3, String str) {
        Map<String, Boolean> map;
        String str2;
        boolean z3;
        this.zzme = date;
        this.zzcbz = i;
        this.zzmg = set;
        this.zzmi = location;
        this.zzmh = z;
        this.zzddh = i2;
        this.zzddz = zzabyVar;
        this.zzcck = z2;
        this.zzddi = i3;
        this.zzabq = str;
        if (list != null) {
            for (String str3 : list) {
                if (str3.startsWith("custom:")) {
                    String[] split = str3.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            map = this.zzdeb;
                            str2 = split[1];
                            z3 = true;
                        } else if ("false".equals(split[2])) {
                            map = this.zzdeb;
                            str2 = split[1];
                            z3 = false;
                        }
                        map.put(str2, z3);
                    }
                } else {
                    this.zzdea.add(str3);
                }
            }
        }
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final float getAdVolume() {
        return zzxq.zzpw().zzpe();
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final Date getBirthday() {
        return this.zzme;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final int getGender() {
        return this.zzcbz;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.zzmg;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.zzmi;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions getNativeAdOptions() {
        zzyw zzywVar;
        if (this.zzddz == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzddz.zzcvo).setImageOrientation(this.zzddz.zzbjw).setRequestMultipleImages(this.zzddz.zzbjy);
        zzaby zzabyVar = this.zzddz;
        if (zzabyVar.versionCode >= 2) {
            requestMultipleImages.setAdChoicesPlacement(zzabyVar.zzbjz);
        }
        zzaby zzabyVar2 = this.zzddz;
        if (zzabyVar2.versionCode >= 3 && (zzywVar = zzabyVar2.zzcvp) != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions(zzywVar));
        }
        return requestMultipleImages.build();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAdMuted() {
        return zzxq.zzpw().zzpf();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAppInstallAdRequested() {
        List<String> list = this.zzdea;
        if (list != null) {
            return list.contains(ExifInterface.GPS_MEASUREMENT_2D) || this.zzdea.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isContentAdRequested() {
        List<String> list = this.zzdea;
        if (list != null) {
            return list.contains("1") || this.zzdea.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzcck;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.zzmh;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isUnifiedNativeAdRequested() {
        List<String> list = this.zzdea;
        return list != null && list.contains("6");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzddh;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean zzsz() {
        List<String> list = this.zzdea;
        return list != null && list.contains(ExifInterface.GPS_MEASUREMENT_3D);
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final Map<String, Boolean> zzta() {
        return this.zzdeb;
    }
}
