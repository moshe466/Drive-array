package h9;

import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    private static kb.b<String, Object> f10541a;

    static {
        kb.b<String, Object> b10 = kb.b.b();
        y8.k.d(b10, "HashPMap.empty<String, Any>()");
        f10541a = b10;
    }

    public static final <T> h<T> a(Class<T> cls) {
        h<T> hVar;
        kb.b<String, Object> f10;
        String str;
        y8.k.e(cls, "jClass");
        String name = cls.getName();
        Object c10 = f10541a.c(name);
        if (c10 instanceof WeakReference) {
            h<T> hVar2 = (h) ((WeakReference) c10).get();
            if (y8.k.a(hVar2 != null ? hVar2.b() : null, cls)) {
                return hVar2;
            }
        } else if (c10 != null) {
            for (WeakReference weakReference : (WeakReference[]) c10) {
                h<T> hVar3 = (h) weakReference.get();
                if (y8.k.a(hVar3 != null ? hVar3.b() : null, cls)) {
                    return hVar3;
                }
            }
            int length = ((Object[]) c10).length;
            WeakReference[] weakReferenceArr = new WeakReference[length + 1];
            System.arraycopy(c10, 0, weakReferenceArr, 0, length);
            hVar = new h<>(cls);
            weakReferenceArr[length] = new WeakReference(hVar);
            f10 = f10541a.f(name, weakReferenceArr);
            str = "K_CLASS_CACHE.plus(name, newArray)";
            y8.k.d(f10, str);
            f10541a = f10;
            return hVar;
        }
        hVar = new h<>(cls);
        f10 = f10541a.f(name, new WeakReference(hVar));
        str = "K_CLASS_CACHE.plus(name, WeakReference(newKClass))";
        y8.k.d(f10, str);
        f10541a = f10;
        return hVar;
    }
}
