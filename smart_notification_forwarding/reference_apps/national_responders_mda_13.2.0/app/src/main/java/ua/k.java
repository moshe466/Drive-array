package ua;

import java.util.Collection;

/* loaded from: classes.dex */
public interface k {

    /* loaded from: classes.dex */
    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Collection a(k kVar, d dVar, x8.l lVar, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContributedDescriptors");
            }
            if ((i10 & 1) != 0) {
                dVar = d.f14517o;
            }
            if ((i10 & 2) != 0) {
                lVar = h.f14537a.a();
            }
            return kVar.e(dVar, lVar);
        }
    }

    Collection<n9.m> e(d dVar, x8.l<? super la.e, Boolean> lVar);

    n9.h g(la.e eVar, u9.b bVar);
}
