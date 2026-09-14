package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class yb implements zb {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5726a;

    /* renamed from: b, reason: collision with root package name */
    private static final t2<Boolean> f5727b;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5726a = y2Var.d("measurement.service.configurable_service_limits", true);
        f5727b = y2Var.d("measurement.client.configurable_service_limits", true);
        y2Var.b("measurement.id.service.configurable_service_limits", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.zb
    public final boolean a() {
        return f5726a.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zb
    public final boolean b() {
        return f5727b.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.zb
    public final boolean zza() {
        return true;
    }
}
