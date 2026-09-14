package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;

/* loaded from: classes.dex */
final class m7 implements v8 {

    /* renamed from: a, reason: collision with root package name */
    private static final m7 f5474a = new m7();

    private m7() {
    }

    public static m7 c() {
        return f5474a;
    }

    @Override // com.google.android.gms.internal.measurement.v8
    public final boolean a(Class<?> cls) {
        return l7.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.v8
    public final w8 b(Class<?> cls) {
        if (!l7.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (w8) l7.n(cls.asSubclass(l7.class)).q(l7.e.f5450c, null, null);
        } catch (Exception e10) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e10);
        }
    }
}
