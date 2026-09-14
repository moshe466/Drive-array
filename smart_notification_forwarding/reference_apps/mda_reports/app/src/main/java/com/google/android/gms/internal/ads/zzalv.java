package com.google.android.gms.internal.ads;

import android.location.Location;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzalv implements MediationAdRequest {
    private final String zzabq;
    private final int zzcbz;
    private final boolean zzcck;
    private final int zzddh;
    private final int zzddi;
    private final Date zzme;
    private final Set<String> zzmg;
    private final boolean zzmh;
    private final Location zzmi;

    public zzalv(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, boolean z2, int i3, String str) {
        this.zzme = date;
        this.zzcbz = i;
        this.zzmg = set;
        this.zzmi = location;
        this.zzmh = z;
        this.zzddh = i2;
        this.zzcck = z2;
        this.zzddi = i3;
        this.zzabq = str;
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

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzcck;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.zzmh;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzddh;
    }
}
