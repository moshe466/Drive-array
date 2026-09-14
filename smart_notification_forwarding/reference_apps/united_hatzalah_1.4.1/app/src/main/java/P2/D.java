package P2;

import F0.AbstractC0008a;
import w2.AbstractC0760a;

/* loaded from: classes.dex */
public final class D extends AbstractC0760a {

    /* renamed from: c, reason: collision with root package name */
    public static final B f1596c = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final String f1597b;

    public D() {
        super(f1596c);
        this.f1597b = "TrueTime-Syncer";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof D) && kotlin.jvm.internal.j.a(this.f1597b, ((D) obj).f1597b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f1597b.hashCode();
    }

    public final String toString() {
        return AbstractC0008a.s(new StringBuilder("CoroutineName("), this.f1597b, ')');
    }
}
