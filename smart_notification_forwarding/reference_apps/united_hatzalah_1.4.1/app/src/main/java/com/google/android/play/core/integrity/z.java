package com.google.android.play.core.integrity;

import android.content.Context;

/* loaded from: classes.dex */
final class z {

    /* renamed from: a, reason: collision with root package name */
    private static s f4028a;

    public static synchronized s a(Context context) {
        s sVar;
        synchronized (z.class) {
            try {
                if (f4028a == null) {
                    q qVar = new q(null);
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    qVar.a(context);
                    f4028a = qVar.b();
                }
                sVar = f4028a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }
}
