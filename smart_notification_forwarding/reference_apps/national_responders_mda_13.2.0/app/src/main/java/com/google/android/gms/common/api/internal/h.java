package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.api.Status;

@Deprecated
/* loaded from: classes.dex */
public final class h {

    /* renamed from: d, reason: collision with root package name */
    private static final Object f4866d = new Object();

    /* renamed from: e, reason: collision with root package name */
    private static h f4867e;

    /* renamed from: a, reason: collision with root package name */
    private final String f4868a;

    /* renamed from: b, reason: collision with root package name */
    private final Status f4869b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f4870c;

    h(Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(z1.e.f16071a));
        boolean z10 = false;
        if (identifier != 0 && resources.getInteger(identifier) == 0) {
            z10 = true;
        }
        this.f4870c = z10;
        String b10 = b2.v0.b(context);
        b10 = b10 == null ? new b2.s(context).a("google_app_id") : b10;
        if (TextUtils.isEmpty(b10)) {
            this.f4869b = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f4868a = null;
        } else {
            this.f4868a = b10;
            this.f4869b = Status.f4747k;
        }
    }

    private static h a(String str) {
        h hVar;
        synchronized (f4866d) {
            hVar = f4867e;
            if (hVar == null) {
                throw new IllegalStateException("Initialize must be called before " + str + ".");
            }
        }
        return hVar;
    }

    public static String b() {
        return a("getGoogleAppId").f4868a;
    }

    public static Status c(Context context) {
        Status status;
        b2.p.l(context, "Context must not be null.");
        synchronized (f4866d) {
            if (f4867e == null) {
                f4867e = new h(context);
            }
            status = f4867e.f4869b;
        }
        return status;
    }

    public static boolean d() {
        return a("isMeasurementExplicitlyDisabled").f4870c;
    }
}
