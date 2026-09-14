package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.k1;
import com.google.android.gms.internal.measurement.nc;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class ba {

    /* renamed from: a, reason: collision with root package name */
    private String f5876a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f5877b;

    /* renamed from: c, reason: collision with root package name */
    private com.google.android.gms.internal.measurement.j1 f5878c;

    /* renamed from: d, reason: collision with root package name */
    private BitSet f5879d;

    /* renamed from: e, reason: collision with root package name */
    private BitSet f5880e;

    /* renamed from: f, reason: collision with root package name */
    private Map<Integer, Long> f5881f;

    /* renamed from: g, reason: collision with root package name */
    private Map<Integer, List<Long>> f5882g;

    /* renamed from: h, reason: collision with root package name */
    private final /* synthetic */ z9 f5883h;

    private ba(z9 z9Var, String str) {
        this.f5883h = z9Var;
        this.f5876a = str;
        this.f5877b = true;
        this.f5879d = new BitSet();
        this.f5880e = new BitSet();
        this.f5881f = new l.a();
        this.f5882g = new l.a();
    }

    private ba(z9 z9Var, String str, com.google.android.gms.internal.measurement.j1 j1Var, BitSet bitSet, BitSet bitSet2, Map<Integer, Long> map, Map<Integer, Long> map2) {
        this.f5883h = z9Var;
        this.f5876a = str;
        this.f5879d = bitSet;
        this.f5880e = bitSet2;
        this.f5881f = map;
        this.f5882g = new l.a();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(map2.get(num));
                this.f5882g.put(num, arrayList);
            }
        }
        this.f5877b = false;
        this.f5878c = j1Var;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(z9 z9Var, String str, com.google.android.gms.internal.measurement.j1 j1Var, BitSet bitSet, BitSet bitSet2, Map map, Map map2, y9 y9Var) {
        this(z9Var, str, j1Var, bitSet, bitSet2, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ba(z9 z9Var, String str, y9 y9Var) {
        this(z9Var, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ BitSet b(ba baVar) {
        return baVar.f5879d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.android.gms.internal.measurement.l7$b, com.google.android.gms.internal.measurement.b1$a] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r8v5, types: [com.google.android.gms.internal.measurement.j1$a] */
    public final com.google.android.gms.internal.measurement.b1 a(int i10) {
        ArrayList arrayList;
        ?? arrayList2;
        ?? S = com.google.android.gms.internal.measurement.b1.S();
        S.u(i10);
        S.y(this.f5877b);
        com.google.android.gms.internal.measurement.j1 j1Var = this.f5878c;
        if (j1Var != null) {
            S.x(j1Var);
        }
        ?? x10 = com.google.android.gms.internal.measurement.j1.b0().A(k9.H(this.f5879d)).x(k9.H(this.f5880e));
        if (this.f5881f == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList(this.f5881f.size());
            Iterator<Integer> it = this.f5881f.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                arrayList.add((com.google.android.gms.internal.measurement.c1) ((com.google.android.gms.internal.measurement.l7) com.google.android.gms.internal.measurement.c1.J().u(intValue).w(this.f5881f.get(Integer.valueOf(intValue)).longValue()).g()));
            }
        }
        x10.B(arrayList);
        if (this.f5882g == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList(this.f5882g.size());
            for (Integer num : this.f5882g.keySet()) {
                k1.a u10 = com.google.android.gms.internal.measurement.k1.K().u(num.intValue());
                List<Long> list = this.f5882g.get(num);
                if (list != null) {
                    Collections.sort(list);
                    u10.w(list);
                }
                arrayList2.add((com.google.android.gms.internal.measurement.k1) ((com.google.android.gms.internal.measurement.l7) u10.g()));
            }
        }
        x10.C(arrayList2);
        S.w(x10);
        return (com.google.android.gms.internal.measurement.b1) ((com.google.android.gms.internal.measurement.l7) S.g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(ca caVar) {
        int a10 = caVar.a();
        Boolean bool = caVar.f5915c;
        if (bool != null) {
            this.f5880e.set(a10, bool.booleanValue());
        }
        Boolean bool2 = caVar.f5916d;
        if (bool2 != null) {
            this.f5879d.set(a10, bool2.booleanValue());
        }
        if (caVar.f5917e != null) {
            Long l10 = this.f5881f.get(Integer.valueOf(a10));
            long longValue = caVar.f5917e.longValue() / 1000;
            if (l10 == null || longValue > l10.longValue()) {
                this.f5881f.put(Integer.valueOf(a10), Long.valueOf(longValue));
            }
        }
        if (caVar.f5918f != null) {
            List<Long> list = this.f5882g.get(Integer.valueOf(a10));
            if (list == null) {
                list = new ArrayList<>();
                this.f5882g.put(Integer.valueOf(a10), list);
            }
            if (caVar.i()) {
                list.clear();
            }
            if (nc.a() && this.f5883h.m().A(this.f5876a, s.f6397c0) && caVar.j()) {
                list.clear();
            }
            if (!nc.a() || !this.f5883h.m().A(this.f5876a, s.f6397c0)) {
                list.add(Long.valueOf(caVar.f5918f.longValue() / 1000));
                return;
            }
            long longValue2 = caVar.f5918f.longValue() / 1000;
            if (list.contains(Long.valueOf(longValue2))) {
                return;
            }
            list.add(Long.valueOf(longValue2));
        }
    }
}
