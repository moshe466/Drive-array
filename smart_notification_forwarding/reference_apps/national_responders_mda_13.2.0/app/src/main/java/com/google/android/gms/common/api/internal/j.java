package com.google.android.gms.common.api.internal;

import android.app.Activity;

/* loaded from: classes.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private final Object f4878a;

    public j(Activity activity) {
        b2.p.l(activity, "Activity must not be null");
        this.f4878a = activity;
    }

    public final Activity a() {
        return (Activity) this.f4878a;
    }

    public final androidx.fragment.app.j b() {
        return (androidx.fragment.app.j) this.f4878a;
    }

    public final boolean c() {
        return this.f4878a instanceof Activity;
    }

    public final boolean d() {
        return this.f4878a instanceof androidx.fragment.app.j;
    }
}
