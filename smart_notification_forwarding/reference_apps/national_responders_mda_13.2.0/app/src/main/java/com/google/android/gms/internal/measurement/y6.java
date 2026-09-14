package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.l7;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class y6 {

    /* renamed from: b, reason: collision with root package name */
    private static volatile y6 f5716b;

    /* renamed from: c, reason: collision with root package name */
    private static volatile y6 f5717c;

    /* renamed from: d, reason: collision with root package name */
    private static final y6 f5718d = new y6(true);

    /* renamed from: a, reason: collision with root package name */
    private final Map<a, l7.f<?, ?>> f5719a;

    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Object f5720a;

        /* renamed from: b, reason: collision with root package name */
        private final int f5721b;

        a(Object obj, int i10) {
            this.f5720a = obj;
            this.f5721b = i10;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f5720a == aVar.f5720a && this.f5721b == aVar.f5721b;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.f5720a) * 65535) + this.f5721b;
        }
    }

    y6() {
        this.f5719a = new HashMap();
    }

    private y6(boolean z10) {
        this.f5719a = Collections.emptyMap();
    }

    public static y6 a() {
        y6 y6Var = f5716b;
        if (y6Var == null) {
            synchronized (y6.class) {
                y6Var = f5716b;
                if (y6Var == null) {
                    y6Var = f5718d;
                    f5716b = y6Var;
                }
            }
        }
        return y6Var;
    }

    public static y6 c() {
        y6 y6Var = f5717c;
        if (y6Var != null) {
            return y6Var;
        }
        synchronized (y6.class) {
            y6 y6Var2 = f5717c;
            if (y6Var2 != null) {
                return y6Var2;
            }
            y6 b10 = j7.b(y6.class);
            f5717c = b10;
            return b10;
        }
    }

    public final <ContainingType extends y8> l7.f<ContainingType, ?> b(ContainingType containingtype, int i10) {
        return (l7.f) this.f5719a.get(new a(containingtype, i10));
    }
}
