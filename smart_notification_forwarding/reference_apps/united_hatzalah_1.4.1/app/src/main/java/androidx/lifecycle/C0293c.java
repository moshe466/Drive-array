package androidx.lifecycle;

import java.lang.reflect.Method;

/* renamed from: androidx.lifecycle.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0293c {

    /* renamed from: a, reason: collision with root package name */
    public final int f3597a;

    /* renamed from: b, reason: collision with root package name */
    public final Method f3598b;

    public C0293c(int i, Method method) {
        this.f3597a = i;
        this.f3598b = method;
        method.setAccessible(true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0293c)) {
            return false;
        }
        C0293c c0293c = (C0293c) obj;
        if (this.f3597a == c0293c.f3597a && this.f3598b.getName().equals(c0293c.f3598b.getName())) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f3598b.getName().hashCode() + (this.f3597a * 31);
    }
}
