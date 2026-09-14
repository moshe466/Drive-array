package a5;

import com.google.gson.x;
import com.google.gson.y;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class b implements y {

    /* renamed from: f, reason: collision with root package name */
    private final z4.c f194f;

    /* loaded from: classes.dex */
    private static final class a<E> extends x<Collection<E>> {

        /* renamed from: a, reason: collision with root package name */
        private final x<E> f195a;

        /* renamed from: b, reason: collision with root package name */
        private final z4.i<? extends Collection<E>> f196b;

        public a(com.google.gson.e eVar, Type type, x<E> xVar, z4.i<? extends Collection<E>> iVar) {
            this.f195a = new m(eVar, xVar, type);
            this.f196b = iVar;
        }

        @Override // com.google.gson.x
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Collection<E> b(f5.a aVar) {
            if (aVar.m0() == f5.b.NULL) {
                aVar.i0();
                return null;
            }
            Collection<E> a10 = this.f196b.a();
            aVar.c();
            while (aVar.N()) {
                a10.add(this.f195a.b(aVar));
            }
            aVar.v();
            return a10;
        }

        @Override // com.google.gson.x
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(f5.c cVar, Collection<E> collection) {
            if (collection == null) {
                cVar.b0();
                return;
            }
            cVar.f();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f195a.d(cVar, it.next());
            }
            cVar.v();
        }
    }

    public b(z4.c cVar) {
        this.f194f = cVar;
    }

    @Override // com.google.gson.y
    public <T> x<T> a(com.google.gson.e eVar, e5.a<T> aVar) {
        Type e10 = aVar.e();
        Class<? super T> c10 = aVar.c();
        if (!Collection.class.isAssignableFrom(c10)) {
            return null;
        }
        Type h10 = z4.b.h(e10, c10);
        return new a(eVar, h10, eVar.k(e5.a.b(h10)), this.f194f.a(aVar));
    }
}
