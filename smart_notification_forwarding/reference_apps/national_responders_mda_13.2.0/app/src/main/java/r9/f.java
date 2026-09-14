package r9;

import ea.o;
import mb.r;

/* loaded from: classes.dex */
public final class f implements o {

    /* renamed from: c, reason: collision with root package name */
    public static final a f13808c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final Class<?> f13809a;

    /* renamed from: b, reason: collision with root package name */
    private final fa.a f13810b;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }

        public final f a(Class<?> cls) {
            y8.k.e(cls, "klass");
            fa.b bVar = new fa.b();
            c.f13806a.b(cls, bVar);
            fa.a n10 = bVar.n();
            y8.g gVar = null;
            if (n10 == null) {
                return null;
            }
            return new f(cls, n10, gVar);
        }
    }

    private f(Class<?> cls, fa.a aVar) {
        this.f13809a = cls;
        this.f13810b = aVar;
    }

    public /* synthetic */ f(Class cls, fa.a aVar, y8.g gVar) {
        this(cls, aVar);
    }

    @Override // ea.o
    public fa.a a() {
        return this.f13810b;
    }

    @Override // ea.o
    public void b(o.c cVar, byte[] bArr) {
        y8.k.e(cVar, "visitor");
        c.f13806a.b(this.f13809a, cVar);
    }

    @Override // ea.o
    public void c(o.d dVar, byte[] bArr) {
        y8.k.e(dVar, "visitor");
        c.f13806a.i(this.f13809a, dVar);
    }

    @Override // ea.o
    public la.a d() {
        return s9.b.b(this.f13809a);
    }

    public final Class<?> e() {
        return this.f13809a;
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && y8.k.a(this.f13809a, ((f) obj).f13809a);
    }

    @Override // ea.o
    public String getLocation() {
        String t10;
        String name = this.f13809a.getName();
        y8.k.d(name, "klass.name");
        t10 = r.t(name, '.', '/', false, 4, null);
        return y8.k.j(t10, ".class");
    }

    public int hashCode() {
        return this.f13809a.hashCode();
    }

    public String toString() {
        return f.class.getName() + ": " + this.f13809a;
    }
}
