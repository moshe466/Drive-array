package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import nb.i1;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public static final t f11658a;

    /* renamed from: b, reason: collision with root package name */
    private static final boolean f11659b;

    /* renamed from: c, reason: collision with root package name */
    public static final i1 f11660c;

    static {
        t tVar = new t();
        f11658a = tVar;
        f11659b = c0.e("kotlinx.coroutines.fast.service.loader", true);
        f11660c = tVar.a();
    }

    private t() {
    }

    private final i1 a() {
        lb.h a10;
        List<r> w10;
        Object next;
        try {
            if (f11659b) {
                w10 = i.f11628a.c();
            } else {
                a10 = lb.l.a(s.a());
                w10 = lb.n.w(a10);
            }
            Iterator<T> it = w10.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((r) next).getLoadPriority();
                    do {
                        Object next2 = it.next();
                        int loadPriority2 = ((r) next2).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            next = next2;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            r rVar = (r) next;
            i1 e10 = rVar == null ? null : u.e(rVar, w10);
            return e10 == null ? u.b(null, null, 3, null) : e10;
        } catch (Throwable th) {
            return u.b(th, null, 2, null);
        }
    }
}
