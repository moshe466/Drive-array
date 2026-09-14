package o9;

import bb.b0;
import java.util.Collection;
import java.util.List;
import m8.q;
import n9.u0;
import y8.k;

/* loaded from: classes.dex */
public interface a {

    /* renamed from: o9.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class C0266a implements a {

        /* renamed from: a, reason: collision with root package name */
        public static final C0266a f12629a = new C0266a();

        private C0266a() {
        }

        @Override // o9.a
        public Collection<n9.d> a(n9.e eVar) {
            List d10;
            k.e(eVar, "classDescriptor");
            d10 = q.d();
            return d10;
        }

        @Override // o9.a
        public Collection<la.e> b(n9.e eVar) {
            List d10;
            k.e(eVar, "classDescriptor");
            d10 = q.d();
            return d10;
        }

        @Override // o9.a
        public Collection<b0> d(n9.e eVar) {
            List d10;
            k.e(eVar, "classDescriptor");
            d10 = q.d();
            return d10;
        }

        @Override // o9.a
        public Collection<u0> e(la.e eVar, n9.e eVar2) {
            List d10;
            k.e(eVar, "name");
            k.e(eVar2, "classDescriptor");
            d10 = q.d();
            return d10;
        }
    }

    Collection<n9.d> a(n9.e eVar);

    Collection<la.e> b(n9.e eVar);

    Collection<b0> d(n9.e eVar);

    Collection<u0> e(la.e eVar, n9.e eVar2);
}
