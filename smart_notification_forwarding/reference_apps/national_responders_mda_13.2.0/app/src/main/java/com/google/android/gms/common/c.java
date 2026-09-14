package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import b2.o1;

/* loaded from: classes.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final int f5093a = e.f5095a;

    /* renamed from: b, reason: collision with root package name */
    private static final c f5094b = new c();

    public static c h() {
        return f5094b;
    }

    public void a(Context context) {
        e.a(context);
    }

    public int b(Context context) {
        return e.b(context);
    }

    @Deprecated
    public Intent c(int i10) {
        return d(null, i10, null);
    }

    public Intent d(Context context, int i10, String str) {
        if (i10 != 1 && i10 != 2) {
            if (i10 != 3) {
                return null;
            }
            return o1.c("com.google.android.gms");
        }
        if (context != null && g2.i.d(context)) {
            return o1.a();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("gcore_");
        sb2.append(f5093a);
        sb2.append("-");
        if (!TextUtils.isEmpty(str)) {
            sb2.append(str);
        }
        sb2.append("-");
        if (context != null) {
            sb2.append(context.getPackageName());
        }
        sb2.append("-");
        if (context != null) {
            try {
                sb2.append(i2.c.a(context).e(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return o1.b("com.google.android.gms", sb2.toString());
    }

    public PendingIntent e(Context context, int i10, int i11) {
        return f(context, i10, i11, null);
    }

    public PendingIntent f(Context context, int i10, int i11, String str) {
        Intent d10 = d(context, i10, str);
        if (d10 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i11, d10, o2.d.f12463a | 134217728);
    }

    public String g(int i10) {
        return e.c(i10);
    }

    public int i(Context context) {
        return j(context, f5093a);
    }

    public int j(Context context, int i10) {
        int g10 = e.g(context, i10);
        if (e.h(context, g10)) {
            return 18;
        }
        return g10;
    }

    public boolean k(Context context, int i10) {
        return e.h(context, i10);
    }

    public boolean l(Context context, String str) {
        return e.l(context, str);
    }

    public boolean m(int i10) {
        return e.j(i10);
    }
}
