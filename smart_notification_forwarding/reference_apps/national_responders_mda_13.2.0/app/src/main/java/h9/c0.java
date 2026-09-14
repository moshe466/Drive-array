package h9;

import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes.dex */
public final class c0 {

    /* renamed from: a, reason: collision with root package name */
    private static final ConcurrentMap<l0, WeakReference<r9.k>> f10503a = new ConcurrentHashMap();

    public static final r9.k a(Class<?> cls) {
        y8.k.e(cls, "$this$getOrCreateModule");
        ClassLoader f10 = s9.b.f(cls);
        l0 l0Var = new l0(f10);
        ConcurrentMap<l0, WeakReference<r9.k>> concurrentMap = f10503a;
        WeakReference<r9.k> weakReference = concurrentMap.get(l0Var);
        if (weakReference != null) {
            r9.k kVar = weakReference.get();
            if (kVar != null) {
                y8.k.d(kVar, "it");
                return kVar;
            }
            concurrentMap.remove(l0Var, weakReference);
        }
        r9.k a10 = r9.k.f13815c.a(f10);
        while (true) {
            try {
                ConcurrentMap<l0, WeakReference<r9.k>> concurrentMap2 = f10503a;
                WeakReference<r9.k> putIfAbsent = concurrentMap2.putIfAbsent(l0Var, new WeakReference<>(a10));
                if (putIfAbsent == null) {
                    return a10;
                }
                r9.k kVar2 = putIfAbsent.get();
                if (kVar2 != null) {
                    return kVar2;
                }
                concurrentMap2.remove(l0Var, putIfAbsent);
            } finally {
                l0Var.a(null);
            }
        }
    }
}
