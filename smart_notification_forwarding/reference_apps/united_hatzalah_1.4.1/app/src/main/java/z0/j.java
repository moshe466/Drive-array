package z0;

import java.util.List;
import t2.AbstractC0707i;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6834a;

    public j(List list) {
        this.f6834a = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && j.class.equals(obj.getClass())) {
            return this.f6834a.equals(((j) obj).f6834a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6834a.hashCode();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, java.lang.Iterable] */
    public final String toString() {
        return AbstractC0707i.h0(this.f6834a, ", ", "WindowLayoutInfo{ DisplayFeatures[", "] }", null, 56);
    }
}
