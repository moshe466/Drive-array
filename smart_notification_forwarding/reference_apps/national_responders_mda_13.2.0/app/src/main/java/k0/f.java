package k0;

import androidx.lifecycle.a0;
import x8.l;
import y8.k;

/* loaded from: classes.dex */
public final class f<T extends a0> {

    /* renamed from: a, reason: collision with root package name */
    private final Class<T> f11126a;

    /* renamed from: b, reason: collision with root package name */
    private final l<a, T> f11127b;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Class<T> cls, l<? super a, ? extends T> lVar) {
        k.e(cls, "clazz");
        k.e(lVar, "initializer");
        this.f11126a = cls;
        this.f11127b = lVar;
    }

    public final Class<T> a() {
        return this.f11126a;
    }

    public final l<a, T> b() {
        return this.f11127b;
    }
}
