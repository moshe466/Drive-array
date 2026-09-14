package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class u8 implements r8 {
    @Override // com.google.android.gms.internal.measurement.r8
    public final Map<?, ?> a(Object obj) {
        return (s8) obj;
    }

    @Override // com.google.android.gms.internal.measurement.r8
    public final Object b(Object obj) {
        ((s8) obj).h();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.r8
    public final Object c(Object obj, Object obj2) {
        s8 s8Var = (s8) obj;
        s8 s8Var2 = (s8) obj2;
        if (!s8Var2.isEmpty()) {
            if (!s8Var.i()) {
                s8Var = s8Var.e();
            }
            s8Var.d(s8Var2);
        }
        return s8Var;
    }

    @Override // com.google.android.gms.internal.measurement.r8
    public final boolean d(Object obj) {
        return !((s8) obj).i();
    }

    @Override // com.google.android.gms.internal.measurement.r8
    public final Map<?, ?> e(Object obj) {
        return (s8) obj;
    }

    @Override // com.google.android.gms.internal.measurement.r8
    public final p8<?, ?> f(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.r8
    public final Object g(Object obj) {
        return s8.b().e();
    }

    @Override // com.google.android.gms.internal.measurement.r8
    public final int h(int i10, Object obj, Object obj2) {
        s8 s8Var = (s8) obj;
        if (s8Var.isEmpty()) {
            return 0;
        }
        Iterator it = s8Var.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
