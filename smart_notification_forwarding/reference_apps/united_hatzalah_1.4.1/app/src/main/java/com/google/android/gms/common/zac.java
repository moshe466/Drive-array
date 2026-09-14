package com.google.android.gms.common;

import android.content.Context;
import android.os.Message;
import com.google.android.gms.internal.base.zar;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zac extends zar {
    final /* synthetic */ GoogleApiAvailability zaa;
    private final Context zab;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public zac(com.google.android.gms.common.GoogleApiAvailability r1, android.content.Context r2) {
        /*
            r0 = this;
            java.util.Objects.requireNonNull(r1)
            r0.zaa = r1
            android.os.Looper r1 = android.os.Looper.myLooper()
            if (r1 != 0) goto L10
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            goto L14
        L10:
            android.os.Looper r1 = android.os.Looper.myLooper()
        L14:
            r0.<init>(r1)
            android.content.Context r1 = r2.getApplicationContext()
            r0.zab = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.zac.<init>(com.google.android.gms.common.GoogleApiAvailability, android.content.Context):void");
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            new StringBuilder(String.valueOf(i).length() + 39);
            return;
        }
        GoogleApiAvailability googleApiAvailability = this.zaa;
        Context context = this.zab;
        int isGooglePlayServicesAvailable = googleApiAvailability.isGooglePlayServicesAvailable(context);
        if (googleApiAvailability.isUserResolvableError(isGooglePlayServicesAvailable)) {
            googleApiAvailability.showErrorNotification(context, isGooglePlayServicesAvailable);
        }
    }
}
