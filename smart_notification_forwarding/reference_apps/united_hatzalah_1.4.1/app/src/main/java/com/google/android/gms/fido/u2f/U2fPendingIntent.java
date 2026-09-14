package com.google.android.gms.fido.u2f;

import android.app.Activity;

@Deprecated
/* loaded from: classes.dex */
public interface U2fPendingIntent {
    boolean hasPendingIntent();

    void launchPendingIntent(Activity activity, int i);
}
