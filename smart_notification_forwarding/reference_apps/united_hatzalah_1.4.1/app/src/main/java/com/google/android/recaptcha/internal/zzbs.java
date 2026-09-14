package com.google.android.recaptcha.internal;

import android.content.Context;
import com.google.android.gms.common.GoogleApiAvailabilityLight;

/* loaded from: classes.dex */
public final class zzbs {
    private final GoogleApiAvailabilityLight zza;

    public zzbs(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zza = googleApiAvailabilityLight;
    }

    public final int zza(Context context) {
        int isGooglePlayServicesAvailable = this.zza.isGooglePlayServicesAvailable(context);
        if (isGooglePlayServicesAvailable != 1 && isGooglePlayServicesAvailable != 3 && isGooglePlayServicesAvailable != 9) {
            return 3;
        }
        return 4;
    }

    public zzbs() {
        this.zza = GoogleApiAvailabilityLight.getInstance();
    }
}
