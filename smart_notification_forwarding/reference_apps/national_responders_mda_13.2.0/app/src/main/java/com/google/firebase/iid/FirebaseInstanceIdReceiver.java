package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import java.util.concurrent.ExecutionException;

/* loaded from: classes.dex */
public final class FirebaseInstanceIdReceiver extends y1.b {
    private static Intent h(Context context, String str, Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    @Override // y1.b
    protected int b(Context context, y1.a aVar) {
        try {
            return ((Integer) z2.o.a(new f(context).g(aVar.g()))).intValue();
        } catch (InterruptedException | ExecutionException unused) {
            return 500;
        }
    }

    @Override // y1.b
    protected void c(Context context, Bundle bundle) {
        try {
            z2.o.a(new f(context).g(h(context, "com.google.firebase.messaging.NOTIFICATION_DISMISS", bundle)));
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // y1.b
    protected void d(Context context, Bundle bundle) {
        try {
            z2.o.a(new f(context).g(h(context, "com.google.firebase.messaging.NOTIFICATION_OPEN", bundle)));
        } catch (InterruptedException | ExecutionException unused) {
        }
    }
}
