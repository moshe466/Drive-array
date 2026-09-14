package S1;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class o implements K1.n {

    /* renamed from: a, reason: collision with root package name */
    public static final Logger f2152a = Logger.getLogger(o.class.getName());

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f2153b = {0};

    /* renamed from: c, reason: collision with root package name */
    public static final o f2154c = new Object();

    @Override // K1.n
    public final Class a() {
        return K1.j.class;
    }

    @Override // K1.n
    public final Object b(K1.m mVar) {
        byte[] copyOf;
        Iterator it = ((ConcurrentMap) mVar.f1102a).values().iterator();
        while (it.hasNext()) {
            for (K1.k kVar : (List) it.next()) {
                K1.b bVar = kVar.f1100h;
                if (bVar instanceof m) {
                    m mVar2 = (m) bVar;
                    byte[] bArr = kVar.f1095c;
                    if (bArr == null) {
                        copyOf = null;
                    } else {
                        copyOf = Arrays.copyOf(bArr, bArr.length);
                    }
                    Y1.a a2 = Y1.a.a(copyOf);
                    if (!a2.equals(mVar2.b())) {
                        throw new GeneralSecurityException("Mac Key with parameters " + mVar2.c() + " has wrong output prefix (" + mVar2.b() + ") instead of (" + a2 + ")");
                    }
                }
            }
        }
        return new n(mVar);
    }

    @Override // K1.n
    public final Class c() {
        return K1.j.class;
    }
}
