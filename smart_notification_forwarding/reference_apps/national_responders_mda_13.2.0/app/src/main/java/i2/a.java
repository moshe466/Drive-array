package i2;

import android.content.Context;
import g2.l;

/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static Context f10722a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f10723b;

    public static synchronized boolean a(Context context) {
        Boolean bool;
        Boolean bool2;
        synchronized (a.class) {
            Context applicationContext = context.getApplicationContext();
            Context context2 = f10722a;
            if (context2 != null && (bool2 = f10723b) != null && context2 == applicationContext) {
                return bool2.booleanValue();
            }
            f10723b = null;
            if (!l.h()) {
                try {
                    context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                    f10723b = Boolean.TRUE;
                } catch (ClassNotFoundException unused) {
                    bool = Boolean.FALSE;
                }
                f10722a = applicationContext;
                return f10723b.booleanValue();
            }
            bool = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
            f10723b = bool;
            f10722a = applicationContext;
            return f10723b.booleanValue();
        }
    }
}
