package z0;

import J.p0;
import w0.C0746b;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final C0746b f6835a;

    /* renamed from: b, reason: collision with root package name */
    public final p0 f6836b;

    public k(C0746b c0746b, p0 _windowInsetsCompat) {
        kotlin.jvm.internal.j.e(_windowInsetsCompat, "_windowInsetsCompat");
        this.f6835a = c0746b;
        this.f6836b = _windowInsetsCompat;
    }

    public final boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!k.class.equals(cls)) {
            return false;
        }
        kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type androidx.window.layout.WindowMetrics");
        k kVar = (k) obj;
        if (kotlin.jvm.internal.j.a(this.f6835a, kVar.f6835a) && kotlin.jvm.internal.j.a(this.f6836b, kVar.f6836b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6836b.hashCode() + (this.f6835a.hashCode() * 31);
    }

    public final String toString() {
        return "WindowMetrics( bounds=" + this.f6835a + ", windowInsetsCompat=" + this.f6836b + ')';
    }
}
