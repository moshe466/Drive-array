package p1;

import k1.m;
import s1.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class b implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private final c f13019a;

    /* renamed from: b, reason: collision with root package name */
    private final m f13020b;

    /* renamed from: c, reason: collision with root package name */
    private final k1.h f13021c;

    private b(c cVar, m mVar, k1.h hVar) {
        this.f13019a = cVar;
        this.f13020b = mVar;
        this.f13021c = hVar;
    }

    public static b.a a(c cVar, m mVar, k1.h hVar) {
        return new b(cVar, mVar, hVar);
    }

    @Override // s1.b.a
    public Object f() {
        return c.b(this.f13019a, this.f13020b, this.f13021c);
    }
}
