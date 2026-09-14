package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class l9 {

    /* renamed from: c, reason: collision with root package name */
    private static final l9 f5459c = new l9();

    /* renamed from: b, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, p9<?>> f5461b = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    private final o9 f5460a = new k8();

    private l9() {
    }

    public static l9 a() {
        return f5459c;
    }

    public final <T> p9<T> b(Class<T> cls) {
        o7.f(cls, "messageType");
        p9<T> p9Var = (p9) this.f5461b.get(cls);
        if (p9Var != null) {
            return p9Var;
        }
        p9<T> a10 = this.f5460a.a(cls);
        o7.f(cls, "messageType");
        o7.f(a10, "schema");
        p9<T> p9Var2 = (p9) this.f5461b.putIfAbsent(cls, a10);
        return p9Var2 != null ? p9Var2 : a10;
    }

    public final <T> p9<T> c(T t10) {
        return b(t10.getClass());
    }
}
