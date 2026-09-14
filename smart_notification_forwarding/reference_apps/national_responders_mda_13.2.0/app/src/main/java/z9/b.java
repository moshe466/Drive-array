package z9;

import ca.n;
import ca.r;
import ca.w;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import m8.q;
import m8.r0;

/* loaded from: classes.dex */
public interface b {

    /* loaded from: classes.dex */
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        public static final a f16255a = new a();

        private a() {
        }

        @Override // z9.b
        public Set<la.e> a() {
            Set<la.e> b10;
            b10 = r0.b();
            return b10;
        }

        @Override // z9.b
        public Set<la.e> b() {
            Set<la.e> b10;
            b10 = r0.b();
            return b10;
        }

        @Override // z9.b
        public w c(la.e eVar) {
            y8.k.e(eVar, "name");
            return null;
        }

        @Override // z9.b
        public Set<la.e> d() {
            Set<la.e> b10;
            b10 = r0.b();
            return b10;
        }

        @Override // z9.b
        public n f(la.e eVar) {
            y8.k.e(eVar, "name");
            return null;
        }

        @Override // z9.b
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public List<r> e(la.e eVar) {
            List<r> d10;
            y8.k.e(eVar, "name");
            d10 = q.d();
            return d10;
        }
    }

    Set<la.e> a();

    Set<la.e> b();

    w c(la.e eVar);

    Set<la.e> d();

    Collection<r> e(la.e eVar);

    n f(la.e eVar);
}
