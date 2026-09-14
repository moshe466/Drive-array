package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private static final long f7270a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b, reason: collision with root package name */
    private static final Object f7271b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private static y2.a f7272c;

    private static void a(Context context) {
        if (f7272c == null) {
            y2.a aVar = new y2.a(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            f7272c = aVar;
            aVar.c(true);
        }
    }

    public static void b(Intent intent) {
        synchronized (f7271b) {
            if (f7272c != null && c(intent)) {
                d(intent, false);
                f7272c.b();
            }
        }
    }

    static boolean c(Intent intent) {
        return intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false);
    }

    private static void d(Intent intent, boolean z10) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z10);
    }

    public static ComponentName e(Context context, Intent intent) {
        synchronized (f7271b) {
            a(context);
            boolean c10 = c(intent);
            d(intent, true);
            ComponentName startService = context.startService(intent);
            if (startService == null) {
                return null;
            }
            if (!c10) {
                f7272c.a(f7270a);
            }
            return startService;
        }
    }
}
