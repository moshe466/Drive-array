package q1;

import s1.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class g implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private final h f13439a;

    /* renamed from: b, reason: collision with root package name */
    private final k1.m f13440b;

    /* renamed from: c, reason: collision with root package name */
    private final int f13441c;

    private g(h hVar, k1.m mVar, int i10) {
        this.f13439a = hVar;
        this.f13440b = mVar;
        this.f13441c = i10;
    }

    public static b.a a(h hVar, k1.m mVar, int i10) {
        return new g(hVar, mVar, i10);
    }

    @Override // s1.b.a
    public Object f() {
        return h.d(this.f13439a, this.f13440b, this.f13441c);
    }
}
