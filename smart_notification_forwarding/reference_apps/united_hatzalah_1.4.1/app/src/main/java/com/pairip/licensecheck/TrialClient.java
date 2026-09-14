package com.pairip.licensecheck;

import android.content.Context;

/* loaded from: classes.dex */
public final class TrialClient {
    public static void stopTrial(Context context) {
        LicenseClient.stopTrial(context);
    }

    private TrialClient() {
    }
}
