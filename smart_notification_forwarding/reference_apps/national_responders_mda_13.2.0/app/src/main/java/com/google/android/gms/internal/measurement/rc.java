package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class rc implements sc {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5576a;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5576a = y2Var.d("measurement.sdk.referrer.delayed_install_referrer_api", false);
        y2Var.b("measurement.id.sdk.referrer.delayed_install_referrer_api", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.sc
    public final boolean a() {
        return f5576a.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.sc
    public final boolean zza() {
        return true;
    }
}
