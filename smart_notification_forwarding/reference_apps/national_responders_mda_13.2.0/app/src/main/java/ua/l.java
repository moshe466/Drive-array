package ua;

import java.util.List;
import kotlin.reflect.KProperty;
import m8.q;
import n9.u0;
import y8.t;
import y8.w;

/* loaded from: classes.dex */
public final class l extends i {

    /* renamed from: d, reason: collision with root package name */
    static final /* synthetic */ KProperty<Object>[] f14542d = {w.g(new t(w.b(l.class), "functions", "getFunctions()Ljava/util/List;"))};

    /* renamed from: b, reason: collision with root package name */
    private final n9.e f14543b;

    /* renamed from: c, reason: collision with root package name */
    private final ab.i f14544c;

    /* loaded from: classes.dex */
    static final class a extends y8.l implements x8.a<List<? extends u0>> {
        a() {
            super(0);
        }

        @Override // x8.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final List<u0> b() {
            List<u0> g10;
            g10 = q.g(na.c.d(l.this.f14543b), na.c.e(l.this.f14543b));
            return g10;
        }
    }

    public l(ab.n nVar, n9.e eVar) {
        y8.k.e(nVar, "storageManager");
        y8.k.e(eVar, "containingClass");
        this.f14543b = eVar;
        eVar.r();
        n9.f fVar = n9.f.ENUM_CLASS;
        this.f14544c = nVar.a(new a());
    }

    private final List<u0> l() {
        return (List) ab.m.a(this.f14544c, this, f14542d[0]);
    }

    @Override // ua.i, ua.k
    public /* bridge */ /* synthetic */ n9.h g(la.e eVar, u9.b bVar) {
        return (n9.h) i(eVar, bVar);
    }

    public Void i(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        return null;
    }

    @Override // ua.i, ua.k
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public List<u0> e(d dVar, x8.l<? super la.e, Boolean> lVar) {
        y8.k.e(dVar, "kindFilter");
        y8.k.e(lVar, "nameFilter");
        return l();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ua.i, ua.h
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public jb.i<u0> b(la.e eVar, u9.b bVar) {
        y8.k.e(eVar, "name");
        y8.k.e(bVar, "location");
        List<u0> l10 = l();
        jb.i<u0> iVar = new jb.i<>();
        for (Object obj : l10) {
            if (y8.k.a(((u0) obj).c(), eVar)) {
                iVar.add(obj);
            }
        }
        return iVar;
    }
}
