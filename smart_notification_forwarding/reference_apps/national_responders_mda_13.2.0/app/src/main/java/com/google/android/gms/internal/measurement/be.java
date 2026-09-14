package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class be implements yd {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5218a;

    /* renamed from: b, reason: collision with root package name */
    private static final t2<Boolean> f5219b;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5218a = y2Var.d("measurement.sdk.screen.manual_screen_view_logging", true);
        f5219b = y2Var.d("measurement.sdk.screen.disabling_automatic_reporting", true);
    }

    @Override // com.google.android.gms.internal.measurement.yd
    public final boolean a() {
        return f5218a.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.yd
    public final boolean b() {
        return f5219b.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.yd
    public final boolean zza() {
        return true;
    }
}
