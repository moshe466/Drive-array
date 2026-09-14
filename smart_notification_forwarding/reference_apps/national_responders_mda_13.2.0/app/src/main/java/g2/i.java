package g2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f9753a;

    /* renamed from: b, reason: collision with root package name */
    private static Boolean f9754b;

    /* renamed from: c, reason: collision with root package name */
    private static Boolean f9755c;

    /* renamed from: d, reason: collision with root package name */
    private static Boolean f9756d;

    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f9756d == null) {
            boolean z10 = false;
            if (l.h() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z10 = true;
            }
            f9756d = Boolean.valueOf(z10);
        }
        return f9756d.booleanValue();
    }

    public static boolean b() {
        int i10 = com.google.android.gms.common.e.f5095a;
        return "user".equals(Build.TYPE);
    }

    @TargetApi(20)
    public static boolean c(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f9753a == null) {
            boolean z10 = false;
            if (l.e() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z10 = true;
            }
            f9753a = Boolean.valueOf(z10);
        }
        return f9753a.booleanValue();
    }

    @TargetApi(26)
    public static boolean d(Context context) {
        if (c(context) && !l.g()) {
            return true;
        }
        if (e(context)) {
            return !l.h() || l.k();
        }
        return false;
    }

    @TargetApi(21)
    public static boolean e(Context context) {
        if (f9754b == null) {
            boolean z10 = false;
            if (l.f() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z10 = true;
            }
            f9754b = Boolean.valueOf(z10);
        }
        return f9754b.booleanValue();
    }

    public static boolean f(Context context) {
        if (f9755c == null) {
            boolean z10 = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z10 = false;
            }
            f9755c = Boolean.valueOf(z10);
        }
        return f9755c.booleanValue();
    }
}
