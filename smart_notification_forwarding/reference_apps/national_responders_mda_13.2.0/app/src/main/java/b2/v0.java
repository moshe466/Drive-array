package b2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public final class v0 {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f4081a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f4082b;

    /* renamed from: c, reason: collision with root package name */
    private static String f4083c;

    /* renamed from: d, reason: collision with root package name */
    private static int f4084d;

    public static int a(Context context) {
        c(context);
        return f4084d;
    }

    public static String b(Context context) {
        c(context);
        return f4083c;
    }

    private static void c(Context context) {
        Bundle bundle;
        synchronized (f4081a) {
            if (f4082b) {
                return;
            }
            f4082b = true;
            try {
                bundle = i2.c.a(context).c(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e10) {
                Log.wtf("MetadataValueReader", "This should never happen.", e10);
            }
            if (bundle == null) {
                return;
            }
            f4083c = bundle.getString("com.google.app.id");
            f4084d = bundle.getInt("com.google.android.gms.version");
        }
    }
}
