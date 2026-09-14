package androidx.lifecycle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: androidx.lifecycle.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0292b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f3595a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f3596b;

    public C0292b(HashMap hashMap) {
        this.f3596b = hashMap;
        for (Map.Entry entry : hashMap.entrySet()) {
            EnumC0303m enumC0303m = (EnumC0303m) entry.getValue();
            List list = (List) this.f3595a.get(enumC0303m);
            if (list == null) {
                list = new ArrayList();
                this.f3595a.put(enumC0303m, list);
            }
            list.add((C0293c) entry.getKey());
        }
    }

    public static void a(List list, InterfaceC0309t interfaceC0309t, EnumC0303m enumC0303m, Object obj) {
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                C0293c c0293c = (C0293c) list.get(size);
                Method method = c0293c.f3598b;
                try {
                    int i = c0293c.f3597a;
                    if (i != 0) {
                        if (i != 1) {
                            if (i == 2) {
                                method.invoke(obj, interfaceC0309t, enumC0303m);
                            }
                        } else {
                            method.invoke(obj, interfaceC0309t);
                        }
                    } else {
                        method.invoke(obj, null);
                    }
                } catch (IllegalAccessException e4) {
                    throw new RuntimeException(e4);
                } catch (InvocationTargetException e5) {
                    throw new RuntimeException("Failed to call observer method", e5.getCause());
                }
            }
        }
    }
}
