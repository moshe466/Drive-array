package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.g7;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e7<T extends g7<T>> {

    /* renamed from: d, reason: collision with root package name */
    private static final e7 f5286d = new e7(true);

    /* renamed from: a, reason: collision with root package name */
    final q9<T, Object> f5287a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5288b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f5289c;

    private e7() {
        this.f5287a = q9.b(16);
    }

    private e7(q9<T, Object> q9Var) {
        this.f5287a = q9Var;
        j();
    }

    private e7(boolean z10) {
        this(q9.b(0));
        j();
    }

    public static int a(g7<?> g7Var, Object obj) {
        va a10 = g7Var.a();
        int zza = g7Var.zza();
        if (!g7Var.c()) {
            return b(a10, zza, obj);
        }
        int i10 = 0;
        List list = (List) obj;
        if (g7Var.d()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                i10 += i(a10, it.next());
            }
            return v6.g0(zza) + i10 + v6.D0(i10);
        }
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            i10 += b(a10, zza, it2.next());
        }
        return i10;
    }

    static int b(va vaVar, int i10, Object obj) {
        int g02 = v6.g0(i10);
        if (vaVar == va.zzj) {
            o7.g((y8) obj);
            g02 <<= 1;
        }
        return g02 + i(vaVar, obj);
    }

    public static <T extends g7<T>> e7<T> c() {
        return f5286d;
    }

    private final Object d(T t10) {
        Object obj = this.f5287a.get(t10);
        if (!(obj instanceof y7)) {
            return obj;
        }
        return y7.e();
    }

    private static Object e(Object obj) {
        if (obj instanceof c9) {
            return ((c9) obj).clone();
        }
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001c, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.measurement.y7) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0025, code lost:
    
        if ((r3 instanceof com.google.android.gms.internal.measurement.r7) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002e, code lost:
    
        if ((r3 instanceof byte[]) == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static void g(com.google.android.gms.internal.measurement.va r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.measurement.o7.d(r3)
            int[] r0 = com.google.android.gms.internal.measurement.d7.f5259a
            com.google.android.gms.internal.measurement.cb r2 = r2.zza()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L31;
                case 7: goto L28;
                case 8: goto L1f;
                case 9: goto L16;
                default: goto L14;
            }
        L14:
            r0 = 0
            goto L42
        L16:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.y8
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.y7
            if (r2 == 0) goto L14
            goto L42
        L1f:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.r7
            if (r2 == 0) goto L14
            goto L42
        L28:
            boolean r2 = r3 instanceof com.google.android.gms.internal.measurement.d6
            if (r2 != 0) goto L42
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L14
            goto L42
        L31:
            boolean r0 = r3 instanceof java.lang.String
            goto L42
        L34:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L42
        L37:
            boolean r0 = r3 instanceof java.lang.Double
            goto L42
        L3a:
            boolean r0 = r3 instanceof java.lang.Float
            goto L42
        L3d:
            boolean r0 = r3 instanceof java.lang.Long
            goto L42
        L40:
            boolean r0 = r3 instanceof java.lang.Integer
        L42:
            if (r0 == 0) goto L45
            return
        L45:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.e7.g(com.google.android.gms.internal.measurement.va, java.lang.Object):void");
    }

    private static <T extends g7<T>> boolean h(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        if (key.b() == cb.MESSAGE) {
            boolean c10 = key.c();
            Object value = entry.getValue();
            if (c10) {
                Iterator it = ((List) value).iterator();
                while (it.hasNext()) {
                    if (!((y8) it.next()).i()) {
                        return false;
                    }
                }
            } else {
                if (!(value instanceof y8)) {
                    if (value instanceof y7) {
                        return true;
                    }
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
                if (!((y8) value).i()) {
                    return false;
                }
            }
        }
        return true;
    }

    private static int i(va vaVar, Object obj) {
        switch (d7.f5260b[vaVar.ordinal()]) {
            case 1:
                return v6.z(((Double) obj).doubleValue());
            case 2:
                return v6.A(((Float) obj).floatValue());
            case 3:
                return v6.d0(((Long) obj).longValue());
            case 4:
                return v6.i0(((Long) obj).longValue());
            case 5:
                return v6.k0(((Integer) obj).intValue());
            case 6:
                return v6.r0(((Long) obj).longValue());
            case 7:
                return v6.w0(((Integer) obj).intValue());
            case 8:
                return v6.L(((Boolean) obj).booleanValue());
            case 9:
                return v6.V((y8) obj);
            case 10:
                return obj instanceof y7 ? v6.d((y7) obj) : v6.J((y8) obj);
            case 11:
                return obj instanceof d6 ? v6.I((d6) obj) : v6.K((String) obj);
            case 12:
                return obj instanceof d6 ? v6.I((d6) obj) : v6.M((byte[]) obj);
            case 13:
                return v6.o0(((Integer) obj).intValue());
            case 14:
                return v6.z0(((Integer) obj).intValue());
            case 15:
                return v6.v0(((Long) obj).longValue());
            case 16:
                return v6.s0(((Integer) obj).intValue());
            case 17:
                return v6.n0(((Long) obj).longValue());
            case 18:
                return obj instanceof r7 ? v6.B0(((r7) obj).zza()) : v6.B0(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    private final void k(T t10, Object obj) {
        if (!t10.c()) {
            g(t10.a(), obj);
        } else {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            int i10 = 0;
            while (i10 < size) {
                Object obj2 = arrayList.get(i10);
                i10++;
                g(t10.a(), obj2);
            }
            obj = arrayList;
        }
        if (obj instanceof y7) {
            this.f5289c = true;
        }
        this.f5287a.put(t10, obj);
    }

    private final void l(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof y7) {
            value = y7.e();
        }
        if (key.c()) {
            Object d10 = d(key);
            if (d10 == null) {
                d10 = new ArrayList();
            }
            Iterator it = ((List) value).iterator();
            while (it.hasNext()) {
                ((List) d10).add(e(it.next()));
            }
            this.f5287a.put(key, d10);
            return;
        }
        if (key.b() != cb.MESSAGE) {
            this.f5287a.put(key, e(value));
            return;
        }
        Object d11 = d(key);
        if (d11 == null) {
            this.f5287a.put(key, e(value));
        } else {
            this.f5287a.put(key, d11 instanceof c9 ? key.m((c9) d11, (c9) value) : key.i(((y8) d11).d(), (y8) value).g());
        }
    }

    private static int m(Map.Entry<T, Object> entry) {
        T key = entry.getKey();
        Object value = entry.getValue();
        if (key.b() != cb.MESSAGE || key.c() || key.d()) {
            return a(key, value);
        }
        boolean z10 = value instanceof y7;
        int zza = entry.getKey().zza();
        return z10 ? v6.D(zza, (y7) value) : v6.E(zza, (y8) value);
    }

    public final /* synthetic */ Object clone() {
        e7 e7Var = new e7();
        for (int i10 = 0; i10 < this.f5287a.j(); i10++) {
            Map.Entry<T, Object> h10 = this.f5287a.h(i10);
            e7Var.k(h10.getKey(), h10.getValue());
        }
        for (Map.Entry<T, Object> entry : this.f5287a.n()) {
            e7Var.k(entry.getKey(), entry.getValue());
        }
        e7Var.f5289c = this.f5289c;
        return e7Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e7) {
            return this.f5287a.equals(((e7) obj).f5287a);
        }
        return false;
    }

    public final void f(e7<T> e7Var) {
        for (int i10 = 0; i10 < e7Var.f5287a.j(); i10++) {
            l(e7Var.f5287a.h(i10));
        }
        Iterator<Map.Entry<T, Object>> it = e7Var.f5287a.n().iterator();
        while (it.hasNext()) {
            l(it.next());
        }
    }

    public final int hashCode() {
        return this.f5287a.hashCode();
    }

    public final void j() {
        if (this.f5288b) {
            return;
        }
        this.f5287a.e();
        this.f5288b = true;
    }

    public final boolean n() {
        return this.f5288b;
    }

    public final Iterator<Map.Entry<T, Object>> o() {
        return this.f5289c ? new d8(this.f5287a.entrySet().iterator()) : this.f5287a.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> p() {
        return this.f5289c ? new d8(this.f5287a.p().iterator()) : this.f5287a.p().iterator();
    }

    public final boolean q() {
        for (int i10 = 0; i10 < this.f5287a.j(); i10++) {
            if (!h(this.f5287a.h(i10))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.f5287a.n().iterator();
        while (it.hasNext()) {
            if (!h(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int r() {
        int i10 = 0;
        for (int i11 = 0; i11 < this.f5287a.j(); i11++) {
            i10 += m(this.f5287a.h(i11));
        }
        Iterator<Map.Entry<T, Object>> it = this.f5287a.n().iterator();
        while (it.hasNext()) {
            i10 += m(it.next());
        }
        return i10;
    }
}
