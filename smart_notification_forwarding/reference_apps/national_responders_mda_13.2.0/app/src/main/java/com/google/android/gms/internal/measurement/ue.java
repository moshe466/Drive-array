package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class ue implements qe {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5631a;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5631a = y2Var.d("measurement.service.ssaid_removal", true);
        y2Var.b("measurement.id.ssaid_removal", 0L);
    }

    @Override // com.google.android.gms.internal.measurement.qe
    public final boolean a() {
        return f5631a.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.qe
    public final boolean zza() {
        return true;
    }
}
