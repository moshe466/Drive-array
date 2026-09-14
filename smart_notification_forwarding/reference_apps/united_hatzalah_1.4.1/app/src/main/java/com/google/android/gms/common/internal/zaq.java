package com.google.android.gms.common.internal;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;

/* loaded from: classes.dex */
public final class zaq {
    private final SparseIntArray zaa;
    private GoogleApiAvailabilityLight zab;

    public zaq() {
        this(GoogleApiAvailability.getInstance());
    }

    public final int zaa(Context context, Api.Client client) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(client);
        int i = 0;
        if (!client.requiresGooglePlayServices()) {
            return 0;
        }
        int minApkVersion = client.getMinApkVersion();
        int zab = zab(context, minApkVersion);
        if (zab != -1) {
            return zab;
        }
        SparseIntArray sparseIntArray = this.zaa;
        synchronized (sparseIntArray) {
            int i3 = 0;
            while (true) {
                try {
                    if (i3 < sparseIntArray.size()) {
                        int keyAt = sparseIntArray.keyAt(i3);
                        if (keyAt > minApkVersion && sparseIntArray.get(keyAt) == 0) {
                            break;
                        }
                        i3++;
                    } else {
                        i = -1;
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (i == -1) {
                i = this.zab.isGooglePlayServicesAvailable(context, minApkVersion);
            }
            sparseIntArray.put(minApkVersion, i);
        }
        return i;
    }

    public final int zab(Context context, int i) {
        int i3;
        SparseIntArray sparseIntArray = this.zaa;
        synchronized (sparseIntArray) {
            i3 = sparseIntArray.get(i, -1);
        }
        return i3;
    }

    public final void zac() {
        SparseIntArray sparseIntArray = this.zaa;
        synchronized (sparseIntArray) {
            sparseIntArray.clear();
        }
    }

    public zaq(GoogleApiAvailabilityLight googleApiAvailabilityLight) {
        this.zaa = new SparseIntArray();
        Preconditions.checkNotNull(googleApiAvailabilityLight);
        this.zab = googleApiAvailabilityLight;
    }
}
