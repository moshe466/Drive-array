package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class d9<T> implements p9<T> {

    /* renamed from: a, reason: collision with root package name */
    private final y8 f5262a;

    /* renamed from: b, reason: collision with root package name */
    private final ha<?, ?> f5263b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f5264c;

    /* renamed from: d, reason: collision with root package name */
    private final a7<?> f5265d;

    private d9(ha<?, ?> haVar, a7<?> a7Var, y8 y8Var) {
        this.f5263b = haVar;
        this.f5264c = a7Var.e(y8Var);
        this.f5265d = a7Var;
        this.f5262a = y8Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> d9<T> i(ha<?, ?> haVar, a7<?> a7Var, y8 y8Var) {
        return new d9<>(haVar, a7Var, y8Var);
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final int a(T t10) {
        int hashCode = this.f5263b.f(t10).hashCode();
        return this.f5264c ? (hashCode * 53) + this.f5265d.b(t10).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final boolean b(T t10) {
        return this.f5265d.b(t10).q();
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final boolean c(T t10, T t11) {
        if (!this.f5263b.f(t10).equals(this.f5263b.f(t11))) {
            return false;
        }
        if (this.f5264c) {
            return this.f5265d.b(t10).equals(this.f5265d.b(t11));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final void d(T t10) {
        this.f5263b.j(t10);
        this.f5265d.g(t10);
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final int e(T t10) {
        ha<?, ?> haVar = this.f5263b;
        int k10 = haVar.k(haVar.f(t10)) + 0;
        return this.f5264c ? k10 + this.f5265d.b(t10).r() : k10;
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final void f(T t10, bb bbVar) {
        Iterator<Map.Entry<?, Object>> o10 = this.f5265d.b(t10).o();
        while (o10.hasNext()) {
            Map.Entry<?, Object> next = o10.next();
            g7 g7Var = (g7) next.getKey();
            if (g7Var.b() != cb.MESSAGE || g7Var.c() || g7Var.d()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            bbVar.q(g7Var.zza(), next instanceof a8 ? ((a8) next).a().d() : next.getValue());
        }
        ha<?, ?> haVar = this.f5263b;
        haVar.g(haVar.f(t10), bbVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0099 A[EDGE_INSN: B:24:0x0099->B:25:0x0099 BREAK  A[LOOP:1: B:10:0x0053->B:18:0x0053], SYNTHETIC] */
    @Override // com.google.android.gms.internal.measurement.p9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(T r10, byte[] r11, int r12, int r13, com.google.android.gms.internal.measurement.c6 r14) {
        /*
            r9 = this;
            r0 = r10
            com.google.android.gms.internal.measurement.l7 r0 = (com.google.android.gms.internal.measurement.l7) r0
            com.google.android.gms.internal.measurement.ga r1 = r0.zzb
            com.google.android.gms.internal.measurement.ga r2 = com.google.android.gms.internal.measurement.ga.a()
            if (r1 != r2) goto L11
            com.google.android.gms.internal.measurement.ga r1 = com.google.android.gms.internal.measurement.ga.g()
            r0.zzb = r1
        L11:
            com.google.android.gms.internal.measurement.l7$d r10 = (com.google.android.gms.internal.measurement.l7.d) r10
            r10.A()
            r10 = 0
            r0 = r10
        L18:
            if (r12 >= r13) goto La4
            int r4 = com.google.android.gms.internal.measurement.z5.i(r11, r12, r14)
            int r2 = r14.f5233a
            r12 = 11
            r3 = 2
            if (r2 == r12) goto L51
            r12 = r2 & 7
            if (r12 != r3) goto L4c
            com.google.android.gms.internal.measurement.a7<?> r12 = r9.f5265d
            com.google.android.gms.internal.measurement.y6 r0 = r14.f5236d
            com.google.android.gms.internal.measurement.y8 r3 = r9.f5262a
            int r5 = r2 >>> 3
            java.lang.Object r12 = r12.c(r0, r3, r5)
            r0 = r12
            com.google.android.gms.internal.measurement.l7$f r0 = (com.google.android.gms.internal.measurement.l7.f) r0
            if (r0 != 0) goto L43
            r3 = r11
            r5 = r13
            r6 = r1
            r7 = r14
            int r12 = com.google.android.gms.internal.measurement.z5.c(r2, r3, r4, r5, r6, r7)
            goto L18
        L43:
            com.google.android.gms.internal.measurement.l9.a()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L4c:
            int r12 = com.google.android.gms.internal.measurement.z5.a(r2, r11, r4, r13, r14)
            goto L18
        L51:
            r12 = 0
            r2 = r10
        L53:
            if (r4 >= r13) goto L99
            int r4 = com.google.android.gms.internal.measurement.z5.i(r11, r4, r14)
            int r5 = r14.f5233a
            int r6 = r5 >>> 3
            r7 = r5 & 7
            if (r6 == r3) goto L7b
            r8 = 3
            if (r6 == r8) goto L65
            goto L90
        L65:
            if (r0 != 0) goto L72
            if (r7 != r3) goto L90
            int r4 = com.google.android.gms.internal.measurement.z5.q(r11, r4, r14)
            java.lang.Object r2 = r14.f5235c
            com.google.android.gms.internal.measurement.d6 r2 = (com.google.android.gms.internal.measurement.d6) r2
            goto L53
        L72:
            com.google.android.gms.internal.measurement.l9.a()
            java.lang.NoSuchMethodError r10 = new java.lang.NoSuchMethodError
            r10.<init>()
            throw r10
        L7b:
            if (r7 != 0) goto L90
            int r4 = com.google.android.gms.internal.measurement.z5.i(r11, r4, r14)
            int r12 = r14.f5233a
            com.google.android.gms.internal.measurement.a7<?> r0 = r9.f5265d
            com.google.android.gms.internal.measurement.y6 r5 = r14.f5236d
            com.google.android.gms.internal.measurement.y8 r6 = r9.f5262a
            java.lang.Object r0 = r0.c(r5, r6, r12)
            com.google.android.gms.internal.measurement.l7$f r0 = (com.google.android.gms.internal.measurement.l7.f) r0
            goto L53
        L90:
            r6 = 12
            if (r5 == r6) goto L99
            int r4 = com.google.android.gms.internal.measurement.z5.a(r5, r11, r4, r13, r14)
            goto L53
        L99:
            if (r2 == 0) goto La1
            int r12 = r12 << 3
            r12 = r12 | r3
            r1.c(r12, r2)
        La1:
            r12 = r4
            goto L18
        La4:
            if (r12 != r13) goto La7
            return
        La7:
            com.google.android.gms.internal.measurement.x7 r10 = com.google.android.gms.internal.measurement.x7.e()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.d9.g(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.c6):void");
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final void h(T t10, T t11) {
        r9.o(this.f5263b, t10, t11);
        if (this.f5264c) {
            r9.m(this.f5265d, t10, t11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.p9
    public final T zza() {
        return (T) this.f5262a.e().j();
    }
}
