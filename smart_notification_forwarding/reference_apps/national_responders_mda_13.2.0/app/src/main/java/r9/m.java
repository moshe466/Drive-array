package r9;

import n9.w0;

/* loaded from: classes.dex */
public final class m implements ba.b {

    /* renamed from: a, reason: collision with root package name */
    public static final m f13818a = new m();

    /* loaded from: classes.dex */
    public static final class a implements ba.a {

        /* renamed from: b, reason: collision with root package name */
        private final s9.n f13819b;

        public a(s9.n nVar) {
            y8.k.e(nVar, "javaElement");
            this.f13819b = nVar;
        }

        @Override // n9.v0
        public w0 a() {
            w0 w0Var = w0.f12327a;
            y8.k.d(w0Var, "NO_SOURCE_FILE");
            return w0Var;
        }

        @Override // ba.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public s9.n b() {
            return this.f13819b;
        }

        public String toString() {
            return a.class.getName() + ": " + b();
        }
    }

    private m() {
    }

    @Override // ba.b
    public ba.a a(ca.l lVar) {
        y8.k.e(lVar, "javaElement");
        return new a((s9.n) lVar);
    }
}
