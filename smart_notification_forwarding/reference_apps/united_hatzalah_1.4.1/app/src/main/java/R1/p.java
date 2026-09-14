package R1;

import java.util.Objects;

/* loaded from: classes.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final Class f2009a;

    /* renamed from: b, reason: collision with root package name */
    public final Y1.a f2010b;

    public p(Class cls, Y1.a aVar) {
        this.f2009a = cls;
        this.f2010b = aVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        if (!pVar.f2009a.equals(this.f2009a) || !pVar.f2010b.equals(this.f2010b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(this.f2009a, this.f2010b);
    }

    public final String toString() {
        return this.f2009a.getSimpleName() + ", object identifier: " + this.f2010b;
    }
}
