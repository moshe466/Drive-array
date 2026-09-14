package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class lb implements mb {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5465a;

    static {
        y2 y2Var = new y2(q2.a("com.google.android.gms.measurement"));
        f5465a = y2Var.d("measurement.androidId.delete_feature", true);
        y2Var.d("measurement.log_androidId_enabled", false);
    }

    @Override // com.google.android.gms.internal.measurement.mb
    public final boolean zza() {
        return f5465a.o().booleanValue();
    }
}
