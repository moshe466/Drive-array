package v9;

import v9.c0;

/* loaded from: classes.dex */
public final class f extends c0 {

    /* renamed from: m, reason: collision with root package name */
    public static final f f14781m = new f();

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.l<n9.b, Boolean> {
        a() {
            super(1);
        }

        public final boolean a(n9.b bVar) {
            y8.k.e(bVar, "it");
            return f.this.j(bVar);
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(n9.b bVar) {
            return Boolean.valueOf(a(bVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class b extends y8.l implements x8.l<n9.b, Boolean> {
        b() {
            super(1);
        }

        public final boolean a(n9.b bVar) {
            y8.k.e(bVar, "it");
            return (bVar instanceof n9.x) && f.this.j(bVar);
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(n9.b bVar) {
            return Boolean.valueOf(a(bVar));
        }
    }

    private f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(n9.b bVar) {
        boolean B;
        B = m8.y.B(c0.f14765a.d(), ea.t.d(bVar));
        return B;
    }

    public static final n9.x k(n9.x xVar) {
        y8.k.e(xVar, "functionDescriptor");
        f fVar = f14781m;
        la.e c10 = xVar.c();
        y8.k.d(c10, "functionDescriptor.name");
        if (fVar.l(c10)) {
            return (n9.x) ra.a.d(xVar, false, new a(), 1, null);
        }
        return null;
    }

    public static final c0.b m(n9.b bVar) {
        y8.k.e(bVar, "<this>");
        c0.a aVar = c0.f14765a;
        if (!aVar.c().contains(bVar.c())) {
            return null;
        }
        n9.b d10 = ra.a.d(bVar, false, new b(), 1, null);
        String d11 = d10 == null ? null : ea.t.d(d10);
        if (d11 == null) {
            return null;
        }
        return aVar.j(d11);
    }

    public final boolean l(la.e eVar) {
        y8.k.e(eVar, "<this>");
        return c0.f14765a.c().contains(eVar);
    }
}
