package nb;

import p8.e;
import p8.f;

/* loaded from: classes.dex */
public abstract class u extends p8.a implements p8.e {

    /* renamed from: f, reason: collision with root package name */
    public static final a f12429f = new a(null);

    /* loaded from: classes.dex */
    public static final class a extends p8.b<p8.e, u> {

        /* renamed from: nb.u$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        static final class C0260a extends y8.l implements x8.l<f.b, u> {

            /* renamed from: f, reason: collision with root package name */
            public static final C0260a f12430f = new C0260a();

            C0260a() {
                super(1);
            }

            @Override // x8.l
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final u h(f.b bVar) {
                if (bVar instanceof u) {
                    return (u) bVar;
                }
                return null;
            }
        }

        private a() {
            super(p8.e.f13125e, C0260a.f12430f);
        }

        public /* synthetic */ a(y8.g gVar) {
            this();
        }
    }

    public u() {
        super(p8.e.f13125e);
    }

    @Override // p8.e
    public final void O(p8.d<?> dVar) {
        ((kotlinx.coroutines.internal.f) dVar).n();
    }

    public boolean a0(p8.f fVar) {
        return true;
    }

    public u b0(int i10) {
        kotlinx.coroutines.internal.l.a(i10);
        return new kotlinx.coroutines.internal.k(this, i10);
    }

    public abstract void c(p8.f fVar, Runnable runnable);

    @Override // p8.a, p8.f.b, p8.f
    public <E extends f.b> E get(f.c<E> cVar) {
        return (E) e.a.a(this, cVar);
    }

    @Override // p8.e
    public final <T> p8.d<T> j(p8.d<? super T> dVar) {
        return new kotlinx.coroutines.internal.f(this, dVar);
    }

    @Override // p8.a, p8.f
    public p8.f minusKey(f.c<?> cVar) {
        return e.a.b(this, cVar);
    }

    public String toString() {
        return e0.a(this) + '@' + e0.b(this);
    }
}
