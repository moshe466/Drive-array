package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class z9 extends b9 {

    /* renamed from: d, reason: collision with root package name */
    private String f6673d;

    /* renamed from: e, reason: collision with root package name */
    private Set<Integer> f6674e;

    /* renamed from: f, reason: collision with root package name */
    private Map<Integer, ba> f6675f;

    /* renamed from: g, reason: collision with root package name */
    private Long f6676g;

    /* renamed from: h, reason: collision with root package name */
    private Long f6677h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z9(e9 e9Var) {
        super(e9Var);
    }

    private final ba x(int i10) {
        if (this.f6675f.containsKey(Integer.valueOf(i10))) {
            return this.f6675f.get(Integer.valueOf(i10));
        }
        ba baVar = new ba(this, this.f6673d, null);
        this.f6675f.put(Integer.valueOf(i10), baVar);
        return baVar;
    }

    private final boolean z(int i10, int i11) {
        if (this.f6675f.get(Integer.valueOf(i10)) == null) {
            return false;
        }
        return ba.b(this.f6675f.get(Integer.valueOf(i10))).get(i11);
    }

    @Override // com.google.android.gms.measurement.internal.b9
    protected final boolean w() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02cf A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.google.android.gms.internal.measurement.b1> y(java.lang.String r47, java.util.List<com.google.android.gms.internal.measurement.d1> r48, java.util.List<com.google.android.gms.internal.measurement.l1> r49, java.lang.Long r50, java.lang.Long r51) {
        /*
            Method dump skipped, instructions count: 1775
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.z9.y(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }
}
