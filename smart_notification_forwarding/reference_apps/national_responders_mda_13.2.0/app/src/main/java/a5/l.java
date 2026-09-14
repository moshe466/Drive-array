package a5;

import com.google.gson.r;
import com.google.gson.s;
import com.google.gson.x;
import com.google.gson.y;

/* loaded from: classes.dex */
public final class l<T> extends x<T> {

    /* renamed from: a, reason: collision with root package name */
    private final s<T> f245a;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.gson.j<T> f246b;

    /* renamed from: c, reason: collision with root package name */
    final com.google.gson.e f247c;

    /* renamed from: d, reason: collision with root package name */
    private final e5.a<T> f248d;

    /* renamed from: e, reason: collision with root package name */
    private final y f249e;

    /* renamed from: f, reason: collision with root package name */
    private final l<T>.b f250f = new b();

    /* renamed from: g, reason: collision with root package name */
    private x<T> f251g;

    /* loaded from: classes.dex */
    private final class b implements r, com.google.gson.i {
        private b(l lVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class c implements y {

        /* renamed from: f, reason: collision with root package name */
        private final e5.a<?> f252f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f253g;

        /* renamed from: h, reason: collision with root package name */
        private final Class<?> f254h;

        /* renamed from: i, reason: collision with root package name */
        private final s<?> f255i;

        /* renamed from: j, reason: collision with root package name */
        private final com.google.gson.j<?> f256j;

        c(Object obj, e5.a<?> aVar, boolean z10, Class<?> cls) {
            s<?> sVar = obj instanceof s ? (s) obj : null;
            this.f255i = sVar;
            com.google.gson.j<?> jVar = obj instanceof com.google.gson.j ? (com.google.gson.j) obj : null;
            this.f256j = jVar;
            z4.a.a((sVar == null && jVar == null) ? false : true);
            this.f252f = aVar;
            this.f253g = z10;
            this.f254h = cls;
        }

        @Override // com.google.gson.y
        public <T> x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
            e5.a<?> aVar2 = this.f252f;
            if (aVar2 != null ? aVar2.equals(aVar) || (this.f253g && this.f252f.e() == aVar.c()) : this.f254h.isAssignableFrom(aVar.c())) {
                return new l(this.f255i, this.f256j, eVar, aVar, this);
            }
            return null;
        }
    }

    public l(s<T> sVar, com.google.gson.j<T> jVar, com.google.gson.e eVar, e5.a<T> aVar, y yVar) {
        this.f245a = sVar;
        this.f246b = jVar;
        this.f247c = eVar;
        this.f248d = aVar;
        this.f249e = yVar;
    }

    private x<T> e() {
        x<T> xVar = this.f251g;
        if (xVar != null) {
            return xVar;
        }
        x<T> m10 = this.f247c.m(this.f249e, this.f248d);
        this.f251g = m10;
        return m10;
    }

    public static y f(e5.a<?> aVar, Object obj) {
        return new c(obj, aVar, aVar.e() == aVar.c(), null);
    }

    @Override // com.google.gson.x
    public T b(f5.a aVar) {
        if (this.f246b == null) {
            return e().b(aVar);
        }
        com.google.gson.k a10 = z4.l.a(aVar);
        if (a10.u()) {
            return null;
        }
        return this.f246b.a(a10, this.f248d.e(), this.f250f);
    }

    @Override // com.google.gson.x
    public void d(f5.c cVar, T t10) {
        s<T> sVar = this.f245a;
        if (sVar == null) {
            e().d(cVar, t10);
        } else if (t10 == null) {
            cVar.b0();
        } else {
            z4.l.b(sVar.a(t10, this.f248d.e(), this.f250f), cVar);
        }
    }
}
