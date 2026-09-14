package g2;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes.dex */
public final class o {
    public static boolean a(Context context, int i10) {
        if (!b(context, i10, "com.google.android.gms")) {
            return false;
        }
        try {
            return com.google.android.gms.common.f.a(context).b(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @TargetApi(19)
    public static boolean b(Context context, int i10, String str) {
        return i2.c.a(context).g(i10, str);
    }
}
