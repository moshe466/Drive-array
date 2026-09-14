package R1;

import java.util.Objects;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final Class f2011a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f2012b;

    public q(Class cls, Class cls2) {
        this.f2011a = cls;
        this.f2012b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        if (!qVar.f2011a.equals(this.f2011a) || !qVar.f2012b.equals(this.f2012b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(this.f2011a, this.f2012b);
    }

    public final String toString() {
        return this.f2011a.getSimpleName() + " with serialization type: " + this.f2012b.getSimpleName();
    }
}
