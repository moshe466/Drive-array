package S1;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class h implements K1.n {

    /* renamed from: a, reason: collision with root package name */
    public static final h f2138a = new Object();

    @Override // K1.n
    public final Class a() {
        return f.class;
    }

    @Override // K1.n
    public final Object b(K1.m mVar) {
        if (((K1.k) mVar.f1104c) != null) {
            Iterator it = ((ConcurrentMap) mVar.f1102a).values().iterator();
            while (it.hasNext()) {
                Iterator it2 = ((List) it.next()).iterator();
                while (it2.hasNext()) {
                }
            }
            return new Object();
        }
        throw new GeneralSecurityException("no primary in primitive set");
    }

    @Override // K1.n
    public final Class c() {
        return f.class;
    }
}
