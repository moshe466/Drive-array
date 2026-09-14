package xa;

import n9.a;

/* loaded from: classes.dex */
public interface i {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15582a = a.f15583a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f15583a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final i f15584b = new C0333a();

        /* renamed from: xa.i$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0333a implements i {
            C0333a() {
            }

            @Override // xa.i
            public l8.n a(ga.i iVar, n9.x xVar, ia.g gVar, b0 b0Var) {
                y8.k.e(iVar, "proto");
                y8.k.e(xVar, "ownerFunction");
                y8.k.e(gVar, "typeTable");
                y8.k.e(b0Var, "typeDeserializer");
                return null;
            }
        }

        private a() {
        }

        public final i a() {
            return f15584b;
        }
    }

    l8.n<a.InterfaceC0257a<?>, Object> a(ga.i iVar, n9.x xVar, ia.g gVar, b0 b0Var);
}
