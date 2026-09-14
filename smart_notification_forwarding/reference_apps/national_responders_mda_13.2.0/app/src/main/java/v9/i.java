package v9;

import java.util.Collection;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f14789a = new i();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a extends y8.l implements x8.l<n9.b, Boolean> {
        a() {
            super(1);
        }

        public final boolean a(n9.b bVar) {
            y8.k.e(bVar, "it");
            return i.this.b(bVar);
        }

        @Override // x8.l
        public /* bridge */ /* synthetic */ Boolean h(n9.b bVar) {
            return Boolean.valueOf(a(bVar));
        }
    }

    private i() {
    }

    private final boolean c(n9.b bVar) {
        boolean B;
        B = m8.y.B(g.f14784a.c(), ra.a.e(bVar));
        if (B && bVar.l().isEmpty()) {
            return true;
        }
        if (!k9.h.e0(bVar)) {
            return false;
        }
        Collection<? extends n9.b> g10 = bVar.g();
        y8.k.d(g10, "overriddenDescriptors");
        if (!g10.isEmpty()) {
            for (n9.b bVar2 : g10) {
                y8.k.d(bVar2, "it");
                if (b(bVar2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String a(n9.b bVar) {
        la.e eVar;
        y8.k.e(bVar, "<this>");
        k9.h.e0(bVar);
        n9.b d10 = ra.a.d(ra.a.o(bVar), false, new a(), 1, null);
        if (d10 == null || (eVar = g.f14784a.a().get(ra.a.i(d10))) == null) {
            return null;
        }
        return eVar.k();
    }

    public final boolean b(n9.b bVar) {
        y8.k.e(bVar, "callableMemberDescriptor");
        if (g.f14784a.d().contains(bVar.c())) {
            return c(bVar);
        }
        return false;
    }
}
