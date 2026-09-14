package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;

/* loaded from: classes.dex */
public final class r2 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile k3<Boolean> f5566a = k3.d();

    /* renamed from: b, reason: collision with root package name */
    private static final Object f5567b = new Object();

    private static boolean a(Context context) {
        return (context.getPackageManager().getApplicationInfo("com.google.android.gms", 0).flags & 129) != 0;
    }

    public static boolean b(Context context, Uri uri) {
        ProviderInfo resolveContentProvider;
        boolean z10;
        String authority = uri.getAuthority();
        boolean z11 = false;
        if (!"com.google.android.gms.phenotype".equals(authority)) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(authority).length() + 91);
            sb2.append(authority);
            sb2.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            return false;
        }
        if (!f5566a.b()) {
            synchronized (f5567b) {
                if (f5566a.b()) {
                    return f5566a.c().booleanValue();
                }
                if (!"com.google.android.gms".equals(context.getPackageName()) && ((resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.phenotype", 0)) == null || !"com.google.android.gms".equals(resolveContentProvider.packageName))) {
                    z10 = false;
                    if (z10 && a(context)) {
                        z11 = true;
                    }
                    f5566a = k3.a(Boolean.valueOf(z11));
                }
                z10 = true;
                if (z10) {
                    z11 = true;
                }
                f5566a = k3.a(Boolean.valueOf(z11));
            }
        }
        return f5566a.c().booleanValue();
    }
}
