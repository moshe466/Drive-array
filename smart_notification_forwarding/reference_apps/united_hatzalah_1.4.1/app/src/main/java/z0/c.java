package z0;

import w0.C0746b;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final C0746b f6817a;

    /* renamed from: b, reason: collision with root package name */
    public final b f6818b;

    /* renamed from: c, reason: collision with root package name */
    public final b f6819c;

    public c(C0746b c0746b, b bVar, b bVar2) {
        int i = c0746b.f6683b;
        this.f6817a = c0746b;
        this.f6818b = bVar;
        this.f6819c = bVar2;
        int i3 = c0746b.f6684c;
        int i4 = c0746b.f6682a;
        if (i3 - i4 == 0 && c0746b.f6685d - i == 0) {
            throw new IllegalArgumentException("Bounds must be non zero");
        }
        if (i4 != 0 && i != 0) {
            throw new IllegalArgumentException("Bounding rectangle must start at the top or left window edge for folding features");
        }
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
        if (!c.class.equals(cls)) {
            return false;
        }
        kotlin.jvm.internal.j.c(obj, "null cannot be cast to non-null type androidx.window.layout.HardwareFoldingFeature");
        c cVar = (c) obj;
        if (kotlin.jvm.internal.j.a(this.f6817a, cVar.f6817a) && kotlin.jvm.internal.j.a(this.f6818b, cVar.f6818b) && kotlin.jvm.internal.j.a(this.f6819c, cVar.f6819c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6819c.hashCode() + ((this.f6818b.hashCode() + (this.f6817a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return c.class.getSimpleName() + " { " + this.f6817a + ", type=" + this.f6818b + ", state=" + this.f6819c + " }";
    }
}
