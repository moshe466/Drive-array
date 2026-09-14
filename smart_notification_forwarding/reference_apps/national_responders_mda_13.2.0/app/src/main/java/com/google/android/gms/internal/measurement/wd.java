package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class wd implements xd {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5663a;

    /* renamed from: b, reason: collision with root package name */
    private static final t2<Boolean> f5664b;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        y2Var.b("measurement.id.lifecycle.app_in_background_parameter", 0L);
        f5663a = y2Var.d("measurement.lifecycle.app_backgrounded_engagement", false);
        y2Var.d("measurement.lifecycle.app_backgrounded_tracking", true);
        f5664b = y2Var.d("measurement.lifecycle.app_in_background_parameter", false);
        y2Var.b("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.xd
    public final boolean a() {
        return f5664b.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.xd
    public final boolean zza() {
        return f5663a.o().booleanValue();
    }
}
