package s1;

import java.util.ArrayList;

/* renamed from: s1.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0674n extends x {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f6304a;

    public C0674n(ArrayList arrayList) {
        this.f6304a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof x) {
            return this.f6304a.equals(((C0674n) ((x) obj)).f6304a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f6304a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return "BatchedLogRequest{logRequests=" + this.f6304a + "}";
    }
}
