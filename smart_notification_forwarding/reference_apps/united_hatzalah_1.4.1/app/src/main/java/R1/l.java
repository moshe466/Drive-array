package R1;

import java.util.Objects;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final Class f1998a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f1999b;

    public l(Class cls, Class cls2) {
        this.f1998a = cls;
        this.f1999b = cls2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        if (!lVar.f1998a.equals(this.f1998a) || !lVar.f1999b.equals(this.f1999b)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hash(this.f1998a, this.f1999b);
    }

    public final String toString() {
        return this.f1998a.getSimpleName() + " with primitive type: " + this.f1999b.getSimpleName();
    }
}
