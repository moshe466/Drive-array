package p8;

import p8.e;
import x8.p;
import y8.k;
import y8.l;

/* loaded from: classes.dex */
public interface f {

    /* loaded from: classes.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: p8.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0272a extends l implements p<f, b, f> {

            /* renamed from: f, reason: collision with root package name */
            public static final C0272a f13127f = new C0272a();

            C0272a() {
                super(2);
            }

            @Override // x8.p
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final f g(f fVar, b bVar) {
                p8.c cVar;
                k.e(fVar, "acc");
                k.e(bVar, "element");
                f minusKey = fVar.minusKey(bVar.getKey());
                g gVar = g.f13128f;
                if (minusKey == gVar) {
                    return bVar;
                }
                e.b bVar2 = e.f13125e;
                e eVar = (e) minusKey.get(bVar2);
                if (eVar == null) {
                    cVar = new p8.c(minusKey, bVar);
                } else {
                    f minusKey2 = minusKey.minusKey(bVar2);
                    if (minusKey2 == gVar) {
                        return new p8.c(bVar, eVar);
                    }
                    cVar = new p8.c(new p8.c(minusKey2, bVar), eVar);
                }
                return cVar;
            }
        }

        public static f a(f fVar, f fVar2) {
            k.e(fVar2, "context");
            return fVar2 == g.f13128f ? fVar : (f) fVar2.fold(fVar, C0272a.f13127f);
        }
    }

    /* loaded from: classes.dex */
    public interface b extends f {

        /* loaded from: classes.dex */
        public static final class a {
            public static <R> R a(b bVar, R r10, p<? super R, ? super b, ? extends R> pVar) {
                k.e(pVar, "operation");
                return pVar.g(r10, bVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static <E extends b> E b(b bVar, c<E> cVar) {
                k.e(cVar, "key");
                if (!k.a(bVar.getKey(), cVar)) {
                    return null;
                }
                k.c(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static f c(b bVar, c<?> cVar) {
                k.e(cVar, "key");
                return k.a(bVar.getKey(), cVar) ? g.f13128f : bVar;
            }

            public static f d(b bVar, f fVar) {
                k.e(fVar, "context");
                return a.a(bVar, fVar);
            }
        }

        @Override // p8.f
        <E extends b> E get(c<E> cVar);

        c<?> getKey();
    }

    /* loaded from: classes.dex */
    public interface c<E extends b> {
    }

    <R> R fold(R r10, p<? super R, ? super b, ? extends R> pVar);

    <E extends b> E get(c<E> cVar);

    f minusKey(c<?> cVar);
}
