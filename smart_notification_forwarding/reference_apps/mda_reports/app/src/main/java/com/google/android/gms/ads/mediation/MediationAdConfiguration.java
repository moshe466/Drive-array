package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* loaded from: classes.dex */
public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    private final String zzabq;
    private final int zzddh;
    private final String zzdem;
    private final String zzeif;
    private final Bundle zzeig;
    private final Bundle zzeih;
    private final int zzeii;
    private final boolean zzmh;
    private final Location zzmi;
    private final Context zzup;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, @Nullable Location location, int i, int i2, @Nullable String str2, String str3) {
        this.zzeif = str;
        this.zzeig = bundle;
        this.zzeih = bundle2;
        this.zzup = context;
        this.zzmh = z;
        this.zzmi = location;
        this.zzddh = i;
        this.zzeii = i2;
        this.zzabq = str2;
        this.zzdem = str3;
    }

    public String getBidResponse() {
        return this.zzeif;
    }

    public Context getContext() {
        return this.zzup;
    }

    public Location getLocation() {
        return this.zzmi;
    }

    @Nullable
    public String getMaxAdContentRating() {
        return this.zzabq;
    }

    public Bundle getMediationExtras() {
        return this.zzeih;
    }

    public Bundle getServerParameters() {
        return this.zzeig;
    }

    public String getWatermark() {
        return this.zzdem;
    }

    public boolean isTestRequest() {
        return this.zzmh;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzddh;
    }

    public int taggedForUnderAgeTreatment() {
        return this.zzeii;
    }
}
