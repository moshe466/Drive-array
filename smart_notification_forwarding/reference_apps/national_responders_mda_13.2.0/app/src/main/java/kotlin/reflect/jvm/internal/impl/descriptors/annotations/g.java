package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Iterator;
import java.util.List;
import m8.o;

/* loaded from: classes.dex */
public interface g extends Iterable<c>, z8.a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f11362b = a.f11363a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f11363a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final g f11364b = new C0231a();

        /* renamed from: kotlin.reflect.jvm.internal.impl.descriptors.annotations.g$a$a, reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0231a implements g {
            C0231a() {
            }

            public Void c(la.b bVar) {
                y8.k.e(bVar, "fqName");
                return null;
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
            public /* bridge */ /* synthetic */ c e(la.b bVar) {
                return (c) c(bVar);
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
            public boolean isEmpty() {
                return true;
            }

            @Override // java.lang.Iterable
            public Iterator<c> iterator() {
                return o.d().iterator();
            }

            @Override // kotlin.reflect.jvm.internal.impl.descriptors.annotations.g
            public boolean r(la.b bVar) {
                return b.b(this, bVar);
            }

            public String toString() {
                return "EMPTY";
            }
        }

        private a() {
        }

        public final g a(List<? extends c> list) {
            y8.k.e(list, "annotations");
            return list.isEmpty() ? f11364b : new h(list);
        }

        public final g b() {
            return f11364b;
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public static c a(g gVar, la.b bVar) {
            c cVar;
            y8.k.e(gVar, "this");
            y8.k.e(bVar, "fqName");
            Iterator<c> it = gVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = it.next();
                if (y8.k.a(cVar.f(), bVar)) {
                    break;
                }
            }
            return cVar;
        }

        public static boolean b(g gVar, la.b bVar) {
            y8.k.e(gVar, "this");
            y8.k.e(bVar, "fqName");
            return gVar.e(bVar) != null;
        }
    }

    c e(la.b bVar);

    boolean isEmpty();

    boolean r(la.b bVar);
}
