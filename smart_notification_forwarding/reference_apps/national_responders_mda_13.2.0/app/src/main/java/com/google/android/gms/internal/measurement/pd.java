package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class pd implements qd {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5539a;

    /* renamed from: b, reason: collision with root package name */
    private static final t2<Boolean> f5540b;

    /* renamed from: c, reason: collision with root package name */
    private static final t2<Boolean> f5541c;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5539a = y2Var.d("measurement.client.global_params", true);
        f5540b = y2Var.d("measurement.service.global_params_in_payload", true);
        f5541c = y2Var.d("measurement.service.global_params", true);
        y2Var.b("measurement.id.service.global_params", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.qd
    public final boolean a() {
        return f5539a.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.qd
    public final boolean b() {
        return f5540b.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.qd
    public final boolean c() {
        return f5541c.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.qd
    public final boolean zza() {
        return true;
    }
}
