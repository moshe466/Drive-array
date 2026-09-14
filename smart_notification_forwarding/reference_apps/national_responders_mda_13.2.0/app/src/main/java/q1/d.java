package q1;

import s1.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private final h f13431a;

    /* renamed from: b, reason: collision with root package name */
    private final k1.m f13432b;

    private d(h hVar, k1.m mVar) {
        this.f13431a = hVar;
        this.f13432b = mVar;
    }

    public static b.a a(h hVar, k1.m mVar) {
        return new d(hVar, mVar);
    }

    @Override // s1.b.a
    public Object f() {
        Iterable w10;
        w10 = this.f13431a.f13444c.w(this.f13432b);
        return w10;
    }
}
