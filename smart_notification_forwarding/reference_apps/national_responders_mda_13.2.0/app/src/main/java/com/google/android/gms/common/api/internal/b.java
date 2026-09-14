package com.google.android.gms.common.api.internal;

import a2.a;
import a2.a.d;

/* loaded from: classes.dex */
public final class b<O extends a.d> {

    /* renamed from: a, reason: collision with root package name */
    private final int f4781a;

    /* renamed from: b, reason: collision with root package name */
    private final a2.a f4782b;

    /* renamed from: c, reason: collision with root package name */
    private final a.d f4783c;

    /* renamed from: d, reason: collision with root package name */
    private final String f4784d;

    private b(a2.a aVar, a.d dVar, String str) {
        this.f4782b = aVar;
        this.f4783c = dVar;
        this.f4784d = str;
        this.f4781a = b2.o.b(aVar, dVar, str);
    }

    public static <O extends a.d> b<O> a(a2.a<O> aVar, O o10, String str) {
        return new b<>(aVar, o10, str);
    }

    public final String b() {
        return this.f4782b.d();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return b2.o.a(this.f4782b, bVar.f4782b) && b2.o.a(this.f4783c, bVar.f4783c) && b2.o.a(this.f4784d, bVar.f4784d);
    }

    public final int hashCode() {
        return this.f4781a;
    }
}
