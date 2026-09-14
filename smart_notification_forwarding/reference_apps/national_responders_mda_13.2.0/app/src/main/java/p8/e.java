package p8;

import p8.f;
import y8.k;

/* loaded from: classes.dex */
public interface e extends f.b {

    /* renamed from: e, reason: collision with root package name */
    public static final b f13125e = b.f13126f;

    /* loaded from: classes.dex */
    public static final class a {
        public static <E extends f.b> E a(e eVar, f.c<E> cVar) {
            k.e(cVar, "key");
            if (!(cVar instanceof p8.b)) {
                if (e.f13125e != cVar) {
                    return null;
                }
                k.c(eVar, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return eVar;
            }
            p8.b bVar = (p8.b) cVar;
            if (!bVar.a(eVar.getKey())) {
                return null;
            }
            E e10 = (E) bVar.b(eVar);
            if (e10 instanceof f.b) {
                return e10;
            }
            return null;
        }

        public static f b(e eVar, f.c<?> cVar) {
            k.e(cVar, "key");
            if (!(cVar instanceof p8.b)) {
                return e.f13125e == cVar ? g.f13128f : eVar;
            }
            p8.b bVar = (p8.b) cVar;
            return (!bVar.a(eVar.getKey()) || bVar.b(eVar) == null) ? eVar : g.f13128f;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements f.c<e> {

        /* renamed from: f, reason: collision with root package name */
        static final /* synthetic */ b f13126f = new b();

        private b() {
        }
    }

    void O(d<?> dVar);

    <T> d<T> j(d<? super T> dVar);
}
