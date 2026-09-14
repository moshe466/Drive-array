package q1;

import s1.b;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class f implements b.a {

    /* renamed from: a, reason: collision with root package name */
    private final r1.c f13438a;

    private f(r1.c cVar) {
        this.f13438a = cVar;
    }

    public static b.a a(r1.c cVar) {
        return new f(cVar);
    }

    @Override // s1.b.a
    public Object f() {
        return Integer.valueOf(this.f13438a.i());
    }
}
