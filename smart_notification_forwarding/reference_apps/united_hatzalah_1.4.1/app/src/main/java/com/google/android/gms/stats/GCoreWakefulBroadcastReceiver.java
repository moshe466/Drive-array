package com.google.android.gms.stats;

import android.content.Context;
import android.content.Intent;
import c0.AbstractC0327a;

/* loaded from: classes.dex */
public abstract class GCoreWakefulBroadcastReceiver extends AbstractC0327a {
    public static boolean completeWakefulIntent(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        return AbstractC0327a.completeWakefulIntent(intent);
    }
}
