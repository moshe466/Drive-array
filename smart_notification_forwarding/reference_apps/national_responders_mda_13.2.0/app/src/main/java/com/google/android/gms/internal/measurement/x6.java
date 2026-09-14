package com.google.android.gms.internal.measurement;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class x6 implements bb {

    /* renamed from: a, reason: collision with root package name */
    private final v6 f5669a;

    private x6(v6 v6Var) {
        v6 v6Var2 = (v6) o7.f(v6Var, "output");
        this.f5669a = v6Var2;
        v6Var2.f5638a = this;
    }

    public static x6 O(v6 v6Var) {
        x6 x6Var = v6Var.f5638a;
        return x6Var != null ? x6Var : new x6(v6Var);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void A(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.j0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.w0(list.get(i13).intValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.e0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void B(int i10, List<Float> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.l(i10, list.get(i11).floatValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.A(list.get(i13).floatValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.i(list.get(i11).floatValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void C(int i10, String str) {
        this.f5669a.r(i10, str);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void D(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.X(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.o0(list.get(i13).intValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.O(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final <K, V> void E(int i10, p8<K, V> p8Var, Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.f5669a.m(i10, 2);
            this.f5669a.O(q8.a(p8Var, entry.getKey(), entry.getValue()));
            q8.b(this.f5669a, p8Var, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void F(int i10, int i11) {
        this.f5669a.X(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void G(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.j0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.z0(list.get(i13).intValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.e0(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void H(int i10, long j10) {
        this.f5669a.Q(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void I(int i10, List<?> list, p9 p9Var) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            y(i10, list.get(i11), p9Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void J(int i10, List<String> list) {
        int i11 = 0;
        if (!(list instanceof e8)) {
            while (i11 < list.size()) {
                this.f5669a.r(i10, list.get(i11));
                i11++;
            }
            return;
        }
        e8 e8Var = (e8) list;
        while (i11 < list.size()) {
            Object d10 = e8Var.d(i11);
            if (d10 instanceof String) {
                this.f5669a.r(i10, (String) d10);
            } else {
                this.f5669a.o(i10, (d6) d10);
            }
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void K(int i10, int i11) {
        this.f5669a.j0(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void L(int i10, long j10) {
        this.f5669a.n(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void M(int i10, double d10) {
        this.f5669a.k(i10, d10);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void N(int i10, float f10) {
        this.f5669a.l(i10, f10);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void a(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.Y(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.r0(list.get(i13).longValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.Z(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void b(int i10) {
        this.f5669a.m(i10, 3);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void c(int i10, boolean z10) {
        this.f5669a.s(i10, z10);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void d(int i10) {
        this.f5669a.m(i10, 4);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void e(int i10, List<Boolean> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.s(i10, list.get(i11).booleanValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.L(list.get(i13).booleanValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.y(list.get(i11).booleanValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void f(int i10, List<?> list, p9 p9Var) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            s(i10, list.get(i11), p9Var);
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void g(int i10, int i11) {
        this.f5669a.f0(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void h(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.Q(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.n0(list.get(i13).longValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.S(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void i(int i10, long j10) {
        this.f5669a.Y(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void j(int i10, int i11) {
        this.f5669a.P(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void k(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.P(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.k0(list.get(i13).intValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.j(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void l(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.n(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.i0(list.get(i13).longValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.t(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void m(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.P(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.B0(list.get(i13).intValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.j(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void n(int i10, List<Integer> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.f0(i10, list.get(i11).intValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.s0(list.get(i13).intValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.W(list.get(i11).intValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void o(int i10, int i11) {
        this.f5669a.P(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void p(int i10, long j10) {
        this.f5669a.n(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void q(int i10, Object obj) {
        if (obj instanceof d6) {
            this.f5669a.R(i10, (d6) obj);
        } else {
            this.f5669a.p(i10, (y8) obj);
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void r(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.n(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.d0(list.get(i13).longValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.t(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void s(int i10, Object obj, p9 p9Var) {
        this.f5669a.q(i10, (y8) obj, p9Var);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void t(int i10, List<Double> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.k(i10, list.get(i11).doubleValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.z(list.get(i13).doubleValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.h(list.get(i11).doubleValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void u(int i10, List<d6> list) {
        for (int i11 = 0; i11 < list.size(); i11++) {
            this.f5669a.o(i10, list.get(i11));
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void v(int i10, int i11) {
        this.f5669a.j0(i10, i11);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void w(int i10, List<Long> list, boolean z10) {
        int i11 = 0;
        if (!z10) {
            while (i11 < list.size()) {
                this.f5669a.Y(i10, list.get(i11).longValue());
                i11++;
            }
            return;
        }
        this.f5669a.m(i10, 2);
        int i12 = 0;
        for (int i13 = 0; i13 < list.size(); i13++) {
            i12 += v6.v0(list.get(i13).longValue());
        }
        this.f5669a.O(i12);
        while (i11 < list.size()) {
            this.f5669a.Z(list.get(i11).longValue());
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void x(int i10, d6 d6Var) {
        this.f5669a.o(i10, d6Var);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void y(int i10, Object obj, p9 p9Var) {
        v6 v6Var = this.f5669a;
        v6Var.m(i10, 3);
        p9Var.f((y8) obj, v6Var.f5638a);
        v6Var.m(i10, 4);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final void z(int i10, long j10) {
        this.f5669a.Y(i10, j10);
    }

    @Override // com.google.android.gms.internal.measurement.bb
    public final int zza() {
        return eb.f5290a;
    }
}
