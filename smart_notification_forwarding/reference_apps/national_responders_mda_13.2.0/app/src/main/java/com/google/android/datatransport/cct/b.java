package com.google.android.datatransport.cct;

import com.google.android.datatransport.cct.d;

/* loaded from: classes.dex */
final /* synthetic */ class b implements o1.a {

    /* renamed from: a, reason: collision with root package name */
    private final d f4688a;

    private b(d dVar) {
        this.f4688a = dVar;
    }

    public static o1.a a(d dVar) {
        return new b(dVar);
    }

    @Override // o1.a
    public Object apply(Object obj) {
        d.b d10;
        d10 = this.f4688a.d((d.a) obj);
        return d10;
    }
}
