package com.google.android.gms.internal.measurement;

/* loaded from: classes.dex */
public final class bf implements cf {

    /* renamed from: a, reason: collision with root package name */
    private static final t2<Boolean> f5220a = new y2(q2.a("com.google.android.gms.measurement")).d("measurement.integration.disable_firebase_instance_id", false);

    @Override // com.google.android.gms.internal.measurement.cf
    public final boolean a() {
        return f5220a.o().booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.cf
    public final boolean zza() {
        return true;
    }
}
